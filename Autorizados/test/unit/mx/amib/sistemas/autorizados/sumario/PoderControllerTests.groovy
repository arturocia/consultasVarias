package mx.amib.sistemas.autorizados.sumario



import org.junit.*
import grails.test.mixin.*

@TestFor(PoderController)
@Mock(Poder)
class PoderControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/poder/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.poderInstanceList.size() == 0
        assert model.poderInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.poderInstance != null
    }

    void testSave() {
        controller.save()

        assert model.poderInstance != null
        assert view == '/poder/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/poder/show/1'
        assert controller.flash.message != null
        assert Poder.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/poder/list'

        populateValidParams(params)
        def poder = new Poder(params)

        assert poder.save() != null

        params.id = poder.id

        def model = controller.show()

        assert model.poderInstance == poder
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/poder/list'

        populateValidParams(params)
        def poder = new Poder(params)

        assert poder.save() != null

        params.id = poder.id

        def model = controller.edit()

        assert model.poderInstance == poder
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/poder/list'

        response.reset()

        populateValidParams(params)
        def poder = new Poder(params)

        assert poder.save() != null

        // test invalid parameters in update
        params.id = poder.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/poder/edit"
        assert model.poderInstance != null

        poder.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/poder/show/$poder.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        poder.clearErrors()

        populateValidParams(params)
        params.id = poder.id
        params.version = -1
        controller.update()

        assert view == "/poder/edit"
        assert model.poderInstance != null
        assert model.poderInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/poder/list'

        response.reset()

        populateValidParams(params)
        def poder = new Poder(params)

        assert poder.save() != null
        assert Poder.count() == 1

        params.id = poder.id

        controller.delete()

        assert Poder.count() == 0
        assert Poder.get(poder.id) == null
        assert response.redirectedUrl == '/poder/list'
    }
}
