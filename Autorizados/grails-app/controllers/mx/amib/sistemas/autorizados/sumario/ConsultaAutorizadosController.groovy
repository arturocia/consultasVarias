package mx.amib.sistemas.autorizados.sumario

import mx.amib.sistemas.autorizados.sumario.servicios.ConsultaAutorizadosService

import org.springframework.dao.DataIntegrityViolationException

class ConsultaAutorizadosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	ConsultaAutorizadosService consultaAutorizadosService
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [consultaAutorizadosInstanceList: ConsultaAutorizados.list(params), consultaAutorizadosInstanceTotal: ConsultaAutorizados.count()]
    }
	
	def search() {
		
	}
	
	def showResults() {
		
		/* INICIA - OBTENCION Y FILTRO DE PARAMETROS */
		
		String matricula = params['search.matricula']
		String folio = params['search.folio']
		int pMatricula = -1
		int pFolio = -1
		
		String nombre = params['search.nombre']
		String apaterno = params['search.apaterno']
		String amaterno = params['search.amaterno']
		
		String insititucionId = params['search.institucion.id']
		String sitAutId = params['search.situacionAutorizacion.id']
		int pInstitucionId = -1
		int pSitAutId = -1
		
		String pvencimiento = params['search.pvencimiento']
		PeriodoVencimiento pppvencimiento = null
		
		def tipoAutIds = params.list('search.tipoAutorizacionId')
		List<Integer> pTipoAutIds = new ArrayList<Integer>()
		
		try {
			pMatricula = Integer.parseInt(matricula)
		}
		catch(NumberFormatException nex){
			pMatricula = -1
		}
		
		try{
			pFolio = Integer.parseInt(folio)
		}
		catch(NumberFormatException nex){
			pFolio = -1
		}
		
		try {
			pInstitucionId = Integer.parseInt(insititucionId)
		}
		catch(NumberFormatException nex){
			pInstitucionId = -1
		}
		
		try{
			pSitAutId = Integer.parseInt(sitAutId)
		}
		catch(NumberFormatException nex){
			pSitAutId = -1
		}
		
		switch(pvencimiento){
			case 1:
				pppvencimiento = PeriodoVencimiento.UN_MES
				break;
			case 2:
				pppvencimiento = PeriodoVencimiento.TRES_MESES
				break;
			case 3:
				pppvencimiento = PeriodoVencimiento.SEIS_MESES
				break;
			case 4:
				pppvencimiento = PeriodoVencimiento.NUEVE_MESES
				break;
			case 5:
				pppvencimiento = PeriodoVencimiento.DOCE_MESES
				break;
			case 6:
				pppvencimiento = null
				break;
		}
		
		nombre = nombre?.trim()
		apaterno = apaterno?.trim()
		amaterno = amaterno?.trim()
		
		tipoAutIds.each {
			try{
				pTipoAutIds.add(Integer.parseInt(it))
			}
			catch(NumberFormatException nex){
				pTipoAutIds.add(-1)
			}
		}
		
		
		/* FIN - OBTENCION Y FILTRO DE PARAMETROS */
		
		def resultList = consultaAutorizadosService.buscaAutorizados(pMatricula, pFolio, nombre, apaterno, amaterno, pInstitucionId, pSitAutId, pppvencimiento, pTipoAutIds)
		
		[consultaAutorizadosInstanceList: resultList, consultaAutorizadosInstanceListTotal: resultList?.size()]
	}
	
	/*def showJsonResults() {
		
	}*/

    def show(Long id) {
        def consultaAutorizadosInstance = ConsultaAutorizados.get(id)
        if (!consultaAutorizadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), id])
            redirect(action: "list")
            return
        }

        [consultaAutorizadosInstance: consultaAutorizadosInstance]
    }
}
