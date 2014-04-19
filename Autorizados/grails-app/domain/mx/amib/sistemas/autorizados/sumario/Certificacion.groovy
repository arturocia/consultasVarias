package mx.amib.sistemas.autorizados.sumario

import mx.amib.sistemas.autorizados.sumario.catalogo.Figura;
import mx.amib.sistemas.autorizados.sumario.catalogo.TipoCertificacion;

class Certificacion {

	Date fhInicio
	Date fhFin
	Date fhCreacion
	Date fhModificacion
	
	TipoCertificacion tipoCertificacion
	Sustentante sustenante
	Figura figura

	static hasMany = [autorizaciones: Autorizacion]
	static belongsTo = [Sustentante, TipoCertificacion, Figura]

	static mapping = {
		table 't001_t_sustenante'
		
		fhInicio column :'fh_inicio'
		fhFin column :'fh_fin'
		fhCreacion column :'fh_creacion'
		fhModificacion column :'fh_modificacion'
		
		tipoCertificacion column :'id_008_tpcertificacion'
		sustenante column :'id_001_sustentante'
		figura column :'id_013_figura'
		
		//id generator: "assigned"
		version false
	}

	static constraints = {
		fhInicio nullable: true
		fhFin nullable: true
		fhCreacion nullable: true
		fhModificacion nullable: true
	}
}
