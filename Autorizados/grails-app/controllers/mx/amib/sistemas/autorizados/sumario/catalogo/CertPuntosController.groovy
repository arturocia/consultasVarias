package mx.amib.sistemas.autorizados.sumario.catalogo

class CertPuntosController {

	static allowedMethods = [save: "POST"]
	def bookExcelImporterService
	def certExperienciaService

	def grailsApplication
	
	def index() {
		redirect(action: "create", params: params)
	}

	/* http://localhost:8080/Autorizados/certPuntos/create?k3c6e0b8a9c15224a8228b9a98ca1531d=855DBFA442AA4C9FB4846D53E76A5742 */
	def create() {
		def key = params.k3c6e0b8a9c15224a8228b9a98ca1531d
		if(key!=grailsApplication.config.mx.amib.sistemas.autorizados.formkey)
		{
			render(status: 404, text: 'ERROR')
			return 
		}
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

			def celdas=bookExcelImporterService.getCeldas(false)
			log.debug("we will take it by force!")
			certExperienciaService.guardaExcel(celdas)
			log.debug("heil reich!")

		}
		redirect (action:'create')
	}
}

