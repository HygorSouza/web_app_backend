package br.usjt.app.servicedesck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.app.servicedesck.dao.SlaDAO;
import br.usjt.app.servicedesck.model.SLA;

@Service
public class SlaService {
	
	private SlaDAO dao;
	
	@Autowired
	public SlaService(SlaDAO dao) {
		this.dao = dao;
	}
	
	public List<SLA> listarTodas(){
		return dao.listarTodas();
	}
	
	public SLA pesquisar(Long id){
		return dao.pesquisar(id);
	}
	
}
