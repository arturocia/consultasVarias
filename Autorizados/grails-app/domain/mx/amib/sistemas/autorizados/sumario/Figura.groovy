package mx.amib.sistemas.autorizados.sumario

class Figura {

	String dsFigura
	Boolean stVigente

	static hasMany = [Certificacion: Certificacion]

	static mapping = {
		
		table 't013_c_figura'
		
		dsFigura column:'ds_tpautorizacion'
		stVigente column:'st_vigente'
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsFigura nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
