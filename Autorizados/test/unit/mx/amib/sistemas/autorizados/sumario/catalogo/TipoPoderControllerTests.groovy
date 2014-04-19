package mx.amib.sistemas.autorizados.sumario.catalogo



import org.junit.*
import grails.test.mixin.*

@TestFor(TipoPoderController)
@Mock(TipoPoder)
class TipoPoderControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tipoPoder/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tipoPoderInstanceList.size() == 0
        assert model.tipoPoderInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.tipoPoderInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tipoPoderInstance != null
        assert view == '/tipoPoder/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tipoPoder/show/1'
        assert controller.flash.message != null
        assert TipoPoder.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoPoder/list'

        populateValidParams(params)
        def tipoPoder = new TipoPoder(params)

        assert tipoPoder.save() != null

        params.id = tipoPoder.id

        def model = controller.show()

        assert model.tipoPoderInstance == tipoPoder
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoPoder/list'

        populateValidParams(params)
        def tipoPoder = new TipoPoder(params)

        assert tipoPoder.save() != null

        params.id = tipoPoder.id

        def model = controller.edit()

        assert model.tipoPoderInstance == tipoPoder
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoPoder/list'

        response.reset()

        populateValidParams(params)
        def tipoPoder = new TipoPoder(params)

        assert tipoPoder.save() != null

        // test invalid parameters in update
        params.id = tipoPoder.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tipoPoder/edit"
        assert model.tipoPoderInstance != null

        tipoPoder.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tipoPoder/show/$tipoPoder.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tipoPoder.clearErrors()

        populateValidParams(params)
        params.id = tipoPoder.id
        params.version = -1
        controller.update()

        assert view == "/tipoPoder/edit"
        assert model.tipoPoderInstance != null
        assert model.tipoPoderInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tipoPoder/list'

        response.reset()

        populateValidParams(params)
        def tipoPoder = new TipoPoder(params)

        assert tipoPoder.save() != null
        assert TipoPoder.count() == 1

        params.id = tipoPoder.id

        controller.delete()

        assert TipoPoder.count() == 0
        assert TipoPoder.get(tipoPoder.id) == null
        assert response.redirectedUrl == '/tipoPoder/list'
    }
}
