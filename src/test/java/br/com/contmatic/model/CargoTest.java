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
	
	@Test(expected = IllegalArgumentException.class)
	public void test_08_nome_nulo() {
		cargoTodosAtributos.setNome(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_nome_vazio() {
		cargoTodosAtributos.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_nome_acima_max_chars() {
		cargoTodosAtributos.setNome(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_nome_abaixo_min_chars() {
		cargoAtriburtosObrigatorios.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_nome_nao_alfanumerico() {
		cargoAtriburtosObrigatorios.setNome(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_13_descricao_nula() {
		cargoAtriburtosObrigatorios.setDescricao(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_14_descricao_vazio() {
		cargoTodosAtributos.setDescricao(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_descricao_acima_max_chars() {
		cargoTodosAtributos.setDescricao(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_16_descricao_abaixo_min_chars() {
		cargoAtriburtosObrigatorios.setDescricao(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_descricao_nao_alfanumerico() {
		cargoAtriburtosObrigatorios.setDescricao(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	//TODO to implement toString, equals and hashCode tests	
		
}
