package br.usjt.app.servicedesck.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.app.servicedesck.model.Usuario;
import br.usjt.app.servicedesck.service.UsuarioService;

@Controller
public class LoginController {
	private UsuarioService userService;
	public static final String USUARIO_LOGADO = "br.usjt.app.servicedesck.usuario_logado";
	
	@Autowired
	public LoginController(UsuarioService userService) {
		this.userService = userService;
	}

	@RequestMapping(value={"","index"})
	public String index(){
		return "login";
	}
	
	@RequestMapping("fazer_login")
	public String fazerLogin(HttpSession session, Usuario usuario){
			Boolean retorno;
			retorno = userService.fazerLogin(usuario);
			if(retorno == true){
			session.setAttribute(USUARIO_LOGADO, usuario);
			System.out.println(retorno);
			}else {
				System.out.println(false);
				return "redirect:index";
			}
		
		return "index";
	}
	
}
