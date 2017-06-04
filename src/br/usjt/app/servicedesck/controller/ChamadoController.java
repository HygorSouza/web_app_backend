package br.usjt.app.servicedesck.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.Fila;
import br.usjt.app.servicedesck.model.StatusChamado;
import br.usjt.app.servicedesck.model.Usuario;
import br.usjt.app.servicedesck.service.ChamadoService;
import br.usjt.app.servicedesck.service.FilaService;

@Transactional
@Controller
public class ChamadoController {
	private ChamadoService chamadoService;
	private FilaService filaService;

	@Autowired
	public ChamadoController(ChamadoService chamadoService, FilaService filaService) {
		this.chamadoService = chamadoService;
		this.filaService = filaService;
	}

	/**
	 * Redireciona o usuário para a tela de criar chamado, e passa todas as
	 * filas do sistema para a jsp pelo model
	 */
	@RequestMapping("novo_chamado")
	public String novoChamado(Model model) {
		model.addAttribute("filas", filaService.listarAtivas());
		return "chamado/criar_chamado";
	}

	/**
	 * Pega o chamado realizado pelo parametro Chamado, instancia uma sessão e
	 * pega o usuário que está logado na sessão e passa o usuário da sessão para
	 * o IdSolicitante, para gravar o usuário que abriu o chamado.
	 */
	@RequestMapping("criar_chamado")
	public String criarChamado(Chamado chamado, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute(LoginController.USUARIO_LOGADO);
		chamado.setCodigo(chamadoService.gerarCodigo());
		chamado.setSolicitante(user);
		chamadoService.criar(chamado);

		return "index";
	}

	@RequestMapping("cancelar_chamado")
	public void cancelarChamado(Chamado chamado, HttpServletResponse response) {
		chamadoService.cancelarChamado(chamado);
		response.setStatus(HttpServletResponse.SC_OK);
	}

	@RequestMapping("listar_chamado")
	public String listarChamado(Model model, HttpSession session) {
		List<StatusChamado> listaStatus = StatusChamado.getList();
		List<Chamado> listaChamado;
		List<Fila> listaFila = filaService.listarAtivas();
		Usuario user = (Usuario) session.getAttribute(LoginController.USUARIO_LOGADO);

		if (user.getTipo() == 0) {
			listaChamado = chamadoService.consultarChamadosFeitos(user.getId());
		}
		if (user.getTipo() == 1) {
			listaChamado = chamadoService.consultarChamadosFeitos(user.getId());
		} else {
			listaChamado = chamadoService.consultarChamadosFeitos(user.getId());
		}
		model.addAttribute("filas", listaFila);
		model.addAttribute("status", listaStatus);
		model.addAttribute("listaChamado", listaChamado);

		return "chamado/listar_chamado";
	}

	/**
	 * Metodo chamado apos o click no botão pesquisar buscando pelo texto do
	 * campo de pesquisa.
	 * 
	 * @Author: Rafael
	 */
	@RequestMapping("consultar_chamado")
	public String consultar(@RequestParam("pesquisa") String pesquisa, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute(LoginController.USUARIO_LOGADO);
		List<Chamado> lista = chamadoService.pesquisar(pesquisa, user.getId());
		model.addAttribute("listaChamado", lista);
		model.addAttribute("filas", filaService.listar());
		List<StatusChamado> listaStatus = StatusChamado.getList();
		model.addAttribute("status", listaStatus);
		return "chamado/listar_chamado";
	}

	/**
	 * Pega o valor do select da jsp cujo valor do íd é Fila.id e status,
	 * passando para o service via parametro no metodo listar, pega o retorno do
	 * metodo e manda para a jsp pelo model.addAtributte
	 * 
	 * @Author Rafael
	 */
	@RequestMapping("pesquisar_fila_status")
	public String pesquisarFilaStatus(@RequestParam("fila.id") Long id, @RequestParam("status") StatusChamado status,
			Model model) {
		List<Chamado> lista = chamadoService.listar(id, status);
		model.addAttribute("listaChamado", lista);
		model.addAttribute("filas", filaService.listar());
		List<StatusChamado> listaStatus = StatusChamado.getList();
		model.addAttribute("status", listaStatus);
		// return "ajax/listar_chamados_ajax";
		return "chamado/listar_chamado";
	}

	/**
	 * Este metodo recebe um id que irá passar para o service para trazer a
	 * postagem que foi escolhida pelo usuario
	 * vai Atualizar o chamado com a avaliação do solucionador.
	 * 
	 * @Author Rafael, Oscar
	 */
	@RequestMapping("atualizar_chamado")
	public String atualizarChamado(@RequestParam("statusChamado") StatusChamado status, @RequestParam("id") long id,
			@RequestParam(value = "motivoAvaliacao") String motivoAvaliacao, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute(LoginController.USUARIO_LOGADO);
		
		Chamado chamado = chamadoService.consultar(id);
		chamado.setSolucionador(user);
		chamado.setStatus(status);
		chamado.setMotivoAvaliacao(motivoAvaliacao);
		if(status.equals(StatusChamado.FECHADO)){ //TODO melhorar isso 
			chamado.setDataDeFechamento(Calendar.getInstance());
		}
		chamadoService.atualizar(chamado);
		model.addAttribute(chamado);

		return "redirect:listar_chamado";
	}

	/**
	 * Este metodo recebe um id que irá passar para o service para trazer as
	 * chamados que o usuario realizou
	 * 
	 * @Author Rafael
	 */
	@RequestMapping("pesquisar_data")
	public String pesquisarData(@RequestParam("dataAbertura")String dataAbertura, HttpServletRequest request, @RequestParam("dataFechamento")String dataFechamento, Model model) {
	
		
		Date dataInicio = null;
		Date dataFim = null;
		try {
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			dataInicio = new java.sql.Date(((java.util.Date)formatter.parse(dataAbertura)).getTime());
		    dataFim = new java.sql.Date(((java.util.Date)formatter.parse(dataFechamento)).getTime());
		} catch (ParseException e) {
				System.out.println("erro na data, metodo pesquisarData dentro do ChamadoController");
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute(LoginController.USUARIO_LOGADO);
		List<Chamado> lista;
		if(user.getTipo() == 1){
			 lista = chamadoService.listarPorData(dataInicio, dataFim, user.getFila().getId());
	    }else{
	    	 lista = chamadoService.listarPorData(dataInicio, dataFim);
	    }
		model.addAttribute("listaChamado", lista);
		model.addAttribute("filas", filaService.listar());
		List<StatusChamado> listaStatus = StatusChamado.getList();
		model.addAttribute("status", listaStatus);
		return "chamado/listar_chamado";
	}

	@RequestMapping("listar_chamadoUsuario")
	public String listaUsuarioChamado(Long id, Model model) {

		List<Chamado> listaSolicitante = chamadoService.consultarChamadosFeitos(id);
		model.addAttribute("listaSolicitante", listaSolicitante);
		return "usuario/chamado_usuario";
	}

	@RequestMapping("avaliar_chamado")
	public String avaliarChamado(Long id, Model model) {
		Chamado chamado = chamadoService.consultar(id);

		List<StatusChamado> listaStatus = StatusChamado.getListaSemAbertoESla();
		model.addAttribute("listaStatus", listaStatus);
		model.addAttribute("chamado", chamado);
		return "chamado/avaliar_chamado";
	}
}
