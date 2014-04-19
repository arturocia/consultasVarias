package mx.amib.sistemas.autorizados.sumario.catalogo



import org.junit.*
import grails.test.mixin.*

@TestFor(SituacionAutorizacionController)
@Mock(SituacionAutorizacion)
class SituacionAutorizacionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/situacionAutorizacion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.situacionAutorizacionInstanceList.size() == 0
        assert model.situacionAutorizacionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.situacionAutorizacionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.situacionAutorizacionInstance != null
        assert view == '/situacionAutorizacion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/situacionAutorizacion/show/1'
        assert controller.flash.message != null
        assert SituacionAutorizacion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/situacionAutorizacion/list'

        populateValidParams(params)
        def situacionAutorizacion = new SituacionAutorizacion(params)

        assert situacionAutorizacion.save() != null

        params.id = situacionAutorizacion.id

        def model = controller.show()

        assert model.situacionAutorizacionInstance == situacionAutorizacion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/situacionAutorizacion/list'

        populateValidParams(params)
        def situacionAutorizacion = new SituacionAutorizacion(params)

        assert situacionAutorizacion.save() != null

        params.id = situacionAutorizacion.id

        def model = controller.edit()

        assert model.situacionAutorizacionInstance == situacionAutorizacion
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/situacionAutorizacion/list'

        response.reset()

        populateValidParams(params)
        def situacionAutorizacion = new SituacionAutorizacion(params)

        assert situacionAutorizacion.save() != null

        // test invalid parameters in update
        params.id = situacionAutorizacion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/situacionAutorizacion/edit"
        assert model.situacionAutorizacionInstance != null

        situacionAutorizacion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/situacionAutorizacion/show/$situacionAutorizacion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        situacionAutorizacion.clearErrors()

        populateValidParams(params)
        params.id = situacionAutorizacion.id
        params.version = -1
        controller.update()

        assert view == "/situacionAutorizacion/edit"
        assert model.situacionAutorizacionInstance != null
        assert model.situacionAutorizacionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/situacionAutorizacion/list'

        response.reset()

        populateValidParams(params)
        def situacionAutorizacion = new SituacionAutorizacion(params)

        assert situacionAutorizacion.save() != null
        assert SituacionAutorizacion.count() == 1

        params.id = situacionAutorizacion.id

        controller.delete()

        assert SituacionAutorizacion.count() == 0
        assert SituacionAutorizacion.get(situacionAutorizacion.id) == null
        assert response.redirectedUrl == '/situacionAutorizacion/list'
    }
}
