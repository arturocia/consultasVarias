package mx.amib.sistemas.autorizados.sumario.catalogo

import mx.amib.sistemas.autorizados.sumario.Poder;

class TipoPoder {

	String dsTppoder
	Boolean stVigente

	/*static hasMany = [poderes: Poder]*/

	static mapping = {
		
		table 't012_c_tppoder'
		
		dsTppoder column:'ds_tppoder'
		stVigente column:'st_vigente'
		
		//id generator: "assigned"
		version false
	}

	static constraints = {
		dsTppoder nullable: true, maxSize: 254
		stVigente nullable: true
	}
}
