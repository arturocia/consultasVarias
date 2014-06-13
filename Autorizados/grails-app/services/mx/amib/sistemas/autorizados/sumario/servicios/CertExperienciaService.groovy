package mx.amib.sistemas.autorizados.sumario.servicios
import java.sql.SQLException;

import groovy.sql.Sql
import org.apache.poi.ss.usermodel.Cell
import java.text.DecimalFormat

class CertExperienciaService {
	def dataSource

	static transactional = true

	def guardaExcel(mapaCeldas) {
		Boolean guardaCertExperiencia=true
		String columnasAInsertarStr=null
		String placeHoldersStr=null
		String queryStrDelete=null
		String queryStr=null
		String queryStrExecProd=null
		String nombreTablon=""
		String nombreSp=""
		Set<String> listaColumnas=null
		def sql = new Sql(dataSource)
		//		def mapaCeldasFiltrado=[:]

		log.debug("suelta...")

		//XXX: http://stackoverflow.com/questions/16860826/removing-a-given-key-from-a-groovy-map
		//		mapaCeldasFiltrado << mapaCeldas
		//		mapaCeldasFiltrado.remove("nombreCompleto")
		mapaCeldas[0].remove("nombreCompleto")
		mapaCeldas[0].remove("tx_opcion8")
		mapaCeldas[0].remove("tx_instituto8")
		for (i in 1..8) {
			log.debug("removing trash ${i}")
			mapaCeldas[0].remove("evento"+i)
			mapaCeldas[0].remove("puntos"+i)
		}
		listaColumnas=mapaCeldas[0].keySet()
		guardaCertExperiencia=listaColumnas.size()==15
		log.debug("Se guardara ceerte experiencia? ${guardaCertExperiencia}")
		columnasAInsertarStr=listaColumnas.join(",")
		// XXX: http://groovy.codehaus.org/Operators#Operators-SpreadOperator(*.)
		placeHoldersStr="?,"*(listaColumnas.size()-1)
		placeHoldersStr+="?"
		if(guardaCertExperiencia){
			nombreTablon="t010_d_certexperiencia"
			nombreSp="sp005_incorporaImportadosPorExperiencia"
		}
		else{
			nombreTablon="t009_d_certpuntos"
			nombreSp="sp004_incorporaImportadosPorPuntos"
		}
		// XXX: http://www.danvega.org/blog/2013/8/21/Writing-SQL-in-a-Grails-Application
		queryStrDelete="delete from ${nombreTablon}"
		queryStr="insert into ${nombreTablon} (${columnasAInsertarStr})  values (${placeHoldersStr})"
		queryStrExecProd="{call ${nombreSp}}"
		log.debug("el liston de tus pelos ${columnasAInsertarStr}")
		log.debug("Venga la sentencia ${queryStr}")
		try{
			sql.execute(queryStrDelete)
			sql.withBatch(100,
					queryStr){ ps ->

						Integer contador=0
						List<String> valores=null

						for (mapaCelda in mapaCeldas) {
							mapaCelda.remove("nombreCompleto")
							mapaCelda.remove("tx_opcion8")
							mapaCelda.remove("tx_instituto8")
							for (i in 1..8) {
								mapaCelda.remove("evento"+i)
								mapaCelda.remove("puntos"+i)
							}
							// XXX: http://webpages.charter.net/weiqigao/2006/12/07/you_wont_believe_this_but_the_arrow_operator_is_coming_to_java_7.html
							// XXX: http://stackoverflow.com/questions/4560546/how-do-i-round-a-number-in-groovy
							//							mapaCelda.values().toList().collect{valor -> valor?log.debug("el tipo de ${valor} es "+valor.class):log.debug("valor mulo!")}
							valores=mapaCelda.values().toList().collect{valor ->
								return valor? valor in Double?new DecimalFormat("#").format(valor):valor :"NA"}*.toString()
							//							valores.collect{valor -> valor?log.debug("el tipo convertido de ${valor} es "+valor.class):log.debug("valor mulo!")}
							//							log.debug("valores ${valores}")
							log.debug("en la insercion ${contador}")
							ps.addBatch(valores)
							contador++
						}
					}
			sql.call(queryStrExecProd)
		}
		catch(SQLException sqle){
			// XXX: http://stackoverflow.com/questions/17684734/the-conversion-from-unknown-to-unknown-is-unsupported
			while( sqle != null )
			{
				log.debug( "State  : " + sqle.getSQLState()  )
				log.debug( "Message: " + sqle.getMessage()   )
				log.debug( "Error  : " + sqle.getErrorCode() )

				sqle = sqle.getNextException()
			}
		}

		sql.close()
		return true
	}
}

