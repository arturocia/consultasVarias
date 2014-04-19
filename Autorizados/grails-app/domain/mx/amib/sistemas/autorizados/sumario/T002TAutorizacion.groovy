package mx.amib.sistemas.autorizados.sumario

class T002TAutorizacion {

	String txOficio
	Date fhOficio
	Date fhFinvigencia
	Boolean stRevocado
	String txCausarev
	Date fhCreacion
	Date fhModificacion
	T007CTpautorizacion t007CTpautorizacion
	T004TCertificacion t004TCertificacion
	T011CSituacionaut t011CSituacionaut

	static hasMany = [t003TPoders: T003TPoder]
	static belongsTo = [T004TCertificacion, T007CTpautorizacion, T011CSituacionaut]

	static mapping = {
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
