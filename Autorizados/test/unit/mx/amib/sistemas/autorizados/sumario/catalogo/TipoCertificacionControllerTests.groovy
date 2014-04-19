package mx.amib.sistemas.autorizados.sumario.catalogo



import org.junit.*
import grails.test.mixin.*

@TestFor(TipoCertificacionController)
@Mock(TipoCertificacion)
class TipoCertificacionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tipoCertificacion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tipoCertificacionInstanceList.size() == 0
        assert model.tipoCertificacionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.tipoCertificacionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tipoCertificacionInstance != null
        assert view == '/tipoCertificacion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tipoCertificacion/show/1'
        assert controller.flash.message != null
        assert TipoCertificacion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoCertificacion/list'

        populateValidParams(params)
        def tipoCertificacion = new TipoCertificacion(params)

        assert tipoCertificacion.save() != null

        params.id = tipoCertificacion.id

        def model = controller.show()

        assert model.tipoCertificacionInstance == tipoCertificacion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoCertificacion/list'

        populateValidParams(params)
        def tipoCertificacion = new TipoCertificacion(params)

        assert tipoCertificacion.save() != null

        params.id = tipoCertificacion.id

        def model = controller.edit()

        assert model.tipoCertificacionInstance == tipoCertificacion
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoCertificacion/list'

        response.reset()

        populateValidParams(params)
        def tipoCertificacion = new TipoCertificacion(params)

        assert tipoCertificacion.save() != null

        // test invalid parameters in update
        params.id = tipoCertificacion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tipoCertificacion/edit"
        assert model.tipoCertificacionInstance != null

        tipoCertificacion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tipoCertificacion/show/$tipoCertificacion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tipoCertificacion.clearErrors()

        populateValidParams(params)
        params.id = tipoCertificacion.id
        params.version = -1
        controller.update()

        assert view == "/tipoCertificacion/edit"
        assert model.tipoCertificacionInstance != null
        assert model.tipoCertificacionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tipoCertificacion/list'

        response.reset()

        populateValidParams(params)
        def tipoCertificacion = new TipoCertificacion(params)

        assert tipoCertificacion.save() != null
        assert TipoCertificacion.count() == 1

        params.id = tipoCertificacion.id

        controller.delete()

        assert TipoCertificacion.count() == 0
        assert TipoCertificacion.get(tipoCertificacion.id) == null
        assert response.redirectedUrl == '/tipoCertificacion/list'
    }
}
