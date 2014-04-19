package mx.amib.sistemas.autorizados.sumario.catalogo

import org.springframework.dao.DataIntegrityViolationException

class TipoAutorizacionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [tipoAutorizacionInstanceList: TipoAutorizacion.list(params), tipoAutorizacionInstanceTotal: TipoAutorizacion.count()]
    }

    def create() {
        [tipoAutorizacionInstance: new TipoAutorizacion(params)]
    }

    def save() {
        def tipoAutorizacionInstance = new TipoAutorizacion(params)
        if (!tipoAutorizacionInstance.save(flush: true)) {
            render(view: "create", model: [tipoAutorizacionInstance: tipoAutorizacionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion'), tipoAutorizacionInstance.id])
        redirect(action: "show", id: tipoAutorizacionInstance.id)
    }

    def show(Long id) {
        def tipoAutorizacionInstance = TipoAutorizacion.get(id)
        if (!tipoAutorizacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion'), id])
            redirect(action: "list")
            return
        }

        [tipoAutorizacionInstance: tipoAutorizacionInstance]
    }

    def edit(Long id) {
        def tipoAutorizacionInstance = TipoAutorizacion.get(id)
        if (!tipoAutorizacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion'), id])
            redirect(action: "list")
            return
        }

        [tipoAutorizacionInstance: tipoAutorizacionInstance]
    }

    def update(Long id, Long version) {
        def tipoAutorizacionInstance = TipoAutorizacion.get(id)
        if (!tipoAutorizacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tipoAutorizacionInstance.version > version) {
                tipoAutorizacionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion')] as Object[],
                          "Another user has updated this TipoAutorizacion while you were editing")
                render(view: "edit", model: [tipoAutorizacionInstance: tipoAutorizacionInstance])
                return
            }
        }

        tipoAutorizacionInstance.properties = params

        if (!tipoAutorizacionInstance.save(flush: true)) {
            render(view: "edit", model: [tipoAutorizacionInstance: tipoAutorizacionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion'), tipoAutorizacionInstance.id])
        redirect(action: "show", id: tipoAutorizacionInstance.id)
    }

    def delete(Long id) {
        def tipoAutorizacionInstance = TipoAutorizacion.get(id)
        if (!tipoAutorizacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion'), id])
            redirect(action: "list")
            return
        }

        try {
            tipoAutorizacionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tipoAutorizacion.label', default: 'TipoAutorizacion'), id])
            redirect(action: "show", id: id)
        }
    }
}
