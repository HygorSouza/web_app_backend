package br.usjt.app.servicedesck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.app.servicedesck.dao.FilaDAO;
import br.usjt.app.servicedesck.model.Fila;
import br.usjt.app.servicedesck.model.SLA;

@Service
public class FilaService {
	private FilaDAO filaDAO;
	private SlaService slaService;
	
	@Autowired
	public FilaService(FilaDAO filaDAO , SlaService slaService) {
		this.filaDAO = filaDAO;
		this.slaService = slaService;
	}
	
	public void criar(Fila fila){
		SLA s = slaService.pesquisar(fila.getSla().getId());
		fila.setAtiva(true);
		fila.setSla(s);
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
