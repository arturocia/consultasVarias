package mx.amib.sistemas.autorizados.sumario.servicios
import mx.amib.sistemas.autorizados.sumario.catalogo.Institucion;


import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(BookExcelImporterService)
@Mock([Institucion])
class BookExcelImporterServiceTests {

	
    void setUp() {
        // Setup logic here
    }

    void tearDown() {
        // Tear down logic here
    }

    void testWholeLottaLove() {
		List<String> nombresHojas=null
		BookExcelImporterService bookExcelImporterService=null
		
		bookExcelImporterService=new BookExcelImporterService("/tmp/test.xlsx")
		
		nombresHojas=bookExcelImporterService.getNombresHojas()
		
		for (nombreHoja in nombresHojas) {
			log.debug("I wanna give you my love "+nombreHoja)
		}
		
		assertTrue(nombresHojas.size()>0)
    }
}
