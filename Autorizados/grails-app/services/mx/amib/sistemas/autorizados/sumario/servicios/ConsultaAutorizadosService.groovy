package mx.amib.sistemas.autorizados.sumario.servicios

import mx.amib.sistemas.autorizados.sumario.ConsultaAutorizados
import mx.amib.sistemas.autorizados.sumario.PeriodoVencimientoEnum
import mx.amib.sistemas.autorizados.sumario.catalogo.Institucion
import mx.amib.sistemas.autorizados.sumario.catalogo.SituacionAutorizacionAltEnum
import org.hibernate.criterion.*

class ConsultaAutorizadosService {

    List<ConsultaAutorizados> buscaAutorizados(Integer matricula, Integer folio, String nombre, 
		String apaterno, String amaterno, Integer insititucionId, 
		SituacionAutorizacionAltEnum sitAutAlt, PeriodoVencimientoEnum pvencimiento, List<Integer> tipoAutIds, 
		int offset, int recordsToObtain) {
		
		def criteria = ConsultaAutorizados.createCriteria()
		def today = new Date()
		
		return criteria.list (max:recordsToObtain,offset:offset) {
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
			
			if(sitAutAlt != SituacionAutorizacionAltEnum.TODOS){
				if(sitAutAlt == SituacionAutorizacionAltEnum.EN_AUTORIZACION){
					eq('idSituacionaut',3)
				}
				else if(sitAutAlt == SituacionAutorizacionAltEnum.AUTORIZADO_CON_PODERES){
					eq('idSituacionaut',6)
				}
				else if(sitAutAlt == SituacionAutorizacionAltEnum.AUTORIZADO_SIN_PODERES){
					eq('idSituacionaut',4)
				}
				else if(sitAutAlt == SituacionAutorizacionAltEnum.AUTORIZADO_EN_SEGUNDA){
					'in'('idSituacionaut',[10,11,12])
				}
				else if(sitAutAlt == SituacionAutorizacionAltEnum.AUTORIZADO_TODO){
					'in'('idSituacionaut',[4, 6, 10,11,12])
				}
				else if(sitAutAlt == SituacionAutorizacionAltEnum.REVOCADO){
					eq('idSituacionaut',8)
				}
				/*else if(sitAutAlt == SituacionAutorizacionAltEnum.INCONSISTENTE){
				
				}*/
			}
			
			switch(pvencimiento){
				case PeriodoVencimientoEnum.UN_MES:
					between("fhFinvigencia",today,today.plus(31))
				break;
				case PeriodoVencimientoEnum.TRES_MESES:
					between("fhFinvigencia",today,today.plus(93))
				break;
				case PeriodoVencimientoEnum.SEIS_MESES:
					between("fhFinvigencia",today,today.plus(186))
				break;
				case PeriodoVencimientoEnum.NUEVE_MESES:
					between("fhFinvigencia",today,today.plus(279))
				break;
				case PeriodoVencimientoEnum.DOCE_MESES:
					between("fhFinvigencia",today,today.plus(366))
				break;
				default:
				break;
			}
			
			if(tipoAutIds != null && tipoAutIds.size() > 0) {
				'in'('idTpautorizacion',tipoAutIds)
			}
			
		}
    }
		
	List<Institucion> listaInstitucionesVigentes(){
		return Institucion.findAllByStVigente(true, sort:"nbInstitucion")
	}
}
