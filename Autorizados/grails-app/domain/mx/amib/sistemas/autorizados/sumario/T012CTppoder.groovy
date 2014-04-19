package mx.amib.sistemas.autorizados.sumario

class T012CTppoder {

	String dsTppoder
	Boolean stVigente

	static hasMany = [t003TPoders: T003TPoder]

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		dsTppoder nullable: true, maxSize: 254
		stVigente nullable: true
	}
}
