package br.usjt.app.servicedesck.util;

import java.util.Calendar;

import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.StatusChamado;

public abstract class SlaUtil {

	public final StatusChamado contabilizarSla(Chamado chamado, Calendar calendar) {
		if(chamado.getStatus() != StatusChamado.CANCELADO  ){
			if (chamado.getDataDeFechamento() == null) {
				return contabilizar(chamado, calendar);
			} else {
				return contabilizar(chamado, chamado.getDataDeFechamento());
			}
		} else {
			return chamado.getStatus();
		}
	}

	protected abstract StatusChamado contabilizar(Chamado chamado, Calendar calendar);

}
