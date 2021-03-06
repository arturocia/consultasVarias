package mx.amib.sistemas.autorizados.sumario

import mx.amib.sistemas.autorizados.sumario.catalogo.Institucion;

class Sustentante {

	String nbNombre
	String nbApaterno
	String nbAmaterno
	Integer nuMatricula
	Integer nuFolio
	Date fhCreacion
	Date fhModificacion
	Institucion institucion
	
	static hasMany = [certificaciones: Certificacion, poderes: Poder]
	static belongsTo = [Institucion]

	static mapping = {
		table 't001_t_sustenante'
		
		nbNombre column :'nb_nombre'
		nbApaterno column :'nb_apaterno'
		nbAmaterno column :'nb_amaterno'
		nuMatricula column :'nu_matricula'
		nuFolio column :'nu_folio'
		fhCreacion column :'fh_creacion'
		fhModificacion column :'fh_modificacion'
		
		institucion column : 'id_006_institucion'
		
		//id generator: "assigned"
		version false
		
		certificaciones sort:'fhFin', order:'asc'
	}

	static constraints = {
		nbNombre nullable: true, maxSize: 100
		nbApaterno nullable: true, maxSize: 100
		nbAmaterno nullable: true, maxSize: 100
		nuMatricula nullable: true, unique: true
		nuFolio nullable: true, unique: true
		fhCreacion nullable: true
		fhModificacion nullable: true
	}
}
