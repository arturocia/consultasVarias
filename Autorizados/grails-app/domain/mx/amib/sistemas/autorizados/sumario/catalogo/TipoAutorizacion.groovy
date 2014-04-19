package mx.amib.sistemas.autorizados.sumario.catalogo

import mx.amib.sistemas.autorizados.sumario.Autorizacion;

class TipoAutorizacion {

	String dsTpautorizacion
	Boolean stVigente

	/*static hasMany = [autorizacion: Autorizacion]*/

	static mapping = {
		table 't007_c_tpautorizacion'
		dsTpautorizacion column:'ds_tpautorizacion'
		stVigente column:'st_vigente'
		//id generator: "assigned"
		version false
	}

	static constraints = {
		dsTpautorizacion nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
