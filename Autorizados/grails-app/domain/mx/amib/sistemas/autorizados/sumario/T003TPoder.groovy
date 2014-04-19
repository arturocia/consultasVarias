package mx.amib.sistemas.autorizados.sumario

class T003TPoder {

	Integer nuNotario
	Integer nuEscritura
	Date fhCreacion
	Date fhModificacion
	T012CTppoder t012CTppoder
	T002TAutorizacion t002TAutorizacion

	static belongsTo = [T002TAutorizacion, T012CTppoder]

	static mapping = {
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
