package mx.amib.sistemas.autorizados.sumario



import org.junit.*
import grails.test.mixin.*

@TestFor(ConsultaAutorizadosController)
@Mock(ConsultaAutorizados)
class ConsultaAutorizadosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/consultaAutorizados/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.consultaAutorizadosInstanceList.size() == 0
        assert model.consultaAutorizadosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.consultaAutorizadosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.consultaAutorizadosInstance != null
        assert view == '/consultaAutorizados/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/consultaAutorizados/show/1'
        assert controller.flash.message != null
        assert ConsultaAutorizados.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/consultaAutorizados/list'

        populateValidParams(params)
        def consultaAutorizados = new ConsultaAutorizados(params)

        assert consultaAutorizados.save() != null

        params.id = consultaAutorizados.id

        def model = controller.show()

        assert model.consultaAutorizadosInstance == consultaAutorizados
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/consultaAutorizados/list'

        populateValidParams(params)
        def consultaAutorizados = new ConsultaAutorizados(params)

        assert consultaAutorizados.save() != null

        params.id = consultaAutorizados.id

        def model = controller.edit()

        assert model.consultaAutorizadosInstance == consultaAutorizados
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/consultaAutorizados/list'

        response.reset()

        populateValidParams(params)
        def consultaAutorizados = new ConsultaAutorizados(params)

        assert consultaAutorizados.save() != null

        // test invalid parameters in update
        params.id = consultaAutorizados.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/consultaAutorizados/edit"
        assert model.consultaAutorizadosInstance != null

        consultaAutorizados.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/consultaAutorizados/show/$consultaAutorizados.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        consultaAutorizados.clearErrors()

        populateValidParams(params)
        params.id = consultaAutorizados.id
        params.version = -1
        controller.update()

        assert view == "/consultaAutorizados/edit"
        assert model.consultaAutorizadosInstance != null
        assert model.consultaAutorizadosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/consultaAutorizados/list'

        response.reset()

        populateValidParams(params)
        def consultaAutorizados = new ConsultaAutorizados(params)

        assert consultaAutorizados.save() != null
        assert ConsultaAutorizados.count() == 1

        params.id = consultaAutorizados.id

        controller.delete()

        assert ConsultaAutorizados.count() == 0
        assert ConsultaAutorizados.get(consultaAutorizados.id) == null
        assert response.redirectedUrl == '/consultaAutorizados/list'
    }
}
