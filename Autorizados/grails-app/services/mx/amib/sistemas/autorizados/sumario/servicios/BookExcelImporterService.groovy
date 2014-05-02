package mx.amib.sistemas.autorizados.sumario.servicios

import org.apache.poi.ss.usermodel.Sheet;
import org.grails.plugins.excelimport.*

class BookExcelImporterService extends AbstractExcelImporter {

	static Map CONFIG_BOOK_CELL_MAP = [
		sheet:'Sheet2',
		cellMap: [ 'D3':'title',
			'D4':'author',
			'D6':'numSold',
		]
	]

	static Map CONFIG_BOOK_COLUMN_MAP = [
		sheet:'Sheet1',
		startRow: 2,
		columnMap:  [
			'B':'title',
			'C':'author',
			'D':'numSold',
		]
	]

	//can also configure injection in resources.groovy
	def getExcelImportService() {
		ExcelImportService.getService()
	}
	
	public BookExcelImporterService() {
		super()
	}

	public BookExcelImporterService(String fileName) {
		super()
		this.read(fileName)
	}
	
	public BookExcelImporterService(InputStream inp) {
		super()
		this.read(inp)
	}

	List<Map> getBooks() {
		List bookList = excelImportService.columns(workbook, CONFIG_BOOK_COLUMN_MAP)
	}


	Map getOneMoreBookParams() {
		Map bookParams = excelImportService.cells(workbook, CONFIG_BOOK_CELL_MAP )
	}

	public List<String> getNombresHojas(){
		Integer numeroHojas=0
		Sheet hojaActual=null;
		List<String> nombres=new ArrayList<String>()
		
		numeroHojas=workbook.getNumberOfSheets()
		
		for(i in 0..numeroHojas-1){
			hojaActual=workbook.getSheetAt(i)
			nombres.add(hojaActual.sheetName)
		}
		return nombres
	}

}

