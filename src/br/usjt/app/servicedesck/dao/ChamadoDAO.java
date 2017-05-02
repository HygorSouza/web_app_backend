package br.usjt.app.servicedesck.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.StatusChamado;

@Repository
public class ChamadoDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public void registrar(Chamado chamado){
		manager.persist(chamado);
	}
	
	public void atualizar(Chamado chamado){
		manager.merge(chamado);
	}
	
	/*
	 * Metodo que consulta o banco de dados e retorna o chamado 
	 * que conter aquele id
	 * @Author Rafael
	 */
	public Chamado consultar(Long id){
		return manager.find(Chamado.class, id);
	}
	
	public List<Chamado> listar(Long id, StatusChamado status){
		
		String jpql = "SELECT c FROM Chamado c WHERE c.fila.id = :id and c.status = :status";
		TypedQuery<Chamado> query = manager.createQuery(jpql, Chamado.class);
		query.setParameter("id", id);
		query.setParameter("status", status);
		return query.getResultList();
	}

	/* Metodo de pesquisa dentro do banco, buscando as informações enviadas
	 * via parametro.
	 * Author: Rafael
	 */
	public List<Chamado> pesquisar(String pesquisar){
		String jpql = "SELECT c FROM Chamado c WHERE c.breveDescricao like :pesquisar or c.descricao like :pesquisar";
		TypedQuery<Chamado> query = manager.createQuery(jpql, Chamado.class);
		query.setParameter("pesquisar","%"+pesquisar+"%");
		return query.getResultList();
	}
	
	public List<Chamado> listarPorPrioridade(){
		TypedQuery<Chamado> query = manager.createNamedQuery("Chamado.porPrioridade", Chamado.class);
		return query.getResultList();
	}
	public List<Chamado> consultarChamadosFeitos(Long id) {
		TypedQuery<Chamado> query = manager.createNamedQuery("Chamado.porPrioridadePorSolicitante", Chamado.class);
		query.setParameter("idSolicitante", id);
		return query.getResultList();
	}
	
	/**
	 * Consulta o banco e pega todos os chamados realizados por aquele usuario
	 * @Author Rafael
	 */
	public List<Chamado> pesquisarChamadosSolicitante(String pesquisar, Long id){
		String jpql = "SELECT c FROM Chamado c WHERE c.idSolicitante.id = :id AND c.breveDescricao LIKE :pesquisar";
		TypedQuery<Chamado> query = manager.createQuery(jpql, Chamado.class);
		query.setParameter("pesquisar", "%"+pesquisar+"%");
		query.setParameter("id", id);
		return query.getResultList();
	}
	
}
