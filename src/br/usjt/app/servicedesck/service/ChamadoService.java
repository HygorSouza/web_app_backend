package br.usjt.app.servicedesck.service;


import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.app.servicedesck.dao.ChamadoDAO;
import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.Fila;

@Service
public class ChamadoService {
	private ChamadoDAO dao;
	private FilaService filaService;
	
	@Autowired
	public ChamadoService(ChamadoDAO dao,FilaService filaService) {
		this.dao = dao;
		this.filaService = filaService;
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
	
}
