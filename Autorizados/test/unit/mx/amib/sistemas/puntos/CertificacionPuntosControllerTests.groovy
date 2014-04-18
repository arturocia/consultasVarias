package mx.amib.sistemas.puntos



import org.junit.*
import grails.test.mixin.*

@TestFor(CertificacionPuntosController)
@Mock(CertificacionPuntos)
class CertificacionPuntosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/certificacionPuntos/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.certificacionPuntosInstanceList.size() == 0
        assert model.certificacionPuntosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.certificacionPuntosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.certificacionPuntosInstance != null
        assert view == '/certificacionPuntos/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/certificacionPuntos/show/1'
        assert controller.flash.message != null
        assert CertificacionPuntos.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/certificacionPuntos/list'

        populateValidParams(params)
        def certificacionPuntos = new CertificacionPuntos(params)

        assert certificacionPuntos.save() != null

        params.id = certificacionPuntos.id

        def model = controller.show()

        assert model.certificacionPuntosInstance == certificacionPuntos
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/certificacionPuntos/list'

        populateValidParams(params)
        def certificacionPuntos = new CertificacionPuntos(params)

        assert certificacionPuntos.save() != null

        params.id = certificacionPuntos.id

        def model = controller.edit()

        assert model.certificacionPuntosInstance == certificacionPuntos
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/certificacionPuntos/list'

        response.reset()

        populateValidParams(params)
        def certificacionPuntos = new CertificacionPuntos(params)

        assert certificacionPuntos.save() != null

        // test invalid parameters in update
        params.id = certificacionPuntos.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/certificacionPuntos/edit"
        assert model.certificacionPuntosInstance != null

        certificacionPuntos.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/certificacionPuntos/show/$certificacionPuntos.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        certificacionPuntos.clearErrors()

        populateValidParams(params)
        params.id = certificacionPuntos.id
        params.version = -1
        controller.update()

        assert view == "/certificacionPuntos/edit"
        assert model.certificacionPuntosInstance != null
        assert model.certificacionPuntosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/certificacionPuntos/list'

        response.reset()

        populateValidParams(params)
        def certificacionPuntos = new CertificacionPuntos(params)

        assert certificacionPuntos.save() != null
        assert CertificacionPuntos.count() == 1

        params.id = certificacionPuntos.id

        controller.delete()

        assert CertificacionPuntos.count() == 0
        assert CertificacionPuntos.get(certificacionPuntos.id) == null
        assert response.redirectedUrl == '/certificacionPuntos/list'
    }
}
