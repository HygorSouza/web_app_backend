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
import br.usjt.app.servicedesck.model.Usuario;
import br.usjt.app.servicedesck.service.ChamadoService;


@RestController
public class ChamadoRestController {
	private ChamadoService chamadoService;
	
	
	@Autowired
	public ChamadoRestController(ChamadoService chamadoService) {
		this.chamadoService = chamadoService;
	}

	@RequestMapping(method=RequestMethod.POST, value="rest/chamado/usuario")
	public @ResponseBody List<Chamado> listagem(@RequestBody Usuario usuario) {
		return chamadoService.consultarChamadosFeitos(usuario.getId());
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
	
	/*@RequestMapping(method=RequestMethod.DELETE, value="rest/chamado/{id}")
	public void excluirLocal( @PathVariable("id") Long id ){
		Chamado local = new Chamado();
		local.setId( id );
		try {
			ls.remover(local);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="rest/chamado")
	public ResponseEntity<Chamado> alterarLocal( @RequestBody Chamado chamado ){
		try{
			ls.atualizar(chamado);
			return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
		} catch(IOException e){
			e.printStackTrace();
			return new ResponseEntity<Chamado>(chamado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
}
