package br.usjt.app.servicedesck.service;


import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.app.servicedesck.dao.ChamadoDAO;
import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.Fila;
import br.usjt.app.servicedesck.model.SLA;

@Service
public class ChamadoService {
	private ChamadoDAO dao;
	private FilaService filaService;
	private SlaService  slaService;
	
	@Autowired
	public ChamadoService(ChamadoDAO dao,FilaService filaService,SlaService  slaService) {
		this.dao = dao;
		this.filaService = filaService;
		this.slaService = slaService;
	}
	
	/*
	 * Metodo que passa o id para o dao para retornar o chamado dono do id
	 * @Author Rafael
	 */
	public Chamado consultar(Long id){
		return dao.consultar(id);
	}

	public void criar(Chamado chamado) {
		chamado.setStatus("Aberto");
		Fila fila = filaService.consultar(chamado.getFila().getId());
		chamado.setFila(fila);
		if( chamado.getDataDeAbertura() == null ){
			chamado.setDataDeAbertura( Calendar.getInstance() );
		}
		dao.registrar(chamado);
	}
	
	public List<Chamado> listar(Long id, String status){
		List<Chamado> lista = dao.listar(id, status);
		return lista;
		
	}
	
	
	/* Metodo que retorna uma lista de chamados, retornado do DAO.
	 * Author: Rafael
	 */
	public List<Chamado> pesquisar(String pesquisa){
		List<Chamado> lista = dao.pesquisar(pesquisa);
		return lista;
	}
	
	
	public List<Chamado> listar(){
		return dao.listarPorPrioridade();
	}
	
// Não mexer por favor !!!!!!!!!!!!!!!!!
//	public String calcularSLA(Chamado chamado,int nivel){
//		//
//		Calendar tempoDeAtendimento = Calendar.getInstance();
//		Calendar dataAtual = Calendar.getInstance();
//		tempoDeAtendimento.set(Calendar.HOUR_OF_DAY, 2);
//		tempoDeAtendimento.set(Calendar.MINUTE,00);
//		tempoDeAtendimento.set(Calendar.SECOND,00);
//		
//		String sTempo 	  = String.format("tempo de atendimento: %02d:%02d:%02d", tempoDeAtendimento.get(Calendar.HOUR_OF_DAY),tempoDeAtendimento.get(Calendar.MINUTE),tempoDeAtendimento.get(Calendar.SECOND));
//		String sDataAtual = String.format("Data atual: %02d:%02d:%02d", dataAtual.get(Calendar.HOUR_OF_DAY),dataAtual.get(Calendar.MINUTE),dataAtual.get(Calendar.SECOND));
//		
//		String s = "";
//		
//		System.out.println("tempo de atendimento");
//		System.out.println( sTempo );
//		
//		SLA sla = new SLA();
//		sla.setNivel(nivel);
//		
//		Calendar dataDeAbertura = chamado.getDataDeAbertura();
//		switch ( sla.getNivel() ) {
//		case 0:
//		case 1:
//		case 2:
//			
//			s = String.format("Data de abertura do chamado: %02d:%02d:%02d", dataDeAbertura.get(Calendar.HOUR_OF_DAY),dataDeAbertura.get(Calendar.MINUTE),dataDeAbertura.get(Calendar.SECOND));
//			
//			if( dataAtual.get(Calendar.YEAR) == dataDeAbertura.getMaximum(Calendar.YEAR) ){
//				if(dataAtual.get(Calendar.MONTH) == dataDeAbertura.getMaximum(Calendar.MONTH)){
//					if(dataAtual.get(Calendar.HOUR_OF_DAY) == dataDeAbertura.getMaximum(Calendar.HOUR_OF_DAY)){
//						
//					}
//				}
//			}
//			
//			break;
//		default:
//			break;
//		}
//		
//		System.out.println(s+"\n");
//		System.out.println(sDataAtual);
//		
//		return s+"\n"+sDataAtual;
//	}
}
