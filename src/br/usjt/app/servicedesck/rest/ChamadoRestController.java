package br.usjt.app.servicedesck.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.service.ChamadoService;


@RestController
public class ChamadoRestController {
	private ChamadoService chamadoService;
	
	
	@Autowired
	public ChamadoRestController(ChamadoService chamadoService) {
		this.chamadoService = chamadoService;
	}

	@RequestMapping(method=RequestMethod.GET, value="rest/chamado/listar/{idUsuario}")
	public @ResponseBody List<Chamado> listagem(@PathVariable("id") Long idUsuario) {
		return chamadoService.consultarChamadosFeitos(idUsuario);
	} 
	
	
	@RequestMapping(method=RequestMethod.GET, value="rest/chamado/{id}")
	public @ResponseBody Chamado listaChamado(@PathVariable("id") Long id) {
		Chamado chamado = new Chamado();
		try{
			
			chamado = chamadoService.consultar(id);
		} catch(Exception e){
			e.printStackTrace();
		}
		return chamado;
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST, value="rest/chamado")
	public ResponseEntity<Chamado> criarChamado(@RequestBody Chamado chamado){
		try{
			
			chamadoService.criar(chamado);
			return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Chamado>(chamado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="rest/chamado/cancelar/{id}")
	public void cancelarChamado( @PathVariable("id") Long id ){
		Chamado chamado = new Chamado();
		chamado.setId( id );
		try {
			chamadoService.cancelarChamado(chamado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="rest/chamado")
	public ResponseEntity<Chamado> alterarChamado( @RequestBody Chamado chamado ){
		try{
			chamadoService.atualizar(chamado);
			return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Chamado>(chamado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
