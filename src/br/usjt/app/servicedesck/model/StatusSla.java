package br.usjt.app.servicedesck.model;

/**
 * 
 * @author Hygor S.
 * @version 1.0.0
 */
public class StatusSla {
	
	private SLA sla;
	private int horas;
	
	public StatusSla(SLA sla , int horas) {
		this.sla = sla;
		this.horas = horas;
	}
	
	public int percentual(){
		int resultado = 0;
		if(horas == 0){
			resultado = 0;
		} else {
			resultado = (horas * 100) / sla.getTempoDeAtendimento();
		}
		
		return resultado;
	}
	
	public String descricao(){
		String msg = "";
		
		
		
		return msg;
	}
	
	public static void main(String[] args) {
		SLA sla = new SLA();
		sla.setNivel(2);
		sla.setTempoDeAtendimento(10);
		
		
		StatusSla s = new StatusSla(sla, 2);
		
		System.out.println(s.percentual());
		System.out.println(s.descricao());
	}

}
