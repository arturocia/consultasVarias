package mx.amib.sistemas.autorizados.sumario

class T013CFigura {

	String dsFigura
	Boolean stVigente

	static hasMany = [t004TCertificacions: T004TCertificacion]

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsFigura nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
