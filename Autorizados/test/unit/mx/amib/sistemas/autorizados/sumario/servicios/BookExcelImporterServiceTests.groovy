package mx.amib.sistemas.autorizados.sumario.servicios
import mx.amib.sistemas.autorizados.sumario.catalogo.Institucion;
import mx.amib.sistemas.autorizados.sumario.catalogo.Institucion;

import org.grails.plugins.excelimport.ExcelImportService


import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
// https://github.com/pschneider-manzell/grails-spock-examples/blob/master/test/unit/grails/geb/spock/service/GuttenbergServiceSpec.groovy
@TestFor(BookExcelImporterService)
@Mock([Institucion,ExcelImportService])
class BookExcelImporterServiceTests {


	def excelImportService
	void setUp() {
		// Setup logic here
	}

	void tearDown() {
		// Tear down logic here
	}


	void testCerdas() {
		def celdas=null
		BookExcelImporterService bookExcelImporterService=null

		log.debug("me corto los webos "+grailsApplication.mainContext.getBean("excelImportService"))
		excelImportService=grailsApplication.mainContext.getBean("excelImportService")
		log.debug("puta madre "+excelImportService)

		//XXX: http://stackoverflow.com/questions/13532417/grails-unit-tests-accessing-defined-beans-via-grailsapplication
		bookExcelImporterService=new BookExcelImporterService("/tmp/test.xlsx")
		bookExcelImporterService.excelImportService=excelImportService

		celdas=bookExcelImporterService.celdas
		log.debug("AAAAAA tipo celdas "+celdas)
		for (celda in celdas) {
			log.debug("AAAAAA ae ae ae ae "+celda)
		}

		assertTrue(celdas.size()>0)
	}

	void testWholeLottaLove() {
		List<String> nombresHojas=null
		BookExcelImporterService bookExcelImporterService=null

		bookExcelImporterService=new BookExcelImporterService("/tmp/test.xlsx")
		bookExcelImporterService.excelImportService=excelImportService

		nombresHojas=bookExcelImporterService.getNombresHojas()

		for (nombreHoja in nombresHojas) {
			log.debug("I wanna give you my love "+nombreHoja)
		}

		assertTrue(nombresHojas.size()>0)
	}

}
