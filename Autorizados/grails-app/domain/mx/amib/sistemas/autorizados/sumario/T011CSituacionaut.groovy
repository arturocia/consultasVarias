package mx.amib.sistemas.autorizados.sumario

class T011CSituacionaut {

	String dsSituacionaut
	Boolean stVigente

	static hasMany = [t002TAutorizacions: T002TAutorizacion]

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsSituacionaut nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
