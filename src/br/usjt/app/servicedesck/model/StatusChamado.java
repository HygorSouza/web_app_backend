package br.usjt.app.servicedesck.model;

import java.util.Arrays;
import java.util.List;

/**
 * @author Hygor 
 * @version 2.0.0 
 */
public enum StatusChamado {
	ABERTO("Aberto"),
	FECHADO("Fechado"),
	CANCELADO("Cancelado"),
	ESTOROU_SLA("Estourou sla"),
	TROCA_DE_EQUIPAMENTO("Aguardando equipamento para troca");
		
	final String status;
	public static StatusChamado getAberto(){
		return StatusChamado.ABERTO;
	}
	StatusChamado(String stringStatus){
		this.status = stringStatus;
	}
	
	public String getStatus() {
		return status;
	}

	public static List<StatusChamado> getList(){
		return Arrays.asList(StatusChamado.ABERTO , StatusChamado.FECHADO , StatusChamado.CANCELADO , StatusChamado.TROCA_DE_EQUIPAMENTO);
	}
	
	/**
	 * @author Rafael
	 * retorna a lista sem o status aberto e estourou sla
	 * @return
	 */
	public static List<StatusChamado> getListaSemAbertoESla(){
		return Arrays.asList(StatusChamado.FECHADO, StatusChamado.TROCA_DE_EQUIPAMENTO);
	}
}
