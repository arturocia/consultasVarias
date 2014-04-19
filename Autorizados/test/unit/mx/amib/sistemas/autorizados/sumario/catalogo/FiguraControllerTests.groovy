package mx.amib.sistemas.autorizados.sumario.catalogo



import org.junit.*
import grails.test.mixin.*

@TestFor(FiguraController)
@Mock(Figura)
class FiguraControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/figura/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.figuraInstanceList.size() == 0
        assert model.figuraInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.figuraInstance != null
    }

    void testSave() {
        controller.save()

        assert model.figuraInstance != null
        assert view == '/figura/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/figura/show/1'
        assert controller.flash.message != null
        assert Figura.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/figura/list'

        populateValidParams(params)
        def figura = new Figura(params)

        assert figura.save() != null

        params.id = figura.id

        def model = controller.show()

        assert model.figuraInstance == figura
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/figura/list'

        populateValidParams(params)
        def figura = new Figura(params)

        assert figura.save() != null

        params.id = figura.id

        def model = controller.edit()

        assert model.figuraInstance == figura
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/figura/list'

        response.reset()

        populateValidParams(params)
        def figura = new Figura(params)

        assert figura.save() != null

        // test invalid parameters in update
        params.id = figura.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/figura/edit"
        assert model.figuraInstance != null

        figura.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/figura/show/$figura.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        figura.clearErrors()

        populateValidParams(params)
        params.id = figura.id
        params.version = -1
        controller.update()

        assert view == "/figura/edit"
        assert model.figuraInstance != null
        assert model.figuraInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/figura/list'

        response.reset()

        populateValidParams(params)
        def figura = new Figura(params)

        assert figura.save() != null
        assert Figura.count() == 1

        params.id = figura.id

        controller.delete()

        assert Figura.count() == 0
        assert Figura.get(figura.id) == null
        assert response.redirectedUrl == '/figura/list'
    }
}
