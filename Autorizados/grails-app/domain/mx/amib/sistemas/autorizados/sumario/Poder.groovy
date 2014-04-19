package mx.amib.sistemas.autorizados.sumario

import mx.amib.sistemas.autorizados.sumario.catalogo.TipoPoder;

class Poder {

	Integer nuNotario
	Integer nuEscritura
	Date fhCreacion
	Date fhModificacion
	TipoPoder tipoPoder
	Autorizacion autorizacion

	static belongsTo = [Autorizacion, TipoPoder]

	static mapping = {
		table 't003_t_poder'
		
		nuNotario column :'nu_notario'
		nuEscritura column :'nu_escritura'
		fhCreacion column :'fh_creacion'
		fhModificacion column :'fh_modificacion'
		tipoPoder column :'id_012_tppoder'
		autorizacion column :'id_002_autorizacion'
		
		id generator: "assigned"
		version false
	}

	static constraints = {
		nuNotario nullable: true
		nuEscritura nullable: true
		fhCreacion nullable: true
		fhModificacion nullable: true
	}
}
