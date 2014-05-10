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

	def getCeldas(Boolean abreCertExperiencia=true){
		def celdas=null
		String nombreHoja=null
		Map mapaConf=null

		nombreHoja=workbook.getSheetAt(0).sheetName
		log.debug("el nombre de la hoja "+nombreHoja)
		//XXX: tx_fhfinvigant=folio
		//XXX: tx_fniniciovigant=revalido
		log.debug("abrir cert ${abreCertExperiencia}")
		if(abreCertExperiencia){
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
		}
		else{
			mapaConf=["sheet":nombreHoja,startRow: 1,columnMap:  [
					'A':'tx_matricula',
					'B':'tx_nombre',
					'C':'tx_apaterno',
					'D':'tx_amaterno',
					'E':'tx_figura',
					'F':'tx_fhiniciovigant',
					'G':'tx_fhfinvigant',
					'H':'tx_fhiniciovignva',
					'I':'tx_fhfinvignva',
					'J':'tx_fhemisioncarta',
					'K':'tx_fhrecepcion',
					'L':'tx_institucion',
					'M':'tx_tipoinstitucion',
					'N':'tx_estatus',
					'O':'tx_opcion1',
					'P':'tx_instituto1',
					'Q':'puntos1',
					'R':'evento1',
					'O':'tx_opcion2',
					'P':'tx_instituto2',
					'Q':'puntos2',
					'R':'evento2',
					'S':'tx_opcion3',
					'T':'tx_instituto3',
					'U':'puntos3',
					'V':'evento3',
					'W':'tx_opcion4',
					'X':'tx_instituto4',
					'Y':'puntos4',
					'Z':'evento4',
					'AA':'tx_opcion5',
					'AB':'tx_instituto5',
					'AC':'puntos5',
					'AD':'evento5',
					'AE':'tx_opcion6',
					'AF':'tx_instituto6',
					'AG':'puntos6',
					'AH':'evento6',
					'AI':'tx_opcion7',
					'AJ':'tx_instituto7',
					'AK':'puntos7',
					'AL':'evento7',
					'AM':'tx_opcion8',
					'AN':'tx_instituto8',
					'AO':'puntos8',
					'AP':'evento8'
				]]
		}
		celdas=excelImportService.columns(workbook, mapaConf)
		log.debug("las celdas resultado "+celdas[0])
		celdas
	}
}

