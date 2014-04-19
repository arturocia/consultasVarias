package mx.amib.sistemas.autorizados.sumario

class T007CTpautorizacion {

	String dsTpautorizacion
	Boolean stVigente

	static hasMany = [t002TAutorizacions: T002TAutorizacion]

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsTpautorizacion nullable: true, maxSize: 1000
		stVigente nullable: true
	}
}
