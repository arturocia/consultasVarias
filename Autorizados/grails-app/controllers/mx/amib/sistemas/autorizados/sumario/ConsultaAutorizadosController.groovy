package mx.amib.sistemas.autorizados.sumario

import mx.amib.sistemas.autorizados.sumario.catalogo.SituacionAutorizacionAltEnum
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
		int pInstitucionId = -1
		SituacionAutorizacionAltEnum sitAutAlt = params['search.situacionAutorizacion']
		PeriodoVencimientoEnum pppvencimiento = params['search.pvencimiento']
		def tipoAutIds = params.list('search.tipoAutorizacion')
		List<Integer> pTipoAutIds = new ArrayList<Integer>()
		
		String offset = params['offset']
		int poffset
		int resultsToDisplay = 10
		
		
		try {
			pMatricula = Integer.parseInt(matricula?.trim())
		}
		catch(NumberFormatException nex){
			pMatricula = -1
		}
		try{
			pFolio = Integer.parseInt(folio?.trim())
		}
		catch(NumberFormatException nex){
			pFolio = -1
		}
		try {
			pInstitucionId = Integer.parseInt(insititucionId?.trim())
		}
		catch(NumberFormatException nex){
			pInstitucionId = -1
		}
		try {
			poffset = Integer.parseInt(offset?.trim())
		}
		catch(NumberFormatException nex){
			poffset = 0
		}
		nombre = nombre?.trim()
		apaterno = apaterno?.trim()
		amaterno = amaterno?.trim()
		tipoAutIds.each {
			try{
				pTipoAutIds.add(Integer.parseInt(it.trim()))
			}
			catch(NumberFormatException nex){
				pTipoAutIds.add(-1)
			}
		}
		/* FIN - OBTENCION Y FILTRO DE PARAMETROS */
		
		def resultList = consultaAutorizadosService.buscaAutorizados(pMatricula, pFolio, nombre, apaterno, amaterno, 
																		pInstitucionId, sitAutAlt, pppvencimiento, 
																		pTipoAutIds, poffset, resultsToDisplay)
		
		[consultaAutorizadosInstanceList: resultList, consultaAutorizadosInstanceListTotal: resultList?.totalCount, 
			consultaAutorizadosInstanceListOffset: offset, resultsToDisplay: resultsToDisplay, 
			params: params ]
	}

	/* Muestra el desgloze de certificaciones, autorizaciones y poderes de un sustentante  */
    def show(Long id) {
		/*
        def consultaAutorizadosInstance = ConsultaAutorizados.get(id)
        if (!consultaAutorizadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), id])
            redirect(action: "list")
            return
        }

        [consultaAutorizadosInstance: consultaAutorizadosInstance]
		*/
    }
}
