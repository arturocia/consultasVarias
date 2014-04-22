package mx.amib.sistemas.autorizados.sumario

public enum PeriodoVencimiento {
	
	UN_MES(1,"Un mes"),
	TRES_MESES(2,"Tres meses"),
	SEIS_MESES(3,"Seis mes"),
	NUEVE_MESES(4,"Nueve meses"),
	DOCE_MESES(5,"Un mes")
	
	int id
	String name
	
	PeriodoVencimiento(int id, String name) {
		this.id = id
		this.name = name
	}
	static def list(){
		[UN_MES, TRES_MESES, SEIS_MESES, NUEVE_MESES, DOCE_MESES]
	}
	public String toString(){
		return name
	}
	
	public String getId() { return id }
}