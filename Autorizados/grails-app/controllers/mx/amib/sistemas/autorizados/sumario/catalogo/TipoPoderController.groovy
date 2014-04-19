package mx.amib.sistemas.autorizados.sumario.catalogo

import org.springframework.dao.DataIntegrityViolationException

class TipoPoderController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [tipoPoderInstanceList: TipoPoder.list(params), tipoPoderInstanceTotal: TipoPoder.count()]
    }

    def create() {
        [tipoPoderInstance: new TipoPoder(params)]
    }

    def save() {
        def tipoPoderInstance = new TipoPoder(params)
        if (!tipoPoderInstance.save(flush: true)) {
            render(view: "create", model: [tipoPoderInstance: tipoPoderInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tipoPoder.label', default: 'TipoPoder'), tipoPoderInstance.id])
        redirect(action: "show", id: tipoPoderInstance.id)
    }

    def show(Long id) {
        def tipoPoderInstance = TipoPoder.get(id)
        if (!tipoPoderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoPoder.label', default: 'TipoPoder'), id])
            redirect(action: "list")
            return
        }

        [tipoPoderInstance: tipoPoderInstance]
    }

    def edit(Long id) {
        def tipoPoderInstance = TipoPoder.get(id)
        if (!tipoPoderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoPoder.label', default: 'TipoPoder'), id])
            redirect(action: "list")
            return
        }

        [tipoPoderInstance: tipoPoderInstance]
    }

    def update(Long id, Long version) {
        def tipoPoderInstance = TipoPoder.get(id)
        if (!tipoPoderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoPoder.label', default: 'TipoPoder'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tipoPoderInstance.version > version) {
                tipoPoderInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tipoPoder.label', default: 'TipoPoder')] as Object[],
                          "Another user has updated this TipoPoder while you were editing")
                render(view: "edit", model: [tipoPoderInstance: tipoPoderInstance])
                return
            }
        }

        tipoPoderInstance.properties = params

        if (!tipoPoderInstance.save(flush: true)) {
            render(view: "edit", model: [tipoPoderInstance: tipoPoderInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoPoder.label', default: 'TipoPoder'), tipoPoderInstance.id])
        redirect(action: "show", id: tipoPoderInstance.id)
    }

    def delete(Long id) {
        def tipoPoderInstance = TipoPoder.get(id)
        if (!tipoPoderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoPoder.label', default: 'TipoPoder'), id])
            redirect(action: "list")
            return
        }

        try {
            tipoPoderInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoPoder.label', default: 'TipoPoder'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tipoPoder.label', default: 'TipoPoder'), id])
            redirect(action: "show", id: id)
        }
    }
}
