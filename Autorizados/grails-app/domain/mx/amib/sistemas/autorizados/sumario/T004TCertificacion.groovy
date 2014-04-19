package mx.amib.sistemas.autorizados.sumario

class T004TCertificacion {

	Date fhInicio
	Date fhFin
	Date fhCreacion
	Date fhModificacion
	T008CTpcertificacion t008CTpcertificacion
	T001TSustenante t001TSustenante
	T013CFigura t013CFigura

	static hasMany = [t002TAutorizacions: T002TAutorizacion]
	static belongsTo = [T001TSustenante, T008CTpcertificacion, T013CFigura]

	static mapping = {
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
