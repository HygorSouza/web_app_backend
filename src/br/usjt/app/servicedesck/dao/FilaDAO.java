package br.usjt.app.servicedesck.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.usjt.app.servicedesck.model.Fila;

@Repository
public class FilaDAO {

	@PersistenceContext
	EntityManager manager;

	public void registrar(Fila fila) {
		manager.persist(fila);
	}

	public void atualizar(Fila fila){
		manager.merge(fila);
	}

	public void excluir(Fila fila) {
		manager.remove( consultar( fila.getId() ) );
	}
	
	public Fila consultar(Long id) {
		return manager.find(Fila.class, id);
	}
	
	
	public List<Fila> listar(){
		String jpql = "SELECT fila FROM Fila fila";
		TypedQuery<Fila> query = manager.createQuery(jpql, Fila.class);
		return query.getResultList();
	}

	public List<Fila> pesquisarPorNome(String nome) {
		String jpql = "SELECT fila FROM Fila fila WHERE fila.nome LIKE :nome";
		TypedQuery<Fila> query = manager.createQuery(jpql, Fila.class);
		query.setParameter("nome", nome+"%");
		return query.getResultList();
	}

	public List<Fila> listarAtivas() {
		//String jpql = "SELECT fila FROM Fila fila WHERE fila.ativa = true";
		TypedQuery<Fila> query = manager.createNamedQuery("Fila.listarAtivas",Fila.class);
		query.setParameter("ativa", true);
		return query.getResultList();
	}
	
}
