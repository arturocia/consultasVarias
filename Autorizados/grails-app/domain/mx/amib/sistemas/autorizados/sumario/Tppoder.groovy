package mx.amib.sistemas.autorizados.sumario

class Tppoder {

	String dsTppoder
	Boolean stVigente

	static hasMany = [poderes: Poder]

	static mapping = {
		
		table 't012_c_ppoder'
		
		dsTppoder column:'ds_tppoder'
		stVigemte column:'st_vigente'
		
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsTppoder nullable: true, maxSize: 254
		stVigente nullable: true
	}
}
