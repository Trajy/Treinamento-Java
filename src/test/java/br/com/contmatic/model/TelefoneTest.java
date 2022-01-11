package br.com.contmatic.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.print.attribute.standard.DateTimeAtProcessing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Telefone;

import static br.com.contmatic.model.ConstantsTest.*;

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
	
	//TODO implementar testes para equals, hashcode e toString
	
	
	
	
	

}
