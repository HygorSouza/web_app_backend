package br.usjt.app.servicedesck.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.app.servicedesck.model.Usuario;
import br.usjt.app.servicedesck.service.UsuarioService;

@RestController
public class LoginRestController {
	private UsuarioService usuarioService;
	
	@Autowired
	public LoginRestController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="rest/login")
	public @ResponseBody Usuario fazerLogin(@RequestBody Usuario usuario){
		boolean flag = usuarioService.fazerLogin(usuario);
		if(flag){
			return usuario;
		}
		return null;
	}
}
