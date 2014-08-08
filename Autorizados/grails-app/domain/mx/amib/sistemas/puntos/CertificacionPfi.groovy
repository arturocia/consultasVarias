package mx.amib.sistemas.puntos

class CertificacionPfi {

	String matricula
	String nombre
	String apaterno
	String amaterno
	String tipoinstitucion
	String figura
	String resultado
	String fechainicioviganterior
	String fechafinviganterior
	String modalidad


	static mapping = {

		table :'t017_d_certificacionpfi'



		matricula column :'tx_matricula'
		nombre column:'tx_nombre'
		apaterno column : 'tx_apaterno'
		amaterno column : 'tx_amaterno'
		tipoinstitucion column :'tx_tipoinstitucion'
		figura column : 'tx_figura'
		resultado column :'tx_resultado'
		fechainicioviganterior column : 'tx_fhiniciovigant'
		fechafinviganterior column :'tx_fhfinvigant'
		modalidad column :'tx_modalidad'
		
		version false
		
	}

	static constraints = {
	}
	
}
