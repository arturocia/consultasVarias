package mx.amib.sistemas.autorizados.sumario

class Situacionaut {

	String dsSituacionaut
	Boolean stVigente

	static hasMany = [autorizacion: Autorizacion]

	static mapping = {
		
		table 't011_c_situacionaut'
		dsSituacionaut column:'ds_situacionaut'
		stVigente column:'st_vigente'
		
		
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsSituacionaut nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
