package br.usjt.app.servicedesck.util;

import java.util.Calendar;

import br.usjt.app.servicedesck.model.Chamado;

// 1000 milliseconds = 1 second
// 60 seconds = 1 minute
// 60 minutes = 1 hour
// 24 hours = 1 day

public class SlaUtil {

	public static Chamado create() {
		Chamado c = new Chamado();
		Calendar ontem = Calendar.getInstance();
		ontem.set(Calendar.HOUR_OF_DAY, 7);
		ontem.set(Calendar.DAY_OF_MONTH, 3 );
		//ontem.set(Calendar.HOUR_OF_DAY, (ontem.get(Calendar.HOUR_OF_DAY) - 1));
		// ontem.add(Calendar.DAY_OF_MONTH, (ontem.get(Calendar.DAY_OF_MONTH) -
		// 7));

		c.setDataDeAbertura(ontem);
		return c;
	}

	public static void main(String[] args) {

		new SlaUtil().calcularSLA(create());
	}
	
	// calcula a horas passadas do registro do chamado com a contabiliade da sla de 12 hrs x 5
	// esta funciomando !!!
	public Chamado calcularSLA(Chamado chamado) {
		Calendar c = Calendar.getInstance();
		// c.set(Calendar.DAY_OF_WEEK, c.get(Calendar.DAY_OF_WEEK) + 1);
		//c.add(Calendar.DAY_OF_MONTH, 2);
		c.set(Calendar.DAY_OF_MONTH, 5 );
		c.set(Calendar.HOUR_OF_DAY, 7);
		// c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY );

		long milisegundos = c.getTimeInMillis() - chamado.getDataDeAbertura().getTimeInMillis();
		
		
		int min = 7;
		int max = 19;

		int horasUteis = max - min;

		long horas = milisegundos / (1000 * 60 * 60);

		System.out.println(horas + " horas ");

		System.out.println(horasUteis + " horas uteis");

		long dias = milisegundos / (1000 * 60 * 60 * 24);

		long diasUteis = dias - (dias * 2 / 7);

		System.out.println((diasUteis) + " dias uteis");

		int tempoParaAtendimento = (int) (horasUteis * diasUteis);
		System.out.println(tempoParaAtendimento + " tempo gasto para o atendimento");
		
		int tempo = (int) (horas - tempoParaAtendimento );
		System.out.println(tempo+" tempo que passou");
		String msg = (tempo> 24?"":"Nao ")+"Estourou sla";
			
		System.out.println(msg);

		return chamado;
	}

	// calcula a horas passadas do registro do chamado com a contabiliade da sla de 24 hrs x 5
	// esta funciomando !!!
	public Chamado testNivelCritico(Chamado chamado) {
		Calendar c = Calendar.getInstance();
		// c.set(Calendar.DAY_OF_WEEK, c.get(Calendar.DAY_OF_WEEK) + 1);
		// c.add(Calendar.DAY_OF_MONTH, );
		// c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY );

		long milisegundos = c.getTimeInMillis() - chamado.getDataDeAbertura().getTimeInMillis();

		long horas = milisegundos / (1000 * 60 * 60);
		String msg = (horas > 2 ? "" : "Nao ") + "Estourou sla de nivel critico";
		System.out.println(horas + " tempo em horas");
		System.out.println(msg);

		return chamado;
	}

}
