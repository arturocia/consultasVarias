package mx.amib.sistemas.autorizados.sumario

class T005VmConsultaautorizados {

	Integer nuMatricula
	Integer nuFolio
	String nbNombre
	String nbApaterno
	String nbAmaterno
	Integer id011Situacionaut
	Integer ds011Situacionaut
	Integer id007Tpautorizacion
	String ds007Tpautorizacion
	Integer id006Institucion
	String nbInstitucion
	Date fhIniciovigencia
	Date fhFinvigencia
	Date fhCreacion

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		nuMatricula nullable: true
		nuFolio nullable: true
		nbNombre nullable: true, maxSize: 100
		nbApaterno nullable: true, maxSize: 100
		nbAmaterno nullable: true, maxSize: 100
		id011Situacionaut nullable: true
		ds011Situacionaut nullable: true
		id007Tpautorizacion nullable: true
		ds007Tpautorizacion nullable: true, maxSize: 1000
		id006Institucion nullable: true
		nbInstitucion nullable: true, maxSize: 1000
		fhIniciovigencia nullable: true
		fhFinvigencia nullable: true
		fhCreacion nullable: true
	}
}
