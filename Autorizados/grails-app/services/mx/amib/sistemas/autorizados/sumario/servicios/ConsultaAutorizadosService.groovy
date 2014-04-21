package mx.amib.sistemas.autorizados.sumario.servicios

import mx.amib.sistemas.autorizados.sumario.ConsultaAutorizados
import org.hibernate.criterion.*

class ConsultaAutorizadosService {

    def buscaAutorizados(int matricula, int folio, String nombre, 
		String apaterno, String amaterno, String insititucionId, 
		String sitAutId, String pvencimiento, def tipoAutIds) {
		
		def criteria = ConsultaAutorizados.createCriteria()
		
		if(matricula != null){
			criteria.add(Expression.eq('nuMatricula',matricula))
		}
		if(folio != null){
			criteria.add(Expression.eq('nuFolio',folio))
		}
		if(nombre != null){
			criteria.add(Expression.eq('nbNombre',nombre))
		}
		if(apaterno != null){
			criteria.add(Expression.eq('nbApaterno',apaterno))
		}
		if(amaterno != null){
			criteria.add(Expression.eq('nbAmaterno',amaterno))
		}
		if(insititucionId != null){
			criteria.add(Expression.idEq('idInstitucion',insititucionId))
		}
		if(sitAutId != null){
			criteria.add(Expression.idEq('idSituacionaut',sitAutId))
		}
		
		if(tipoAutIds != null || tipoAutIds.size() > 0){
			criteria.add(Expression.in('idTpautorizacion',tipoAutIds))
		}
		
    }
}
