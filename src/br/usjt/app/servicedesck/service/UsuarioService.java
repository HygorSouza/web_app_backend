package br.usjt.app.servicedesck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.app.servicedesck.dao.UsuarioDAO;
import br.usjt.app.servicedesck.model.Usuario;

@Service
public class UsuarioService {
	private UsuarioDAO userDAO;

	@Autowired
	public UsuarioService(UsuarioDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void criar(Usuario user) {
		user.setAtivo(1);
		userDAO.registrar(user);
	}

	public void atualizar(Usuario user) {
		Usuario u = consultar(user.getId());
		u.setNome(user.getNome());
		u.setCargo(user.getCargo());
		u.setAtivo(user.getAtivo());
		
		userDAO.atualizar(u);
	}

	public List<Usuario> pesquisar(String parametro) {
		if (parametro.matches("[0-9]*")) {
			return pesquisarPorCPF(parametro);
		} else {
			return pesquisarPorNome(parametro);
		}
	}

	private List<Usuario> pesquisarPorCPF(String cpf) {
		return userDAO.pesquisarPorCPF(cpf);
	}

	private List<Usuario> pesquisarPorNome(String nome) {
		return userDAO.pesquisarPorNome(nome);
	}

	public boolean fazerLogin(Usuario user) {
		return userDAO.fazerLogin(user);
	}

	public Usuario consultar(Long id) {
		return userDAO.pesquisar(id);
	}
	
	public List<Usuario> listarPorTipo(int ativo, int tipo){
		
		if(ativo == 2 && tipo == 2){
			System.out.println("aa");
			return userDAO.listarTodos();
		}
		if(ativo == 2 && tipo != 2){
			return userDAO.pesquisarTipo(tipo);
		}
		if(ativo != 2 && tipo == 2){
			return userDAO.pesquisarStatus(ativo);
		}
		return userDAO.listarTipoEStatus(ativo, tipo);
	}
}
