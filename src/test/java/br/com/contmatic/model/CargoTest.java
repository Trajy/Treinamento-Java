package br.com.contmatic.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static br.com.contmatic.model.ConstantsTest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CargoTest {
	
	// objetos de teste
	private Cargo cargoAtriburtosObrigatorios;
	private Cargo cargoTodosAtributos;
	
	@Before
	public void pre_test() {
		cargoAtriburtosObrigatorios = new Cargo(CBO_01);
		cargoTodosAtributos = new Cargo(CBO_02, NOME_CARGO_02, DESCRICAO_CARGO_02);
	}
	
	@Test
	public void test_01_instacia_com_construtor_obrigatorio() {
		assertEquals(CBO_01, cargoAtriburtosObrigatorios.getCBO());
	}
	
	@Test
	public void test_02_instancia_com_construtor_todos_os_artributos() {
		assertEquals(CBO_02, cargoTodosAtributos.getCBO());
		assertEquals(NOME_CARGO_02, cargoTodosAtributos.getNome());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_cbo_nulo() {
		cargoAtriburtosObrigatorios.setCBO(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_cbo_vazio() {
		cargoTodosAtributos.setCBO(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_cbo_somente_espacos() {
		cargoAtriburtosObrigatorios.setCBO(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_cbo_com_letras() {
		cargoTodosAtributos.setCBO(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_cbo_maior_que_permitido() {
		cargoTodosAtributos.setCBO(LITERAL_NUMERICO_COM_10_CHARS);
	}	
	
}
