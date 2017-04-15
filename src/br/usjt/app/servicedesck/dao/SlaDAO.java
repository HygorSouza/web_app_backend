package br.usjt.app.servicedesck.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.app.servicedesck.model.SLA;

@Repository
public class SlaDAO {
	@PersistenceContext
	EntityManager manager;
	
	
	@SuppressWarnings("unchecked")
	public List<SLA> listarTodas(){
		String jpql = "SELECT  s FROM SLA s";
		Query query = manager.createQuery(jpql);
		return  query.getResultList();
	} 
	
	
}
