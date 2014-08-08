package mx.amib.sistemas.puntos

class CertificacionPfiController {

	static allowedMethods = [save: "POST"]
	def bookExcelImporterService
	def certPfiService

	def index() {
		redirect(action: "create", params: params)
	}

	def create() {
	}

	def upload() {
		File excelTmp=null
		log.error("will challenge our enemies puntos")
		log.debug("and it will end")
		def file = request.getFile('file')
		if(file.empty) {
			flash.message = "El archivo no puede estar vacio, por favor, proporcione uno mejor."
		} else {
			log.debug("We must prepare for a great war")
			log.debug("with the trinph of our race  "+file.originalFilename)
			excelTmp=new File(grailsApplication.config.uploadFolder+"/" +file.originalFilename)
			file.transferTo(excelTmp)
			log.debug("the mailed fists of the legions of reich "+excelTmp.canRead())

			bookExcelImporterService.read(excelTmp.absolutePath)
			log.debug("and if the jackals will not surrender D6")

			def celdas=bookExcelImporterService.getCeldaspfi(false)
			log.debug("we will take it by force!")
			certPfiService.guardaExcel(celdas)
			log.debug("heil reich!")

		}
		redirect (action:'create')
	}
}
