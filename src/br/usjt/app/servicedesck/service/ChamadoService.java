package br.usjt.app.servicedesck.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.app.servicedesck.dao.ChamadoDAO;
import br.usjt.app.servicedesck.dao.UsuarioDAO;
import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.StatusChamado;
import br.usjt.app.servicedesck.model.Usuario;
import br.usjt.app.servicedesck.util.SlaUtil;
import br.usjt.app.servicedesck.util.SlaUtilFactory;
/**
 * 
 * @author 
 * @version 2.0.0
 */
@Service
public class ChamadoService {
	private ChamadoDAO dao;
	private UsuarioDAO daoUsuario;

	@Autowired
	public ChamadoService(ChamadoDAO dao, UsuarioDAO daoUsuario) {
		this.dao = dao;
		this.daoUsuario = daoUsuario;
	}
	
	/**
	 * @author note-hugo
	 * @param dataAbertura
	 * @param dataFechamento
	 * @param idFila
	 * Lista por data para o solucionador, listando todos os chamados entre aquelas datas somente da 
	 * d
	 * @return
	 */
	public List<Chamado> listarPorData(Date dataAbertura, Date dataFechamento, Long idFila) {
		List<Chamado> lista = dao.listarPorDataAberturaFechamento(dataAbertura, dataFechamento, idFila);
		sla(lista);
		return lista;
	}
	
	/**
	 * @author note-hugo
	 * @param dataAbertura
	 * @param dataFechamento
	 * @param idFila
	 * @return
	 * 
	 * Lista por data para o administrador, listando todos os chamados do sistema
	 */
	public List<Chamado> listarPorData(Date dataAbertura, Date dataFechamento) {
		List<Chamado> lista = dao.listarPorDataAberturaFechamento(dataAbertura, dataFechamento);
		sla(lista);
		return lista;
	}
	
	/**
	 * @author Rafael
	 * gera uma string de 8 digitos e chama o metodo do dao verificar se a string já existe no banco
	 * @return uma string disponivel
	 */
	public String gerarCodigo(){
		String gerada;
		boolean flag = false;
	
			do {
				
				UUID uuid = UUID.randomUUID();
				gerada = uuid.toString();
				gerada = gerada.substring(0,6);
				dao.gerarCodigo(gerada);
				System.out.println(flag);
				
					
			}while(flag == true);
	
		
		return gerada;
	}

	public void criar(Chamado chamado) {
		chamado.setStatus(StatusChamado.ABERTO);
		chamado.setCodigo(gerarCodigo());
		chamado.setDataDeAbertura(Calendar.getInstance());

		dao.registrar(chamado);
	}

	/**
	 * Metodo que retorna uma lista de chamados, retornado do DAO.
	 * 
	 * @Author Rafael
	 */
	public List<Chamado> pesquisar(String pesquisa) {
		List<Chamado> lista = dao.pesquisar(pesquisa);
		sla(lista);
		return lista;
	}


	/**
	 * Esse metodo chama o dao passando o id do usuario para pesquisar todos os
	 * chamados que ele realizou
	 * 
	 * @Author Rafael
	 */
	public List<Chamado> consultarChamadosFeitos(Long id) {
		List<Chamado> lista = dao.consultarChamadosFeitos(id);
		sla(lista);
		return lista;
	}

	/**
	 * Metodo que passa o id para o dao para retornar o chamado dono do id
	 * 
	 * @Author Rafael
	 */
	public Chamado consultar(Long id) {
		Chamado c = dao.consultar(id);
		sla(c);
		return c;
	}

	public List<Chamado> listar(Long id, StatusChamado status) {
		List<Chamado> lista = dao.listar(id, status);
		sla(lista);
		return lista;
	}

	public List<Chamado> listarPorPrioridade() {
		List<Chamado> lista = dao.listarPorPrioridade();
		sla(lista);
		return lista;
	}

	/**
	 * Metodo que retorna uma lista de chamados, retornado do DAO.
	 * @author Rafael
	 */
	public List<Chamado> pesquisar(String pesquisa, Long id) {

		List<Chamado> lista;
		Usuario user = daoUsuario.pesquisar(id);

		if (user.getTipo() == Usuario.SOLICITANTE) {
			lista = dao.pesquisarChamadosSolicitante(pesquisa, id);

		} else if (user.getTipo() == Usuario.SOLUCIONADOR) {
			lista = dao.pesquisarChamadoSolucionador(pesquisa, id, user.getFila().getId());
		} else {
			lista = dao.pesquisar(pesquisa);
		}
		sla(lista);
		return lista;
	}
	
	//TODO this
	public List<Chamado> listarPorFila(Long idFila) {
		List<Chamado> lista = dao.listarPorFila(idFila);
		sla(lista);
		return lista;
	}

	public void atualizar(Chamado chamado) {
		dao.atualizar(chamado);
	}

	/**
	 * @author Hygor S.
	 * @param lista
	 *            lista de chamados para contabilizar o sla
	 */
	private void sla(List<Chamado> lista) {
		for (int i = 0; i < lista.size(); i++) {
			Chamado chamado = lista.get(i);
			sla(chamado);
		}
	}

	/**
	 * @author Hygor S.
	 * 
	 * @param chamado
	 */
	private void sla(Chamado chamado) {
		Calendar hoje = Calendar.getInstance();

		SlaUtil util = SlaUtilFactory.create(chamado.getFila().getSla());
		util.contabilizarSla(chamado, hoje);
	}

	public void cancelarChamado(Chamado chamado) {
		chamado.setStatus(StatusChamado.CANCELADO);
		dao.cancelarChamado(chamado);
	}

	public void avaliar(Chamado chamado) {
		if( chamado.getStatus().equals(StatusChamado.FECHADO) ){
			
			Chamado c = consultar(chamado.getId());
			c.setDataDeFechamento(Calendar.getInstance());
			c.setStatus(StatusChamado.FECHADO);
			c.setSolucionador(chamado.getSolucionador());
		}else{
			dao.avaliar(chamado);
		}
	}
	
	public List<Chamado> pesquisarChamadosSolicitante(String pesquisar, Long id){
		return dao.pesquisarChamadosSolicitante(pesquisar, id);
	}
}
