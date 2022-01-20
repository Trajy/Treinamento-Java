package br.com.contmatic.test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static br.com.contmatic.test.model.ConstantsTest.*;
import br.com.contmatic.model.contato.Telefone;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelefoneTest {
	
	// objetos de teste
	private Telefone telefoneAtributosObrigatorios;
	private Telefone telefoneTodosAtributos;
	
	@Before
	public void pre_test() {
		telefoneAtributosObrigatorios = new Telefone(DDD_01, NUMERO_TELEFONE_01);
		telefoneTodosAtributos = new Telefone(DDI_01, DDD_01, NUMERO_TELEFONE_01);
	}
	
	@Test
	public void test_00_instancia() {
		assertEquals(DDI_01, telefoneTodosAtributos.getDdi());
		assertEquals(DDD_01, telefoneTodosAtributos.getDdd());
		assertEquals(NUMERO_TELEFONE_01, telefoneTodosAtributos.getNumero());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_ddi_nulo() {
		telefoneTodosAtributos.setDdi(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_ddi_acima_max_chars() {
		telefoneTodosAtributos.setDdi(DDI_ACIMA_MAX_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_ddd_nulo() {
		telefoneTodosAtributos.setDdd(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_ddd_abaixo_min_chars() {
		telefoneTodosAtributos.setDdd(DDD_ABAIXO_MIN_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_ddd_acima_max_chars() {
		telefoneTodosAtributos.setDdd(DDD_ACIMA_MAX_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_06_numero_nulo() {
		telefoneTodosAtributos.setNumero(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_numero_abaixo_min_chars() {
		telefoneTodosAtributos.setNumero(NUMERO_TELEFONE_ABAIXO_MIN_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_numero_acima_max_chars() {
		telefoneTodosAtributos.setNumero(NUMERO_TELEFONE_ACIMA_MAX_CHARS);
	}
	
	@Test
	public void test_09_metodo_hashcode() {
		assertEquals(telefoneTodosAtributos.hashCode(), telefoneAtributosObrigatorios.hashCode());
	}
	
	@Test
	public void test_10_metodo_equals() {
		assertTrue(telefoneTodosAtributos.equals(telefoneTodosAtributos));
		assertTrue(telefoneTodosAtributos.equals(telefoneAtributosObrigatorios));
		assertFalse(telefoneTodosAtributos.equals(new Object()));
		assertFalse(telefoneTodosAtributos.equals(null));
		
		telefoneAtributosObrigatorios.setDdd(DDD_02);
		assertFalse(telefoneTodosAtributos.equals(telefoneAtributosObrigatorios));
		
		telefoneAtributosObrigatorios.setNumero(NUMERO_TELEFONE_02);
		assertFalse(telefoneTodosAtributos.equals(telefoneAtributosObrigatorios));
	}
	
	@Test
	public void test_11_metodo_tostring() {
		assertThat(
			telefoneTodosAtributos.toString(), 
			allOf(
				containsString(DDI_01.toString()),
				containsString(DDD_01.toString()),
				containsString(NUMERO_TELEFONE_01)
			)
		);
	}
}
