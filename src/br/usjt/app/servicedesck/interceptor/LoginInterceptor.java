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

		String uri = request.getRequestURI();

		if (uri.contains("res") || uri.contains("index") || uri.contains("fazer_login")) {
			return true;
		}

		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute(LoginController.USUARIO_LOGADO);

		if (user != null) {
			return true;
		} else {
			response.sendRedirect("index");
			return false;
		}
	}
}
