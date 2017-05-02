package br.usjt.app.servicedesck.service;


import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.app.servicedesck.dao.ChamadoDAO;
import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.StatusChamado;
import br.usjt.app.servicedesck.model.Usuario;
import br.usjt.app.servicedesck.util.SlaUtil;
import br.usjt.app.servicedesck.util.SlaUtilFactory;

@Service
public class ChamadoService {
	private ChamadoDAO dao;

	
	@Autowired
	public ChamadoService(ChamadoDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * Metodo que passa o id para o dao para retornar o chamado dono do id
	 * @Author Rafael
	 */
	public Chamado consultar(Long id){
		return dao.consultar(id);
	}

	public void criar(Chamado chamado) {
		chamado.setStatus(StatusChamado.ABERTO);
		chamado.setDataDeAbertura( Calendar.getInstance() );
		
		dao.registrar(chamado);
	}
	
	public List<Chamado> listar(Long id, StatusChamado status){
		List<Chamado> lista = dao.listar(id, status);
		return lista;
	}
	
	
	/* Metodo que retorna uma lista de chamados, retornado do DAO.
	 * @Author Rafael
	 */
	public List<Chamado> pesquisar(String pesquisa){
		List<Chamado> lista = dao.pesquisar(pesquisa);
		sla(lista);
		return lista;
	}
	
	
	public List<Chamado> listarPorPrioridade(){
		List<Chamado> lista = dao.listarPorPrioridade();
		return lista;
	}
	
	/** Metodo que retorna uma lista de chamados, retornado do DAO.
	 * Author: Rafael
	 */
	public List<Chamado> pesquisar(String pesquisa, Long id, int tipo){

		List<Chamado> lista ; 
	
		if(tipo == 0){
			lista = dao.pesquisarChamadosSolicitante(pesquisa, id);
		}if(tipo == 1){
			lista = dao.pesquisar(pesquisa);
		} else{
			lista = dao.pesquisar(pesquisa);
		}
		return lista;
	}
	
	/**
	 * Esse metodo chama o dao passando o id do usuario para pesquisar todos os chamados que ele realizou 
	 * @Author Rafael
	 */
	public List<Chamado> consultarChamadosFeitos(Long id){
		List<Chamado> lista = dao.consultarChamadosFeitos(id);
		return lista;
	}
	
	public void atualizar(Chamado chamado){
		dao.atualizar(chamado);
	}
	
	// ---- ???? ----///
	private void sla(List<Chamado> lista){
		Calendar hoje = Calendar.getInstance();
		
		for(int i = 0; i < lista.size() ; i++){
			Chamado chamado = lista.get(i);
			SlaUtil util = SlaUtilFactory.create(chamado.getFila().getSla());
			util.contabilizarSla(chamado, hoje);
		}
	}
	
}
