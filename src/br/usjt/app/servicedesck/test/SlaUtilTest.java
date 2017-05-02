package br.usjt.app.servicedesck.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.app.servicedesck.model.Chamado;
import br.usjt.app.servicedesck.model.Fila;
import br.usjt.app.servicedesck.model.SLA;
import br.usjt.app.servicedesck.model.StatusChamado;
import br.usjt.app.servicedesck.util.SlaUtil;
import br.usjt.app.servicedesck.util.SlaUtilFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SlaUtilTest {
	Chamado chamado;
	Calendar dataChamado;
	Calendar hoje;

	@Before
	public void setUp() throws Exception {

		dataChamado = Calendar.getInstance();
		dataChamado.set(Calendar.DAY_OF_MONTH, 3);
		dataChamado.set(Calendar.MONTH, Calendar.APRIL);
		dataChamado.set(Calendar.HOUR_OF_DAY, 7);
		
		hoje = Calendar.getInstance();

		hoje.set(Calendar.DAY_OF_MONTH, 4);
		hoje.set(Calendar.MONTH, Calendar.APRIL);
		hoje.set(Calendar.HOUR_OF_DAY, 8);
		
		
		SLA sla = new SLA();
		sla.setNivel(5);
		sla.setTempoDeAtendimento(24);

		Fila fila = new Fila();
		fila.setSla(sla);

		chamado = new Chamado();
		chamado.setDataDeAbertura(dataChamado);
		chamado.setFila(fila);
		chamado.setStatus(StatusChamado.ABERTO);
	}

	// @After
	// public void tearDown() throws Exception {
	// }

	@Test(timeout=60000L)
	public void test00ContabilizarSlaDeNivelBaixo() {
		String msg = "chamado com sla contabilizado com sucesso sem estourar sla";
		
		SlaUtil util = SlaUtilFactory.create(chamado.getFila().getSla());
		assertEquals(msg,StatusChamado.ABERTO,util.contabilizarSla(chamado, hoje));
	}

	@Test(timeout=60000L)
	public void test00ContabilizarSlaDeNivelCritico() {
		String msg = "chamado com sla contabilizado com sucesso sem estourar sla";
		
		hoje.set(Calendar.DAY_OF_MONTH, 3);
		hoje.set(Calendar.HOUR_OF_DAY, 8);
		
		
		SLA sla = new SLA();
		sla.setNivel(0);
		sla.setTempoDeAtendimento(2);
		
		chamado.getFila().setSla(sla);
		
		SlaUtil util = SlaUtilFactory.create(chamado.getFila().getSla());
		assertEquals(msg,StatusChamado.ABERTO,util.contabilizarSla(chamado, hoje));
	}
	
	@Test(timeout=60000L)
	public void test01ContabilizarSla() {
		String msg = "chamado com sla contabilizado com sucesso estourando sla";
		
		SLA sla = new SLA();
		sla.setNivel(0);
		sla.setTempoDeAtendimento(2);
		
		chamado.getFila().setSla(sla);
		
		SlaUtil util = SlaUtilFactory.create(chamado.getFila().getSla());
		assertEquals(msg,StatusChamado.ESTOROU_SLA,util.contabilizarSla(chamado, hoje));
	}
	
	@Test(timeout=60000L)
	public void test02ContabilizarSla() {
		String msg = "chamado com sla contabilizado com sucesso estourando sla";
		
		hoje.set(Calendar.DAY_OF_MONTH, 6);
		
		SLA sla = new SLA();
		sla.setNivel(5);
		sla.setTempoDeAtendimento(24);
		
		chamado.getFila().setSla(sla);
		
		

		SlaUtil util = SlaUtilFactory.create(chamado.getFila().getSla());
		assertEquals(msg,StatusChamado.ESTOROU_SLA,util.contabilizarSla(chamado, hoje));
	}
	
	@Test(expected = RuntimeException.class)
	public void test03ContabilizarSlaComNivelInvalido() {
		int nivel = 7;
		chamado.getFila().getSla().setNivel(nivel);
		
		SlaUtil util = SlaUtilFactory.create(chamado.getFila().getSla());
		assertEquals("chamado nivel da sla nao existente",StatusChamado.ABERTO,util.contabilizarSla(chamado, hoje));
	}
	
	@Ignore
	@Test(timeout=60000L)
	public void test100TestarPerformance(){
		hoje.set(Calendar.MONTH, Calendar.DECEMBER);
		//hoje.set(Calendar.DAY_OF_MONTH, 30);
		
		for(int i = 1; i <= 10;i++){
			SlaUtil util = SlaUtilFactory.create(chamado.getFila().getSla());
			assertEquals(StatusChamado.ESTOROU_SLA, util.contabilizarSla(chamado, hoje));
		}
	}

}
