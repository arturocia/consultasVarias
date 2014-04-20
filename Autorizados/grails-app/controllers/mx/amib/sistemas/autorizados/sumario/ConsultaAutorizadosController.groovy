package mx.amib.sistemas.autorizados.sumario

import org.springframework.dao.DataIntegrityViolationException

class ConsultaAutorizadosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [consultaAutorizadosInstanceList: ConsultaAutorizados.list(params), consultaAutorizadosInstanceTotal: ConsultaAutorizados.count()]
    }
	
	def search() {
		
	}

    def create() {
        [consultaAutorizadosInstance: new ConsultaAutorizados(params)]
    }

    def save() {
        def consultaAutorizadosInstance = new ConsultaAutorizados(params)
        if (!consultaAutorizadosInstance.save(flush: true)) {
            render(view: "create", model: [consultaAutorizadosInstance: consultaAutorizadosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), consultaAutorizadosInstance.id])
        redirect(action: "show", id: consultaAutorizadosInstance.id)
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

    def edit(Long id) {
        def consultaAutorizadosInstance = ConsultaAutorizados.get(id)
        if (!consultaAutorizadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), id])
            redirect(action: "list")
            return
        }

        [consultaAutorizadosInstance: consultaAutorizadosInstance]
    }

    def update(Long id, Long version) {
        def consultaAutorizadosInstance = ConsultaAutorizados.get(id)
        if (!consultaAutorizadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (consultaAutorizadosInstance.version > version) {
                consultaAutorizadosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados')] as Object[],
                          "Another user has updated this ConsultaAutorizados while you were editing")
                render(view: "edit", model: [consultaAutorizadosInstance: consultaAutorizadosInstance])
                return
            }
        }

        consultaAutorizadosInstance.properties = params

        if (!consultaAutorizadosInstance.save(flush: true)) {
            render(view: "edit", model: [consultaAutorizadosInstance: consultaAutorizadosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), consultaAutorizadosInstance.id])
        redirect(action: "show", id: consultaAutorizadosInstance.id)
    }

    def delete(Long id) {
        def consultaAutorizadosInstance = ConsultaAutorizados.get(id)
        if (!consultaAutorizadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), id])
            redirect(action: "list")
            return
        }

        try {
            consultaAutorizadosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'consultaAutorizados.label', default: 'ConsultaAutorizados'), id])
            redirect(action: "show", id: id)
        }
    }
}
