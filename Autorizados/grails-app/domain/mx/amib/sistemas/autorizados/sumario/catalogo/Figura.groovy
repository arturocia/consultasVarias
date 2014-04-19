package mx.amib.sistemas.autorizados.sumario.catalogo

class Figura {

	String dsFigura
	Boolean stVigente

	/*static hasMany = [certificacion: Certificacion]*/

	static mapping = {
		
		table 't013_c_figura'
		
		dsFigura column:'ds_figura'
		stVigente column:'st_vigente'
		//id generator: "assigned"
		version false
	}

	static constraints = {
		dsFigura nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
