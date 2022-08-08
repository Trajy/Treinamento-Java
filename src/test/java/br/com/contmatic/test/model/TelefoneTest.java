package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.TelefoneFabricaObjetos.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class TelefoneTest {
	
	@BeforeClass
	public static void pre_teste() {
		construirObjetos();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_ddi_nulo() {
		TELEFONE_TODOS_ATRIBUTOS.setDdi(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_ddi_acima_max_chars() {
		TELEFONE_TODOS_ATRIBUTOS.setDdi(DDI_ACIMA_MAX_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_ddd_nulo() {
		TELEFONE_TODOS_ATRIBUTOS.setDdd(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_ddd_abaixo_min_chars() {
		TELEFONE_TODOS_ATRIBUTOS.setDdd(DDD_ABAIXO_MIN_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_ddd_acima_max_chars() {
		TELEFONE_TODOS_ATRIBUTOS.setDdd(DDD_ACIMA_MAX_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_06_numero_nulo() {
		TELEFONE_TODOS_ATRIBUTOS.setNumero(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_numero_abaixo_min_chars() {
		TELEFONE_TODOS_ATRIBUTOS.setNumero(NUMERO_TELEFONE_ABAIXO_MIN_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_numero_acima_max_chars() {
		TELEFONE_TODOS_ATRIBUTOS.setNumero(NUMERO_TELEFONE_ACIMA_MAX_CHARS);
	}
	
	@Test
	public void test_09_metodo_hashcode() {
		assertEquals(TELEFONE_TODOS_ATRIBUTOS.hashCode(), TELEFONE_ATRIBUTOS_OBRIGATORIOS.hashCode());
	}
	
	@Test
	public void test_10_metodo_equals() {
		assertTrue(TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_01).equals(TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_01)));
		assertTrue(TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_01).equals(TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_02)));
		assertFalse(TELEFONE_TODOS_ATRIBUTOS.equals(new Object()));
		assertFalse(TELEFONE_TODOS_ATRIBUTOS.equals(null));	
		assertFalse(TELEFONE_TODOS_ATRIBUTOS.equals(TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_01)));
	}
	
	@Test
	public void test_11_metodo_tostring() {
		assertThat(
			TELEFONE_TODOS_ATRIBUTOS.toString(), 
			allOf(
				containsString(TELEFONE_TODOS_ATRIBUTOS.getDdi().toString()),
				containsString(TELEFONE_TODOS_ATRIBUTOS.getDdd().toString()),
				containsString(TELEFONE_TODOS_ATRIBUTOS.getNumero())
			)
		);
	}
}
