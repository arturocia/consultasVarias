package mx.amib.sistemas.autorizados.sumario

class Autorizacion {

	String txOficio
	Date fhOficio
	Date fhFinvigencia
	Boolean stRevocado
	String txCausarev
	Date fhCreacion
	Date fhModificacion
	Tpautorizacion t007CTpautorizacion
	Certificacion t004TCertificacion
	Situacionaut t011CSituacionaut

	static hasMany = [poderes: Poder]
	static belongsTo = [Certificacion, Tpautorizacion,Situacionaut]

	static mapping = {
		table 't002_t_autorizacion'
		
		txOficio column :'tx_oficio'
		fhOficio column :'fh_oficio'
		fhFinvigencia column :'fh_finvigencia'
		stRevocado column :'st_revocado'
		txCausarev column :'tx_causarev'
		
		fhCreacion column :'fh_creacion'
		fhModificacion column :'fh_modificacion'
		
		t007CTpautorizacion column :'id_007_tpautorizacion'
		t004TCertificacion column :'id_004_certificacion'
		t011CSituacionaut column :'id_011_situacionaut'
		
		id generator: "assigned"
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
