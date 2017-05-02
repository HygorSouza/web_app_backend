package br.usjt.app.servicedesck.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.app.servicedesck.model.Usuario;
import br.usjt.app.servicedesck.service.FilaService;
import br.usjt.app.servicedesck.service.UsuarioService;

/**
 *
 * @author Hygor S.
 * @version 1.0.0
 * 
 */
@Transactional
@Controller
public class UsuarioController {
	
	private UsuarioService usuarioService;
	private FilaService filaService;
	/**
	 * @author Hygor S.
	 * @param usuarioService
	 *            - Objeto que contem todas as regras de negocio do usuario
	 * 
	 */
	@Autowired
	public UsuarioController(UsuarioService usuarioService, FilaService filaService) {
		this.usuarioService = usuarioService;
		this.filaService = filaService;
	}

	/**
	 * @author Hygor S.
	 * @return String- Uma string que identifica a pagina jsp que retorna para o
	 *         navegador
	 * 
	 */
	@RequestMapping("novo_solicitante")
	public String novoSolicitante() {
		return "usuario/criar_solicitante";
	}
	
	/**
	 * @author Hygor S.
	 * @return O jsp que sera rederizado pelo navegador
	 */
	@RequestMapping("novo_solucionador")
	public String novoSolucionador(Model model) {
		model.addAttribute("filas", filaService.listarAtivas());
		return "usuario/criar_solucionador";
	}
	

	/**
	 * @author Hygor S.
	 * @param user
	 *            - O usuario a ser registrado no sistema
	 * @return String- Uma string que identifica a pagina jsp que retorna para o
	 *         navegador
	 */
	@RequestMapping("criar_usuario")
	public String criarUsuario(@Valid Usuario user, BindingResult result) {
		if (!result.hasFieldErrors()) {

			usuarioService.criar(user);
		}

		return "index";

	}

	/**
	 * @author Hygor S.
	 * @return String - A pagina jsp para listar os usuarios
	 */
	@RequestMapping("pesquisar_usuario")
	public String pesquisarUsuario() {
		return "usuario/lista_de_usuarios";
	}

	/**
	 * @Author Hygor S.
	 * @param parametro
	 *            - Uma string que contem o nome ou cpf do usuario(s) a ser(em)
	 *            listado(s)
	 * @param model
	 *            - Objeto no qual e armazenado a lista de usuarios que foi
	 *            encontrada na consulta ao banco de dados
	 * @return String - A pagina jsp que exibe o resultado da consulta
	 * 
	 */
	@RequestMapping("consultar_usuario")
	public String consultarUsuario(@RequestParam("parametro") String parametro, @RequestParam("Ativo") int ativo,
			@RequestParam("Tipo") int tipo, Model model) {

		if (!parametro.equals("")) {
			model.addAttribute("usuarios", usuarioService.pesquisar(parametro));
		} else {

			List<Usuario> listaUsuario = usuarioService.listarPorTipo(ativo, tipo);
			model.addAttribute("usuarios", listaUsuario);
		}
		return "ajax/lista_de_usuarios_ajax";
	}

	@RequestMapping("atualizar_usuario")
	public String atualizarUsuario(@RequestParam("id") Long id, Model model) {
		model.addAttribute("usuario", usuarioService.consultar(id));
		return "usuario/atualizar_usuario";
	}

	@RequestMapping("alterar_usuario")
	public String alterarUsuario(Usuario user) {
		usuarioService.atualizar(user);
		return "usuario/lista_de_usuarios";
	}

	/**
	 * @author Rafael
	 * @param user
	 *            - O usuario a ser removido(excluido) do sistema
	 * @return String - Representa uma pagina jsp
	 */
	@RequestMapping("remover_usuario")
	public String removerUsuario(Usuario user) {
		usuarioService.atualizar(user);
		return "redirect:pesquisar_usuario";
	}
}
