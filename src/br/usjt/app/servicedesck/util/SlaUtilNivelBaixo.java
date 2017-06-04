package br.usjt.app.servicedesck.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;

import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.StatusChamado;

/**
 * 
 * @author Hygor S.
 * @version 1.0.0
 */
public class SlaUtilNivelBaixo extends SlaUtil {

	/**
	 * @author Hygor S.
	 * 
	 *         Calcula a horas passadas do registro do chamado com a
	 *         contabilidade da sla de 12 hrs x 5
	 * 
	 * @param chamado
	 *            O chamado que sera calculado as horas
	 * @param calendar
	 *            Representa a data de hoje ou a data de fechamento do chamado
	 * @return o chamado que foi calculado o seu tempo de atendimento
	 */
	@Override
	protected StatusChamado contabilizar(Chamado chamado, Calendar calendar) {
		Calendar data = chamado.getDataDeAbertura();
		YearMonth mesDoAnoChamado = YearMonth.of(data.get(Calendar.YEAR), data.get(Calendar.MONTH) + 1);
		YearMonth mesDoAno = YearMonth.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);

		LocalDate dataDoChamado = mesDoAnoChamado.atDay(data.get(Calendar.DAY_OF_MONTH));
		LocalDate dataDeHoje = mesDoAno.atDay(calendar.get(Calendar.DAY_OF_MONTH));

		int min = 7;
		int max = 19;

		int hr = 0;

		boolean isFimdeSemana = isFimDeSemana(dataDoChamado);
		
		if (!dataDoChamado.equals(dataDeHoje)) {
			
			hr = calculaHoraDeAbertura(data, min, max, isFimdeSemana);

			isFimdeSemana = isFimDeSemana(dataDeHoje);

			hr += calcularHorasAtuais(calendar, min, max, isFimdeSemana);

		} else {
			hr = calcularHorasParaOmesmoDia(calendar, data, min, max, isFimdeSemana);
		}
		// avanco um dia para nao contar o mesmo dia duas vezes
		dataDoChamado = dataDoChamado.plusDays(1);

		// calculo a quantidade de horas uteis que passaram
		int hrsUteis = diasUteis(dataDoChamado,dataDeHoje) * (max - min) + hr;

		//int tempoParaAtentimento = chamado.getFila().getSla().getTempoDeAtendimento();
		
		chamado.setHoras(hrsUteis);
		
		return chamado.getStatus();
	}
	/**
	 * @author Hygor S.
	 * 
	 * @param calendar
	 * @param data
	 * @param min
	 * @param max
	 * @param isFimdeSemana
	 * @return
	 */
	private int calcularHorasParaOmesmoDia(Calendar calendar, Calendar data, int min, int max,
			boolean isFimdeSemana) {
		int horas = 0;
		
		if ((data.get(Calendar.HOUR_OF_DAY) >= min && data.get(Calendar.HOUR_OF_DAY) <= max && !isFimdeSemana)
				&& (calendar.get(Calendar.HOUR_OF_DAY) >= min && calendar.get(Calendar.HOUR_OF_DAY) <= max)) {
			horas = calendar.get(Calendar.HOUR_OF_DAY) - data.get(Calendar.HOUR_OF_DAY);

		} else if ((data.get(Calendar.HOUR_OF_DAY) < min
				&& (calendar.get(Calendar.HOUR_OF_DAY) >= min && calendar.get(Calendar.HOUR_OF_DAY) <= max)
				&& !isFimdeSemana)) {
			
			horas = calendar.get(Calendar.HOUR_OF_DAY)  - min;
			
		} else if ((data.get(Calendar.HOUR_OF_DAY) >= min && calendar.get(Calendar.HOUR_OF_DAY) >= max
				&& !isFimdeSemana)) {
			horas = data.get(Calendar.HOUR_OF_DAY) - max;
		}
		return horas;
	}
	
	/**
	 * @author Hygor S.
	 * 
	 * @param calendar
	 * @param min
	 * @param max
	 * @param isFimdeSemana
	 * @return
	 */
	private int calcularHorasAtuais(Calendar calendar, int min, int max, boolean isFimdeSemana) {
		int horas = 0;
		if (calendar.get(Calendar.HOUR_OF_DAY) >= min && calendar.get(Calendar.HOUR_OF_DAY) <= max
				&& !isFimdeSemana) {
			horas = calendar.get(Calendar.HOUR_OF_DAY) - min;
		} else if (calendar.get(Calendar.HOUR_OF_DAY) > max && !isFimdeSemana) {
			horas = max - min;
		}
		return horas;
	}
	/**
	 * @author Hygor S.
	 * 
	 * @param data
	 * @param min
	 * @param max
	 * @param isFimdeSemana
	 * @return
	 */
	private int calculaHoraDeAbertura(Calendar data, int min, int max, boolean isFimdeSemana) {
		int hr = 0;
		if ( min >= data.get(Calendar.HOUR_OF_DAY)  && data.get(Calendar.HOUR_OF_DAY) <= max && !isFimdeSemana) {
			hr = max - data.get(Calendar.HOUR_OF_DAY);
		} else if (data.get(Calendar.HOUR_OF_DAY) < min && !isFimdeSemana) {
			hr = max - min;
		}
		return hr;
	}
	
	

	/**
	 * @author Hygor S.
	 * @param data
	 *            Representa uma data para verificar se ela e sabado ou domindo
	 * @return um boolean true se for sabado ou domingo false caso contrario
	 */
	private static boolean isFimDeSemana(LocalDate data) {
		return (data.getDayOfWeek() == DayOfWeek.SUNDAY || data.getDayOfWeek() == DayOfWeek.SATURDAY);
	}
	
	
	/**
	 * @author Hygor S.
	 * 
	 * @param dataDoChamado
	 * @param dataDeHoje
	 * @return
	 */
	private int diasUteis(LocalDate dataDoChamado, LocalDate dataDeHoje) {
		int diasUteis = 0;
		/** percorro as data ferificando se sao dias uteis */
		while (dataDoChamado.isBefore(dataDeHoje)) {

			if (!isFimDeSemana(dataDoChamado)) {
				diasUteis++;
			}
			dataDoChamado = dataDoChamado.plusDays(1);
		}
		return diasUteis;
	}
	
	
	
	
}
