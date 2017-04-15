package br.usjt.app.servicedesck.controller;


import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.service.ChamadoService;
import br.usjt.app.servicedesck.service.FilaService;

@Transactional
@Controller
public class ChamadoController {
	private ChamadoService chamadoService;
	private FilaService filaService;
	
	@Autowired
	public ChamadoController(ChamadoService chamadoService,FilaService filaService) {
		this.chamadoService = chamadoService;
		this.filaService = filaService;
	}
	
	@RequestMapping("novo_chamado")
	public String novoChamado(Model model){
		model.addAttribute("filas",filaService.listarAtivas());
		return "criar_chamado";
	}
	
	@RequestMapping("criar_chamado")
	public String criarChamado(Chamado chamado){
		chamadoService.criar(chamado);
		return "index";
	}

	 
	@RequestMapping("listar_chamado")
	public String listarChamado(Model model){
		List<String> listaStatus = Arrays.asList("Aberto", "Fechado", "Cancelado");
		model.addAttribute("filas", filaService.listarAtivas());
		model.addAttribute("status", listaStatus);
		return "listar_chamado";
	}
	
	
	/* Metodo chamado apos o click no botão pesquisar, buscando por fila,
	 * status ou pelo texto do campo de pesquisa. 
	 * @Author: Rafael
	 */
	@RequestMapping("consultar_chamado")
	public String consultar(@RequestParam("fila.id")Long id, @RequestParam("status")String status, @RequestParam("pesquisa")String pesquisa,  Model model){
		
		List<Chamado> lista;
		
		System.out.print("aqui");
		if(pesquisa.equals("")){
			lista = chamadoService.listar(id, status);
		} 
		else {
			lista = chamadoService.pesquisar(pesquisa);
		}
		
			model.addAttribute("listaChamado", lista);
		return "ajax/listar_chamados_ajax";
	}
	
   
	/* Este metodo recebe um id que irá passar para o service para trazer 
    * a postagem que foi escolhida pelo usuario
    * @Author Rafael
   	*/
		@RequestMapping("atualizar_chamado")
		public String atualizarChamado(Long id, Model model){
			Chamado chamado = chamadoService.consultar(id);
			model.addAttribute(chamado);
		
			return "teste";
		}
}

	

