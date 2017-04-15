package br.usjt.app.servicedesck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.app.servicedesck.dao.FilaDAO;
import br.usjt.app.servicedesck.model.Fila;

@Service
public class FilaService {
	private FilaDAO filaDAO;
	
	@Autowired
	public FilaService(FilaDAO filaDAO) {
		this.filaDAO = filaDAO;
	}
	
	public void criar(Fila fila){
		fila.setAtiva(true);
		filaDAO.registrar(fila);
	}
	
	
	public void atualizar(Fila fila){
		Fila f = filaDAO.consultar(fila.getId());
		f.setAtiva(fila.isAtiva());
		filaDAO.atualizar(f);
	}
	
	public void excluir(Fila fila){
		filaDAO.excluir(fila);
	}
	
	
	
	public List<Fila> pesquisarPorNome(String nome){
		return filaDAO.pesquisarPorNome(nome);
	}
	
	public List<Fila> listar() {
		return filaDAO.listar();
	}
	
	public Fila consultar(Long id){
		return filaDAO.consultar(id);
	}

	public List<Fila> listarAtivas() {
		return filaDAO.listarAtivas();
	}
	
}
