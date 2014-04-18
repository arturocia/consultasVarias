package mx.amib.sistemas.puntos

import org.springframework.dao.DataIntegrityViolationException

class CertificacionPuntosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [certificacionPuntosInstanceList: CertificacionPuntos.list(params), certificacionPuntosInstanceTotal: CertificacionPuntos.count()]
    }

    def create() {
        [certificacionPuntosInstance: new CertificacionPuntos(params)]
    }

    def save() {
        def certificacionPuntosInstance = new CertificacionPuntos(params)
        if (!certificacionPuntosInstance.save(flush: true)) {
            render(view: "create", model: [certificacionPuntosInstance: certificacionPuntosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos'), certificacionPuntosInstance.id])
        redirect(action: "show", id: certificacionPuntosInstance.id)
    }

    def show(Long id) {
        def certificacionPuntosInstance = CertificacionPuntos.get(id)
        if (!certificacionPuntosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos'), id])
            redirect(action: "list")
            return
        }

        [certificacionPuntosInstance: certificacionPuntosInstance]
    }

    def edit(Long id) {
        def certificacionPuntosInstance = CertificacionPuntos.get(id)
        if (!certificacionPuntosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos'), id])
            redirect(action: "list")
            return
        }

        [certificacionPuntosInstance: certificacionPuntosInstance]
    }

    def update(Long id, Long version) {
        def certificacionPuntosInstance = CertificacionPuntos.get(id)
        if (!certificacionPuntosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (certificacionPuntosInstance.version > version) {
                certificacionPuntosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos')] as Object[],
                          "Another user has updated this CertificacionPuntos while you were editing")
                render(view: "edit", model: [certificacionPuntosInstance: certificacionPuntosInstance])
                return
            }
        }

        certificacionPuntosInstance.properties = params

        if (!certificacionPuntosInstance.save(flush: true)) {
            render(view: "edit", model: [certificacionPuntosInstance: certificacionPuntosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos'), certificacionPuntosInstance.id])
        redirect(action: "show", id: certificacionPuntosInstance.id)
    }

    def delete(Long id) {
        def certificacionPuntosInstance = CertificacionPuntos.get(id)
        if (!certificacionPuntosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos'), id])
            redirect(action: "list")
            return
        }

        try {
            certificacionPuntosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'certificacionPuntos.label', default: 'CertificacionPuntos'), id])
            redirect(action: "show", id: id)
        }
    }
}
