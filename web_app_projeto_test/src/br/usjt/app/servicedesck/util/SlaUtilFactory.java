package br.usjt.app.servicedesck.util;

import java.util.HashMap;
import java.util.Map;

import br.usjt.app.servicedesck.model.SLA;
/**
 * 
 * @author Hygor S.
 * @version 1
 * 
 * Classe responsavel por instanciar um objeto do tipo SlaUtil
 *  que contem as regras para contabilizar a sla do chamado
 * 
 */
public abstract class SlaUtilFactory {
	private static Map<String, SlaUtil> instance = new HashMap<String, SlaUtil>();
	public static String NIVEL_CRITICO = "CRITICO";
	public static String NIVEL_BAIXO = "BAIXO";
	
	/**
	 * @author Hygor S.
	 * @param nivelSla Inteiro que representa o nivel da sla
	 * @return um objeto do tipo SlaUtil
	 */
	public static SlaUtil create(SLA sla){
		String nivel = nivel(sla);
		if( !instance.containsKey(nivel) ){
			instance.put(nivel, createUtil(nivel) );
		}
		return instance.get(nivel);
	}
	
	/**
	 * @author Hygor S.
	 * @param nivel Inteiro que representa o nivel da sla
	 * @return Uma string que informa qual subclasse de SlaUtil  que tera um objeto criado
	 */
	private static String nivel(SLA sla){
		if(sla.getNivel() >= 0 &&  sla.getNivel() <= 2){
			return NIVEL_CRITICO;
		} else if(sla.getNivel() >= 3 && sla.getNivel() <= 5){
			return NIVEL_BAIXO;
		} else {
			throw new RuntimeException(String.format("Nivel: %d nao existente",sla.getNivel()));
		}
	} 
	
	/**
	 * @author Hygor S.
	 * @param util String usada para indicar qual objeto SlaUtil sera instanciado
	 * @return um objeto do tipo SlaUtil
	 */
	protected static SlaUtil createUtil(String util){
		if(util.equals(NIVEL_CRITICO)){
			return new SlaUtilNivelCritico();
		} else{
			return new SlaUtilNivelBaixo();
		}
	}
	
}
