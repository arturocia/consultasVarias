package mx.amib.sistemas.autorizados.sumario.catalogo

import org.springframework.dao.DataIntegrityViolationException

class SituacionAutorizacionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [situacionAutorizacionInstanceList: SituacionAutorizacion.list(params), situacionAutorizacionInstanceTotal: SituacionAutorizacion.count()]
    }

    def create() {
        [situacionAutorizacionInstance: new SituacionAutorizacion(params)]
    }

    def save() {
        def situacionAutorizacionInstance = new SituacionAutorizacion(params)
        if (!situacionAutorizacionInstance.save(flush: true)) {
            render(view: "create", model: [situacionAutorizacionInstance: situacionAutorizacionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion'), situacionAutorizacionInstance.id])
        redirect(action: "show", id: situacionAutorizacionInstance.id)
    }

    def show(Long id) {
        def situacionAutorizacionInstance = SituacionAutorizacion.get(id)
        if (!situacionAutorizacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion'), id])
            redirect(action: "list")
            return
        }

        [situacionAutorizacionInstance: situacionAutorizacionInstance]
    }

    def edit(Long id) {
        def situacionAutorizacionInstance = SituacionAutorizacion.get(id)
        if (!situacionAutorizacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion'), id])
            redirect(action: "list")
            return
        }

        [situacionAutorizacionInstance: situacionAutorizacionInstance]
    }

    def update(Long id, Long version) {
        def situacionAutorizacionInstance = SituacionAutorizacion.get(id)
        if (!situacionAutorizacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (situacionAutorizacionInstance.version > version) {
                situacionAutorizacionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion')] as Object[],
                          "Another user has updated this SituacionAutorizacion while you were editing")
                render(view: "edit", model: [situacionAutorizacionInstance: situacionAutorizacionInstance])
                return
            }
        }

        situacionAutorizacionInstance.properties = params

        if (!situacionAutorizacionInstance.save(flush: true)) {
            render(view: "edit", model: [situacionAutorizacionInstance: situacionAutorizacionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion'), situacionAutorizacionInstance.id])
        redirect(action: "show", id: situacionAutorizacionInstance.id)
    }

    def delete(Long id) {
        def situacionAutorizacionInstance = SituacionAutorizacion.get(id)
        if (!situacionAutorizacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion'), id])
            redirect(action: "list")
            return
        }

        try {
            situacionAutorizacionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'situacionAutorizacion.label', default: 'SituacionAutorizacion'), id])
            redirect(action: "show", id: id)
        }
    }
}
