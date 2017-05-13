package br.usjt.app.servicedesck.test;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.usjt.app.servicedesck.model.Usuario;
import br.usjt.app.servicedesck.service.UsuarioService;


//@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="test-config.xml")
@WebAppConfiguration
@Transactional
//@TransactionConfiguration(defaultRollback = false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	private Usuario usuario, copia;
	
	static Long id = new Long(1L);
	
	@Before
	public void setUp() throws Exception {
		//
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setCargo("Cargo");
		usuario.setCpf("22244");
		usuario.setNome("Hygor");
		
		usuario.setUsername("usuario_para_Test@t");
		usuario.setTipo(0);
		usuario.setPassword("123");
		
		//
		copia = new Usuario();
		copia.setId(id);
		copia.setCargo("Cargo");
		copia.setCpf("22244");
		copia.setNome("Hygor");
		
		copia.setUsername("usuario_para_Test@t");
		copia.setTipo(0);
		copia.setPassword("123");
	}

//	@After
//	public void tearDown() throws Exception {
//	}
	
	@Ignore
	@Test
	public void test00Criar() {
		service.criar(usuario);
		id = usuario.getId();
		copia = service.consultar(id);
		
		System.out.println("Usuario "+usuario.toString());
		System.out.println("Copia "+copia.toString());
		
		
		assertEquals("Teste criar usuario",usuario,copia);
	}
	
	@Ignore
	@Test
	public void test01Atualizar() {
		usuario.setCargo("Supervisor");
		copia.setCargo("Supervisor");
		
		System.out.println("Usuario "+usuario.toString());
		System.out.println("Copia "+copia.toString());
		
		service.atualizar(usuario);
		assertEquals("Teste atualizar usuario",usuario,copia);
		
	}

}
