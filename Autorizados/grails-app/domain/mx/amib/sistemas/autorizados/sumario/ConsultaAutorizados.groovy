package mx.amib.sistemas.autorizados.sumario

class ConsultaAutorizados {

	Integer nuMatricula
	Integer nuFolio
	String nbNombre
	String nbApaterno
	String nbAmaterno
	Integer idSituacionaut
	String dsSituacionaut
	Integer idTpautorizacion
	String dsTpautorizacion
	Integer idInstitucion
	String nbInstitucion
	Date fhIniciovigencia
	Date fhFinvigencia
	Date fhCreacion

	static mapping = {
		table 't005_vm_consultaautorizados'
		
		nuMatricula column :'nu_matricula'
		nuFolio column :'nu_folio'
		nbNombre column :'nb_nombre'
		nbApaterno column :'nb_apaterno'
		nbAmaterno column :'nb_amaterno'
		idSituacionaut column :'id_011_situacionaut'
		dsSituacionaut column :'ds_011_situacionaut'
		idTpautorizacion column :'id_007_tpautorizacion'
		dsTpautorizacion column :'ds_007_tpautorizacion'
		idInstitucion column :'id_006_institucion'
		nbInstitucion column :'nb_006_institucion'
		fhIniciovigencia column :'fh_iniciovigencia'
		fhFinvigencia column :'fh_finvigencia'
		
		fhCreacion column :'fh_creacion'
		
		//id generator: "assigned"
		version false
	}

	static constraints = {
		nuMatricula nullable: true
		nuFolio nullable: true
		nbNombre nullable: true, maxSize: 100
		nbApaterno nullable: true, maxSize: 100
		nbAmaterno nullable: true, maxSize: 100
		idSituacionaut nullable: true
		dsSituacionaut nullable: true
		idTpautorizacion nullable: true
		dsTpautorizacion nullable: true, maxSize: 1000
		idInstitucion nullable: true
		nbInstitucion nullable: true, maxSize: 1000
		fhIniciovigencia nullable: true
		fhFinvigencia nullable: true
		fhCreacion nullable: true
	}
}
