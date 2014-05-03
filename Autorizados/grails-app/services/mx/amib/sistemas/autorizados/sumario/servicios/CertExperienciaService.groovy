package mx.amib.sistemas.autorizados.sumario.servicios
import java.sql.SQLException;

import groovy.sql.Sql
import org.apache.poi.ss.usermodel.Cell
import java.text.DecimalFormat

class CertExperienciaService {
	def dataSource

	static transactional = true

	def guardaExcel(mapaCeldas) {
		Integer contador=0
		String columnasAInsertarStr=null
		String placeHoldersStr=null
		String queryStr=null
		Set<String> listaColumnas=null
		List<String> valores=null
		def sql = new Sql(dataSource)
		//		def mapaCeldasFiltrado=[:]

		log.debug("suelta...")

		//XXX: http://stackoverflow.com/questions/16860826/removing-a-given-key-from-a-groovy-map
		//		mapaCeldasFiltrado << mapaCeldas
		//		mapaCeldasFiltrado.remove("nombreCompleto")
		mapaCeldas[0].remove("nombreCompleto")
		listaColumnas=mapaCeldas[0].keySet()
		columnasAInsertarStr=listaColumnas.join(",")
		// XXX: http://groovy.codehaus.org/Operators#Operators-SpreadOperator(*.)
		placeHoldersStr="?,"*(listaColumnas.size()-1)
		placeHoldersStr+="?"
		queryStr="insert into t010_d_certexperiencia (${columnasAInsertarStr})  values (${placeHoldersStr})"
		log.debug("el liston de tus pelos ${columnasAInsertarStr}")
		log.debug("Venga la sentencia ${queryStr}")
		try{
			for (mapaCelda in mapaCeldas) {
				mapaCelda.remove("nombreCompleto")
				// XXX: http://webpages.charter.net/weiqigao/2006/12/07/you_wont_believe_this_but_the_arrow_operator_is_coming_to_java_7.html
				// XXX: http://stackoverflow.com/questions/4560546/how-do-i-round-a-number-in-groovy
				valores=mapaCelda.values().toList().collect{valor -> return valor in Double?new DecimalFormat("#").format(valor):valor}*.toString()
//				mapaCelda.values().toList().collect{valor -> log.debug("el tipo de ${valor} es "+valor.class)}
//				log.debug("valores ${valores}")
				log.debug("en la insercion ${contador}")
				sql.execute(queryStr,valores)
				contador++
			}
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
