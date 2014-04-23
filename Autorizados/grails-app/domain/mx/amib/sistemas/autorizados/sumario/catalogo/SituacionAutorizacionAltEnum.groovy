package mx.amib.sistemas.autorizados.sumario.catalogo

public enum SituacionAutorizacionAltEnum {

	TODOS("TODOS","Todos"),
	EN_AUTORIZACION("EN_AUTORIZACION","En autorización"),
	AUTORIZADO_CON_PODERES("AUTORIZADO_CON_PODERES","Autorizados con poderes"),
	AUTORIZADO_SIN_PODERES("AUTORIZADO_SIN_PODERES","Autorizados sin poderes"),
	AUTORIZADO_EN_SEGUNDA("AUTORIZADO_EN_SEGUNDA","Autorizados en proceso de segunda autorización"),
	AUTORIZADO_TODO("AUTORIZADO_TODO","Todos los autorizados"),
	REVOCADO("REVOCADO","Revocados"),
	INCONSISTENTE("INCONSISTENTE","Inconsistentes")
	
	String id
	String name
	
	SituacionAutorizacionAltEnum(String id, String name) {
		this.id = id
		this.name = name
	}
	static def list(){
		[TODOS,EN_AUTORIZACION,AUTORIZADO_CON_PODERES,AUTORIZADO_SIN_PODERES,AUTORIZADO_EN_SEGUNDA,AUTORIZADO_TODO,REVOCADO,INCONSISTENTE]
	}
	public String toString(){
		return name
	}
	
	public String getId() { return id }
}