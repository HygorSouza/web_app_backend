package br.usjt.app.servicedesck.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.usjt.app.servicedesck.model.SLA;

@Repository
public class SlaDAO {
	@PersistenceContext
	EntityManager manager;
	
	

	public List<SLA> listarTodas(){
		//String jpql = "SELECT  s FROM SLA s";
		TypedQuery<SLA> query = manager.createNamedQuery("SLA.listarTodas", SLA.class);
		return  query.getResultList();
	}
	
	public SLA pesquisar(Long id){
		return manager.find(SLA.class, id);
	}
	
	
}
