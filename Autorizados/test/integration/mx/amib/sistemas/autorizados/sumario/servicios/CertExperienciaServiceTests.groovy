package mx.amib.sistemas.autorizados.sumario.servicios

import static org.junit.Assert.*
import org.junit.*

class CertExperienciaServiceTests {
	def dataSource

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
	void testInsercionDesdeExcel(){
		BookExcelImporterService bookExcelImporterService=grailsApplication.mainContext.getBean("bookExcelImporterService")
		ExcelImportService excelImportService=grailsApplication.mainContext.getBean("excelImportService")
		
		bookExcelImporterService.excelImportService=excelImportService
		bookExcelImporterService.read("/tmp/suelta.xlsx")
		
		service.dataSource=dataSource
		
		
		def celdas=bookExcelImporterService.celdas
		
		assertTrue(service.guardaExcel(celdas))
		
	}
}
/*
package mx.amib.sistemas.autorizados.sumario.servicios
import org.grails.plugins.excelimport.ExcelImportService;
import javax.sql.DataSource;



import grails.test.mixin.*
import org.junit.*

@TestFor(CertExperienciaService)
@Mock([BookExcelImporterService,ExcelImportService,DataSource])
class CertExperienciaServiceTests {

	void testMrPachucoMusic() {
		assertTrue service!=null
	}
	
	void testInsercionDesdeExcel(){
		BookExcelImporterService bookExcelImporterService=grailsApplication.mainContext.getBean("bookExcelImporterService")
		ExcelImportService excelImportService=grailsApplication.mainContext.getBean("excelImportService")
		DataSource dataSource= grailsApplication.mainContext.getBean("dataSource")
		
		bookExcelImporterService.excelImportService=excelImportService
		bookExcelImporterService.read("/tmp/suelta.xlsx")
		
		service.dataSource=dataSource
		
		
		def celdas=bookExcelImporterService.celdas
		
		assertTrue(service.guardaExcel(celdas))
		
	}
}
*/
