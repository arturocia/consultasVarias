package mx.amib.sistemas.autorizados.sumario

import mx.amib.sistemas.autorizados.sumario.catalogo.Institucion

class Poder {

	Integer nuNotario
	String nuEscritura
	String txTppoder
	Date fhCreacion
	Date fhModificacion
	Institucion institucion
	
	Sustentante sustentante
	
	static belongsTo = [Sustentante]

	static mapping = {
		table 't003_t_poder'
		
		nuNotario column :'nu_notario'
		nuEscritura column :'nu_escritura'
		txTppoder column :'tx_tppoder'
		fhCreacion column :'fh_creacion'
		fhModificacion column :'fh_modificacion'
		institucion column :'id_006_institucion'
		
		sustentante column :'id_001_sustentante'
		//id generator: "assigned"
		version false
	}

	static constraints = {
		nuNotario nullable: true
		nuEscritura nullable: true
		fhCreacion nullable: true
		fhModificacion nullable: true
	}
}
