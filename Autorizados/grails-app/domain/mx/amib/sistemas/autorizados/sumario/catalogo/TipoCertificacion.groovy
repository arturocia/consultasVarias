package mx.amib.sistemas.autorizados.sumario.catalogo

import mx.amib.sistemas.autorizados.sumario.Certificacion;

class TipoCertificacion {

	String dsTpcertificacion
	Boolean stVigente

	/*static hasMany = [certificacion: Certificacion]*/

	static mapping = {
		table 't008_c_tpcertificacion'
		dsTpcertificacion column:'ds_tpcertificacion'
		stVigente column:'st_vigente'
		
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsTpcertificacion nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
