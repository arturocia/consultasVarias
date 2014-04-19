package mx.amib.sistemas.autorizados.sumario.catalogo



import org.junit.*
import grails.test.mixin.*

@TestFor(TipoAutorizacionController)
@Mock(TipoAutorizacion)
class TipoAutorizacionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tipoAutorizacion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tipoAutorizacionInstanceList.size() == 0
        assert model.tipoAutorizacionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.tipoAutorizacionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tipoAutorizacionInstance != null
        assert view == '/tipoAutorizacion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tipoAutorizacion/show/1'
        assert controller.flash.message != null
        assert TipoAutorizacion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoAutorizacion/list'

        populateValidParams(params)
        def tipoAutorizacion = new TipoAutorizacion(params)

        assert tipoAutorizacion.save() != null

        params.id = tipoAutorizacion.id

        def model = controller.show()

        assert model.tipoAutorizacionInstance == tipoAutorizacion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoAutorizacion/list'

        populateValidParams(params)
        def tipoAutorizacion = new TipoAutorizacion(params)

        assert tipoAutorizacion.save() != null

        params.id = tipoAutorizacion.id

        def model = controller.edit()

        assert model.tipoAutorizacionInstance == tipoAutorizacion
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoAutorizacion/list'

        response.reset()

        populateValidParams(params)
        def tipoAutorizacion = new TipoAutorizacion(params)

        assert tipoAutorizacion.save() != null

        // test invalid parameters in update
        params.id = tipoAutorizacion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tipoAutorizacion/edit"
        assert model.tipoAutorizacionInstance != null

        tipoAutorizacion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tipoAutorizacion/show/$tipoAutorizacion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tipoAutorizacion.clearErrors()

        populateValidParams(params)
        params.id = tipoAutorizacion.id
        params.version = -1
        controller.update()

        assert view == "/tipoAutorizacion/edit"
        assert model.tipoAutorizacionInstance != null
        assert model.tipoAutorizacionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tipoAutorizacion/list'

        response.reset()

        populateValidParams(params)
        def tipoAutorizacion = new TipoAutorizacion(params)

        assert tipoAutorizacion.save() != null
        assert TipoAutorizacion.count() == 1

        params.id = tipoAutorizacion.id

        controller.delete()

        assert TipoAutorizacion.count() == 0
        assert TipoAutorizacion.get(tipoAutorizacion.id) == null
        assert response.redirectedUrl == '/tipoAutorizacion/list'
    }
}
