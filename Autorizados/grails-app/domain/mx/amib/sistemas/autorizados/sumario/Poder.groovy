package mx.amib.sistemas.autorizados.sumario

class Poder {

	Integer nuNotario
	Integer nuEscritura
	Date fhCreacion
	Date fhModificacion
	Tppoder t012CTppoder
	Autorizacion t002TAutorizacion

	static belongsTo = [Autorizacion, Tppoder]

	static mapping = {
		table 't003_t_poder'
		
		nuNotario column :'nu_notario'
		nuEscritura column :'nu_escritura'
		fhCreacion column :'fh_creacion'
		fhModificacion column :'fh_modificacion'
		t012CTppoder column :'id_012_tppoder'
		t002TAutorizacion column :'id_002_autorizacion'
		
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
