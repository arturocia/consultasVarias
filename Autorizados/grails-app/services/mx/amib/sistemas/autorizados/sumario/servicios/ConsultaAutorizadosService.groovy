package mx.amib.sistemas.autorizados.sumario.servicios

import mx.amib.sistemas.autorizados.sumario.ConsultaAutorizados
import mx.amib.sistemas.autorizados.sumario.PeriodoVencimiento
import org.hibernate.criterion.*

class ConsultaAutorizadosService {

    List<ConsultaAutorizados> buscaAutorizados(Integer matricula, Integer folio, String nombre, 
		String apaterno, String amaterno, Integer insititucionId, 
		Integer sitAutId, PeriodoVencimiento pvencimiento, List<Integer> tipoAutIds) {
		
		def criteria = ConsultaAutorizados.createCriteria()

		return criteria.list {
			if(matricula != null && matricula != -1){
				eq('nuMatricula',matricula)
			}
			if(folio != null && folio != -1){
				eq('nuFolio',folio)
			}
			if(nombre != null && nombre != ''){
				eq('nbNombre',nombre)
			}
			if(apaterno != null && apaterno != ''){
				eq('nbApaterno',apaterno)
			}
			if(amaterno != null && amaterno != ''){
				eq('nbAmaterno',amaterno)
			}
			if(insititucionId != null && insititucionId != -1){
				eq('idInstitucion',insititucionId)
			}
			if(sitAutId != null && sitAutId != -1){
				eq('idSituacionaut',sitAutId)
			}
			if(tipoAutIds != null && tipoAutIds.size() > 0) {
				'in'('idTpautorizacion',tipoAutIds)
			}
		}
    }
}
