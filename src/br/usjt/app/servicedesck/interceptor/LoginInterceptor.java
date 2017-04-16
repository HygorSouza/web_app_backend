package br.usjt.app.servicedesck.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.usjt.app.servicedesck.controller.LoginController;
import br.usjt.app.servicedesck.model.Usuario;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//String url = request.getRequestURI();
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute(LoginController.USUARIO_LOGADO);
		if( user != null){
		
		}
		
		if(user == null){
			
		}
		return super.preHandle(request, response, handler);
	}
}
