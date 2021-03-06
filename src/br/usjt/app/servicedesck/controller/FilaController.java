package br.usjt.app.servicedesck.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.app.servicedesck.model.Fila;
import br.usjt.app.servicedesck.service.FilaService;
import br.usjt.app.servicedesck.service.SlaService;

@Transactional
@Controller
@RequestMapping(FilaController.URI)
public class FilaController {
	private FilaService filaService;
	private SlaService slaService;
	
	public static final String URI = "fila/";
	
	@Autowired
	public FilaController(FilaService filaService,SlaService slaService) {
		this.filaService = filaService;
		this.slaService = slaService;
	}
	
	@RequestMapping("nova_fila")
	public String novaFila(Model model){
		model.addAttribute("slas", slaService.listarTodas());
		return "fila/criar_fila";
	}
	
	@RequestMapping("criar_fila")
	public String criarFila(Fila fila){
		filaService.criar(fila);
		return "index";
	}
	
	
	//atualizar fila
	@RequestMapping("atualizar_fila")
	public String atualizarFila(@RequestParam("id") Long id,Model model){
		model.addAttribute("fila", filaService.consultar(id) );
		return "fila/atualizar_fila";
	}
	
	@RequestMapping("alterar_fila")
	public String alterarFila(Fila fila){
		filaService.atualizar(fila);
		return "fila/lista_de_filas";
	}
	
	// pesquisar filas
	
	@RequestMapping("lista_de_filas")
	public String listaDeFila(){
		return "fila/lista_de_filas";
	}
	
	@RequestMapping("pesquisar_filas")
	public String listarFilas(@RequestParam(name="param",required=false,defaultValue="") String param , Model model){
		if( param.equals("") ){
			model.addAttribute("filas", filaService.listar());
		} else{
			model.addAttribute("filas", filaService.pesquisarPorNome(param));
		}
		//return "ajax/lista_de_filas_ajax";
		return "fila/lista_de_filas";
	}
	
	
	// remover fila
	@RequestMapping("remover_fila")
	public String removerFila(@RequestParam(name="id")Long id){
		filaService.excluir(id);
		return "fila/lista_de_filas";
	}
	
}
