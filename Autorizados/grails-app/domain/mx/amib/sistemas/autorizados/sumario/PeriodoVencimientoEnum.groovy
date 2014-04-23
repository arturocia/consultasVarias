package mx.amib.sistemas.autorizados.sumario

public enum PeriodoVencimientoEnum {
	
	NO_ESPECIFICADO("NO_ESPECIFICADO","Sin especificar"),
	UN_MES("UN_MES","Un mes"),
	TRES_MESES("TRES_MESES","Tres meses"),
	SEIS_MESES("SEIS_MESES","Seis meses"),
	NUEVE_MESES("NUEVE_MESES","Nueve meses"),
	DOCE_MESES("DOCE_MESES","Doce meses")
	
	String id
	String name
	
	PeriodoVencimientoEnum(String id, String name) {
		this.id = id
		this.name = name
	}
	static def list(){
		[NO_ESPECIFICADO, UN_MES, TRES_MESES, SEIS_MESES, NUEVE_MESES, DOCE_MESES]
	}
	public String toString(){
		return name
	}
	
	public String getId() { return id }
}