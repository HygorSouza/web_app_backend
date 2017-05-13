package br.usjt.app.servicedesck.model;

import java.util.Arrays;
import java.util.List;

public enum StatusChamado {
	ABERTO("Aberto"),
	FECHADO("Fechado"),
	CANCELADO("Cancelado"),
	ESTOROU_SLA("Estourou sla"),
	TROCA_DE_EQUIPAMENTO("Aguardando equipamento para troca");
		
	final String status;
	
	StatusChamado(String stringStatus){
		this.status = stringStatus;
	}
	
	public String getStatus() {
		return status;
	}
	
	
	public static List<StatusChamado> getList(){
		return Arrays.asList(StatusChamado.ABERTO , StatusChamado.FECHADO , StatusChamado.CANCELADO , StatusChamado.TROCA_DE_EQUIPAMENTO, StatusChamado.ESTOROU_SLA);
	}
}
