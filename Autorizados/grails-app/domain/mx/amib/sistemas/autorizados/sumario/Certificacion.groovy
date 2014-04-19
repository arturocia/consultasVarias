package mx.amib.sistemas.autorizados.sumario

class Certificacion {

	Date fhInicio
	Date fhFin
	Date fhCreacion
	Date fhModificacion
	Tpcertificacion t008CTpcertificacion
	Sustentante sustenante
	Figura t013CFigura

	static hasMany = [autorizaciones: Autorizacion]
	static belongsTo = [Sustentante, Tpcertificacion, Figura]

	static mapping = {
		table 't001_t_sustenante'
		
		fhInicio column :'fh_inicio'
		fhFin column :'fh_fin'
		fhCreacion column :'fh_creacion'
		fhModificacion column :'fh_modificacion'
		
		t008CTpcertificacion column :'id_008_tpcertificacion'
		sustenante column :'id_001_sustentante'
		t013CFigura column :'id_013_figura'
		
		id generator: "assigned"
		version false
	}

	static constraints = {
		fhInicio nullable: true
		fhFin nullable: true
		fhCreacion nullable: true
		fhModificacion nullable: true
	}
}
