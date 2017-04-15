package br.usjt.app.servicedesck.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.usjt.app.servicedesck.model.Usuario;

@Repository
public class UsuarioDAO {
	@PersistenceContext
	EntityManager manager;
	
	
	public void registrar(Usuario usuario){
		manager.persist(usuario);
	}
	
	public void atualizar(Usuario user){
		manager.merge(user);
	}
	
	public Usuario pesquisar(Long id){
		return manager.find(Usuario.class, id);
	}

	public List<Usuario> pesquisarPorCPF(String cpf) {
		String jpql = "SELECT user FROM Usuario user WHERE user.cpf = :cpf";
		TypedQuery<Usuario> query = manager.createQuery(jpql,Usuario.class);
		query.setParameter("cpf", cpf);
		return query.getResultList();
	}
	
	public List<Usuario> pesquisarPorNome(String nome){
		String jpql = "SELECT user FROM Usuario user WHERE user.nome LIKE :nome";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		query.setParameter("nome", nome+"%");
		return query.getResultList();
	}

	public boolean fazerLogin(Usuario user) {
		String jpql = "SELECT user FROM Usuario user WHERE user.username = :username AND user.password = :password";
		TypedQuery<Usuario> query = manager.createQuery(jpql,Usuario.class);
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		List<Usuario> lista = query.getResultList();
		return ( lista != null && lista.size() == 1 );
	}
	
	public List<Usuario> listarTipoEStatus(int ativo, int tipo){
		String jpql = "SELECT user FROM Usuario user WHERE user.ativo = :ativo AND user.tipo = :tipo";
		TypedQuery<Usuario> query = manager.createQuery(jpql,Usuario.class);
		query.setParameter("ativo", ativo);
		query.setParameter("tipo", tipo);
		List<Usuario> lista = query.getResultList();
		return lista;
	}
	public List<Usuario> listarTodos() {
		String jpql = "SELECT user FROM Usuario user";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}
	
	public List<Usuario> pesquisarTipo(int tipo){
		String jpql = "SELECT user FROM Usuario user where user.tipo = :tipo";
		TypedQuery<Usuario> query = manager.createQuery(jpql,Usuario.class);
		query.setParameter("tipo", tipo);
		return query.getResultList();
	}
	
	public List<Usuario> pesquisarStatus(int ativo){
		String jpql = "SELECT user FROM Usuario user where user.ativo = :ativo";
		TypedQuery<Usuario> query = manager.createQuery(jpql,Usuario.class);
		query.setParameter("ativo", ativo);
		return query.getResultList();
	}
}
