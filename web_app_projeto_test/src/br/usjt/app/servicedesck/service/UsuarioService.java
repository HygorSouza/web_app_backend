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
	public void excluir(Usuario user){
		System.out.println(user.getId().toString());
		 Usuario usuario = consultar(user.getId());
		 if(usuario.getAtivo() == 1){
			 usuario.setAtivo(0);
		 }else{
			 usuario.setAtivo(1);
		 }
		 userDAO.atualizar(usuario);
	}

	public void atualizar(Usuario user) {
		Usuario u = consultar(user.getId());
		
		userDAO.atualizar(u);
	}

	public List<Usuario> pesquisar(String parametro) {
		if (parametro.matches("[0-9]*")) {
			return userDAO.pesquisarPorCPF(parametro);
		} else {
			return userDAO.pesquisarPorNome(parametro);
		}
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
