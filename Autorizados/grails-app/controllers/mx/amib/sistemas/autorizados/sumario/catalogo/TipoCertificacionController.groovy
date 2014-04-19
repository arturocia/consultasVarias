package mx.amib.sistemas.autorizados.sumario.catalogo

import org.springframework.dao.DataIntegrityViolationException

class TipoCertificacionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [tipoCertificacionInstanceList: TipoCertificacion.list(params), tipoCertificacionInstanceTotal: TipoCertificacion.count()]
    }

    def create() {
        [tipoCertificacionInstance: new TipoCertificacion(params)]
    }

    def save() {
        def tipoCertificacionInstance = new TipoCertificacion(params)
        if (!tipoCertificacionInstance.save(flush: true)) {
            render(view: "create", model: [tipoCertificacionInstance: tipoCertificacionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion'), tipoCertificacionInstance.id])
        redirect(action: "show", id: tipoCertificacionInstance.id)
    }

    def show(Long id) {
        def tipoCertificacionInstance = TipoCertificacion.get(id)
        if (!tipoCertificacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion'), id])
            redirect(action: "list")
            return
        }

        [tipoCertificacionInstance: tipoCertificacionInstance]
    }

    def edit(Long id) {
        def tipoCertificacionInstance = TipoCertificacion.get(id)
        if (!tipoCertificacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion'), id])
            redirect(action: "list")
            return
        }

        [tipoCertificacionInstance: tipoCertificacionInstance]
    }

    def update(Long id, Long version) {
        def tipoCertificacionInstance = TipoCertificacion.get(id)
        if (!tipoCertificacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tipoCertificacionInstance.version > version) {
                tipoCertificacionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion')] as Object[],
                          "Another user has updated this TipoCertificacion while you were editing")
                render(view: "edit", model: [tipoCertificacionInstance: tipoCertificacionInstance])
                return
            }
        }

        tipoCertificacionInstance.properties = params

        if (!tipoCertificacionInstance.save(flush: true)) {
            render(view: "edit", model: [tipoCertificacionInstance: tipoCertificacionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion'), tipoCertificacionInstance.id])
        redirect(action: "show", id: tipoCertificacionInstance.id)
    }

    def delete(Long id) {
        def tipoCertificacionInstance = TipoCertificacion.get(id)
        if (!tipoCertificacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion'), id])
            redirect(action: "list")
            return
        }

        try {
            tipoCertificacionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tipoCertificacion.label', default: 'TipoCertificacion'), id])
            redirect(action: "show", id: id)
        }
    }
}
