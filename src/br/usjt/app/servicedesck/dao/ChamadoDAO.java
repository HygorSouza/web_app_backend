package br.usjt.app.servicedesck.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
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
	
	/**
	 * Metodo que consulta o banco de dados e retorna o chamado 
	 * que conter aquele id
	 * @author Rafael
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

	/** Metodo de pesquisa dentro do banco, buscando as informações enviadas
	 * via parametro.
	 * @author Rafael
	 */
	public List<Chamado> pesquisar(String pesquisar){
		String jpql = "SELECT c FROM Chamado c WHERE c.breveDescricao like :pesquisar";
		TypedQuery<Chamado> query = manager.createQuery(jpql, Chamado.class);
		query.setParameter("pesquisar",pesquisar+"%");
		return query.getResultList();
	}
	
	/**
	 * @author Rafael
	 * O metodo recebe duas datas e pesquisa por chamados realizados entre essas datas
	 */
	public List<Chamado> listarPorDataAberturaFechamento(Date dataAbertura, Date dataFechamento){
		String jpql = "SELECT c FROM Chamado c WHERE c.dataDeAbertura >= :dataAbertura AND c.dataDeAbertura <= :dataFechamento";
		TypedQuery<Chamado> query = manager.createQuery(jpql, Chamado.class);
		query.setParameter("dataAbertura", dataAbertura, TemporalType.DATE);
		query.setParameter("dataFechamento", dataFechamento, TemporalType.DATE);
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
	 * @author Rafael
	 */
	public List<Chamado> pesquisarChamadosSolicitante(String pesquisar, Long id){
		String jpql = "SELECT c FROM Chamado c WHERE c.solicitante.id = :id AND c.breveDescricao LIKE :pesquisar";
		TypedQuery<Chamado> query = manager.createQuery(jpql, Chamado.class);
		query.setParameter("pesquisar", pesquisar+"%");
		query.setParameter("id", id);
		return query.getResultList();
	}

	
	public List<Chamado>  pesquisarChamadoSolucionador(String pesquisar, Long id, Long fila){
		String jpql = "SELECT c FROM Chamado c WHERE c.solucionador.id = :id OR c.fila.id = :idFila AND c.breveDescricao LIKE :pesquisar";
		TypedQuery<Chamado> query = manager.createQuery(jpql, Chamado.class);
		query.setParameter("pesquisar", pesquisar+"%");
		query.setParameter("id", id);
		query.setParameter("idFila", fila);
		return query.getResultList();
	}
	/**
	 * @author Hygor S.
	 * 
	 * @param chamado
	 */
	public void cancelarChamado(Chamado chamado) {
		String jpql = "UPDATE Chamado c SET c.status = :status WHERE c.id = :id";
		Query query = manager.createQuery(jpql);
		query.setParameter("status", chamado.getStatus());
		query.setParameter("id", chamado.getId());
		query.executeUpdate();
	}
	
}
