package br.usjt.app.servicedesck.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.app.servicedesck.model.Fila;
import br.usjt.app.servicedesck.service.FilaService;

@RestController
public class FilaRestController {
	private FilaService filaService;
	
	@Autowired
	public FilaRestController(FilaService filaService) {
		this.filaService = filaService;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="rest/filas")
	public @ResponseBody List<Fila> listarFila(){
		
		return filaService.listar();
	}
	
	
}
