package mx.amib.sistemas.autorizados.sumario

class T006CInstitucion {

	String nbInstitucion
	Boolean stVigente

	static hasMany = [t001TSustenantes: T001TSustenante]

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		nbInstitucion nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
