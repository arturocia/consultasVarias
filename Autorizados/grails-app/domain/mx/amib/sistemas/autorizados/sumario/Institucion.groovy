package mx.amib.sistemas.autorizados.sumario

class Institucion {

	String nbInstitucion
	Boolean stVigente

	static hasMany = [sustenante: Sustentante]

	static mapping = {
		
		table 't006_c_institucion'
		nbInstitucion column:'nb_institucion'
		stVigente column:'st_vigente'
		
		id generator: "assigned"
		version false
	}

	static constraints = {
		nbInstitucion nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
