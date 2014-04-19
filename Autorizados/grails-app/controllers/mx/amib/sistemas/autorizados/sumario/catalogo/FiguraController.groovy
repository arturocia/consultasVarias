package mx.amib.sistemas.autorizados.sumario.catalogo

import org.springframework.dao.DataIntegrityViolationException

class FiguraController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [figuraInstanceList: Figura.list(params), figuraInstanceTotal: Figura.count()]
    }

    def create() {
        [figuraInstance: new Figura(params)]
    }

    def save() {
        def figuraInstance = new Figura(params)
        if (!figuraInstance.save(flush: true)) {
            render(view: "create", model: [figuraInstance: figuraInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'figura.label', default: 'Figura'), figuraInstance.id])
        redirect(action: "show", id: figuraInstance.id)
    }

    def show(Long id) {
        def figuraInstance = Figura.get(id)
        if (!figuraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'figura.label', default: 'Figura'), id])
            redirect(action: "list")
            return
        }

        [figuraInstance: figuraInstance]
    }

    def edit(Long id) {
        def figuraInstance = Figura.get(id)
        if (!figuraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'figura.label', default: 'Figura'), id])
            redirect(action: "list")
            return
        }

        [figuraInstance: figuraInstance]
    }

    def update(Long id, Long version) {
        def figuraInstance = Figura.get(id)
        if (!figuraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'figura.label', default: 'Figura'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (figuraInstance.version > version) {
                figuraInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'figura.label', default: 'Figura')] as Object[],
                          "Another user has updated this Figura while you were editing")
                render(view: "edit", model: [figuraInstance: figuraInstance])
                return
            }
        }

        figuraInstance.properties = params

        if (!figuraInstance.save(flush: true)) {
            render(view: "edit", model: [figuraInstance: figuraInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'figura.label', default: 'Figura'), figuraInstance.id])
        redirect(action: "show", id: figuraInstance.id)
    }

    def delete(Long id) {
        def figuraInstance = Figura.get(id)
        if (!figuraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'figura.label', default: 'Figura'), id])
            redirect(action: "list")
            return
        }

        try {
            figuraInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'figura.label', default: 'Figura'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'figura.label', default: 'Figura'), id])
            redirect(action: "show", id: id)
        }
    }
}
