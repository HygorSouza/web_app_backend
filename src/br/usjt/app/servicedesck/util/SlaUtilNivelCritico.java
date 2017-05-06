package br.usjt.app.servicedesck.util;

import java.util.Calendar;

import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.StatusChamado;
import br.usjt.app.servicedesck.model.StatusSla;


/**
 * 
 * @author Hygor S.
 * @version 1
 */
public class SlaUtilNivelCritico extends SlaUtil {
	

	/**
	 * @author Hygor S.
	 * 
	 * 	 Calcula a horas passadas do registro do chamado com a contabiliade da sla de 24 hrs x 7
	 * 
	 * @param chamado O chamado que sera calculado as horas 
	 * @param calendar Representa a data de hoje ou a data de fechamento do chamado
	 * @return  o  status do chamado que foi calculado o seu tempo de atendimento
	 */
	@Override
	protected  StatusChamado contabilizar(Chamado chamado, Calendar calendar) {
		// 1000 milliseconds = 1 second
		// 60 seconds = 1 minute
		// 60 minutes = 1 hour
		// 24 hours = 1 day
		long milisegundos = calendar.getTimeInMillis() - chamado.getDataDeAbertura().getTimeInMillis();

		long horas = milisegundos / 3600000L; // 3600000L = 1 hora
		int tempoParaAtendimento = chamado.getFila().getSla().getTempoDeAtendimento();
		
		if(horas > tempoParaAtendimento ){
			chamado.setStatus(StatusChamado.ESTOROU_SLA);
		}
		
		chamado.setStatusSla(new StatusSla(chamado.getFila().getSla(), (int)horas));
		
		return chamado.getStatus();
	}
}
