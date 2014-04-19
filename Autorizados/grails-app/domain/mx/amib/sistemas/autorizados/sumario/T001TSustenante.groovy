package mx.amib.sistemas.autorizados.sumario

class T001TSustenante {

	String nbNombre
	String nbApaterno
	String nbAmaterno
	Integer nuMatricula
	Integer nuFolio
	Date fhCreacion
	Date fhModificacion
	T006CInstitucion t006CInstitucion

	static hasMany = [t004TCertificacions: T004TCertificacion]
	static belongsTo = [T006CInstitucion]

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		nbNombre nullable: true, maxSize: 100
		nbApaterno nullable: true, maxSize: 100
		nbAmaterno nullable: true, maxSize: 100
		nuMatricula nullable: true, unique: true
		nuFolio nullable: true, unique: true
		fhCreacion nullable: true
		fhModificacion nullable: true
	}
}
