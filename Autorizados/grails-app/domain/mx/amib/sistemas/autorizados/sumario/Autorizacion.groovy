package mx.amib.sistemas.autorizados.sumario

import mx.amib.sistemas.autorizados.sumario.catalogo.SituacionAutorizacion;
import mx.amib.sistemas.autorizados.sumario.catalogo.TipoAutorizacion;

class Autorizacion {

	String txOficio
	Date fhOficio
	Date fhFinvigencia
	Boolean stRevocado
	String txCausarev
	Date fhCreacion
	Date fhModificacion
	
	TipoAutorizacion tipoAutorizacion
	Certificacion tipoCertificacion
	SituacionAutorizacion situacionAutorizacion

	static hasMany = [poderes: Poder]
	static belongsTo = [Certificacion, TipoAutorizacion, SituacionAutorizacion]

	static mapping = {
		table 't002_t_autorizacion'
		
		txOficio column :'tx_oficio'
		fhOficio column :'fh_oficio'
		fhFinvigencia column :'fh_finvigencia'
		stRevocado column :'st_revocado'
		txCausarev column :'tx_causarev'
		
		fhCreacion column :'fh_creacion'
		fhModificacion column :'fh_modificacion'
		
		tipoAutorizacion column :'id_007_tpautorizacion'
		tipoCertificacion column :'id_004_certificacion'
		situacionAutorizacion column :'id_011_situacionaut'
		
		//id generator: "assigned"
		version false
	}

	static constraints = {
		txOficio nullable: true, maxSize: 50
		fhOficio nullable: true
		fhFinvigencia nullable: true
		stRevocado nullable: true
		txCausarev nullable: true, maxSize: 1000
		fhCreacion nullable: true
		fhModificacion nullable: true
	}
}
