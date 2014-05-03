package mx.amib.sistemas.autorizados.sumario.servicios

import org.apache.poi.ss.usermodel.Sheet;
import org.grails.plugins.excelimport.*
import org.springframework.context.ApplicationContext;
import grails.util.Holders;
import mx.amib.sistemas.autorizados.sumario.catalogo.Institucion

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

	def ExcelImportService excelImportService

	/*
	public getExcelImportService1(){
		log.debug("el grails app "+grailsApplication)
		log.debug("el servicio "+excelImportService)
//		ApplicationContext ctx = Holders.grailsApplication.mainContext
		ApplicationContext ctx = grailsApplication.mainContext
//		ApplicationContext ctx = new Institucion().domainClass.grailsApplication
		log.debug("EEEETTTT ${ctx}")
		ExcelImportService
		excelImportService=ctx.getBean("excelImportService")
		log.debug("el servicios obtenido "+excelImportService)
		return excelImportService
	}
	*/

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

	def getCeldas(){
		def celdas=null
		String nombreHoja=null
		Map mapaConf

		nombreHoja=workbook.getSheetAt(0).sheetName
		log.debug("el nombre de la hoja "+nombreHoja)
		//XXX: tx_fhfinvigant=folio
		//XXX: tx_fniniciovigant=revalido
		mapaConf=["sheet":nombreHoja,startRow: 1,columnMap:  [
				'A':'tx_matricula',
				'B':'tx_fhfinvigant',
				'C':'tx_apaterno',
				'D':'tx_amaterno',
				'E':'tx_nombre',
				'F':'tx_figura',
				'G':'tx_fhiniciovigant',
				'H':'tx_institucion',
				'I':'tx_tipoinstitucion',
				'J':'tx_idfiguracert',
				'K':'tx_fhemisioncarta',
				'L':'tx_fhiniciovignva',
				'M':'tx_fhfinvignva',
				'N':'tx_estatus',
				'O':'nombreCompleto',
			]]

		celdas=excelImportService.columns(workbook, mapaConf)
		log.debug("las celdas resultado "+celdas)
		celdas
	}
}

