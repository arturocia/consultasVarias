package mx.amib.sistemas.autorizados.sumario.catalogo

class CertExperienciaController {

	static allowedMethods = [save: "POST"]

	def index() {
		redirect(action: "create", params: params)
	}

	def create() {
	}

	def upload() {
		File excelTmp=null
		log.error("will challenge our enemies")
		log.debug("and it will end")
		def file = request.getFile('file')
		if(file.empty) {
			flash.message = "El archivo no puede estar vacio, por favor, proporcione uno mejor."
		} else {
			log.debug("We must prepare for a great war")
			log.debug("with the trinph of our race  "+file.originalFilename)
			excelTmp=new File(grailsApplication.config.uploadFolder+"/" +file.originalFilename)
			file.transferTo(excelTmp)
			log.debug("the mailed fists of the legions of reich "+excelTmp.length())
			/*
			 def documentInstance = new Document()
			 documentInstance.filename = file.originalFilename
			 documentInstance.filedata = file.getBytes()
			 documentInstance.save()
			 */
		}
		redirect (action:'create')
	}
}

