package mx.amib.sistemas.puntos

class CertificacionPuntos {

	String matricula
	String nombre
	String paterno
	String materno
	String idFiguraCertificacion
	String figura
	String fechInicioVigenciaAnterior
	String fechaFinVigenciaAnterior
	String fechaInicioVigenciaNueva
	String fechaFinVigenciaNueva
	String fechaEmisioCarta
	String fechaRecepcion
	String institucion
	String tipoInstitucion
	String estatus
	String opcion1
	String instituto1
	String opcion2
	String instituto2
	String opcion3
	String instituto3
	String opcion4
	String instituto4
	String opcion5
	String instituto5
	String opcion6
	String instituto6
	String opcion7
	String instituto7


	static mapping = {
		table 't009_d_certpuntos'


		matricula column :'tx_matricula'
		nombre column:'tx_nombre'
		paterno column:'tx_apaterno'
		materno column:'tx_amaterno'
		idFiguraCertificacion column:'tx_idfiguracert'
		figura column:'tx_figura'
		fechInicioVigenciaAnterior column:'tx_fhiniciovigant'
		fechaFinVigenciaAnterior column:'tx_fhfinvigant'
		fechaInicioVigenciaNueva column:'tx_fhiniciovignva'
		fechaFinVigenciaNueva:'tx_fhfinvignva'
		fechaEmisioCarta column:'tx_fhemisioncarta'
		fechaRecepcion column:'tx_fhrecepcion'
		institucion column:'tx_institucion'
		tipoInstitucion column:'tx_tipoinstitucion'
		estatus column:'tx_estatus'
		opcion1 column:'tx_opcion1'
		instituto1 column:'tx_instituto1'
		opcion2 column:'tx_opcion2'
		instituto2 column:'tx_instituto2'
		instituto3 column:'tx_instituto3'
		opcion3 column:'tx_opcion3'
		opcion4 column:'tx_opcion4'
		instituto4 column:'tx_instituto4'
		instituto4 column:'tx_instituto4'
		instituto5 column:'tx_instituto5'
		opcion6 column:'tx_opcion6'
		instituto6 column:'tx_instituto6'
		opcion7 column:'tx_opcion7'
		instituto7 column:'tx_instituto7'


		version false
	}

	static constraints = {
	}
}
