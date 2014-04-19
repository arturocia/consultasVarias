package mx.amib.sistemas.autorizados.sumario

class T008CTpcertificacion {

	String dsTpcertificacion
	Boolean stVigente

	static hasMany = [t004TCertificacions: T004TCertificacion]

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsTpcertificacion nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
