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
		String matricula = params['search.matricula']
		String folio = params['search.folio']
		
		String nombre = params['search.nombre']
		String apaterno = params['search.apaterno']
		String amaterno = params['search.amaterno']
		
		String insititucionId = params['search.institucion.id']
		String sitAutId = params['search.situacionAutorizacion.id']
		String pvencimiento = params['search.pvencimiento']
		
		def tipoAutIds = params.list('search.tipoAutorizacionId')
		
		//consultaAutorizadosService.buscaAutorizados(0, 0, nombre, apaterno, amaterno, insititucionId, sitAutId, pvencimiento, tipoAutIds)
		
	}
	
	def showJsonResults() {
		
	}

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
