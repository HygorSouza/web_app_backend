package br.usjt.app.servicedesck.model;


public enum StatusChamado {
	ABERTO("Aberto"),
	FECHADO("Fechado"),
	CANCELADO("Cancelado"),
	ESTOROU_SLA("Estoutou sla"),
	TROCA_DE_EQUIPAMENTO("Aguardando equipamento para troca");
		
	final String status;
	
	StatusChamado(String stringStatus){
		this.status = stringStatus;
	}
	
	public String getStatus() {
		return status;
	}
	
}
