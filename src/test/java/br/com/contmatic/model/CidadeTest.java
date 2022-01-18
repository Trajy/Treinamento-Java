package br.com.contmatic.model;

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
import br.com.contmatic.model.endereco.Cidade;

import static br.com.contmatic.model.ConstantsTest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CidadeTest {

	// objetos de test
	private Cidade cidade;
	private Cidade outraCidade;
	
	@Before
	public void pre_test() {
		cidade = new Cidade(NOME_CIDADE, UF, PAIS);
		outraCidade = new Cidade(NOME_CIDADE, UF, PAIS);
	}
	
	@Test
	public void test_01_instancia() {
		assertEquals(NOME_CIDADE, cidade.getNome());
		assertEquals(UF, cidade.getUf());
		assertEquals(PAIS, cidade.getPais());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_02_cidade_nome_nulo() {
		cidade.setNome(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_nome_cidade_vazio() {
		cidade.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_nome_cidade_com_numero() {
		cidade.setNome(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_nome_cidade_abaixo_min_chars() {
		cidade.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_nome_cidade_acima_max_chars() {
		cidade.setNome(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_07_uf_nulo() {
		cidade.setUf(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_uf_vazio() {
		cidade.setUf(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_nome_cidade_com_numero() {
		cidade.setUf(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_uf_abaixo_min_chars() {
		cidade.setUf(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_Uf_acima_max_chars() {
		cidade.setUf(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_12_pais_nulo() {
		cidade.setPais(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_13_pais_vazio() {
		cidade.setPais(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_14_pais_com_numero() {
		cidade.setPais(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_pais_abaixo_min_chars() {
		cidade.setPais(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_16_pais_acima_max_chars() {
		cidade.setPais(TEXTO_COM_1_CHAR);
	}
	
	@Test
	public void test_17_metodo_hashcode() {
		assertEquals(cidade.hashCode(), outraCidade.hashCode());
	}
	
	@Test
	public void test_18_validar_metodo_equals() {
		assertTrue(cidade.equals(cidade));
		assertTrue(cidade.equals(outraCidade));
		assertFalse(cidade.equals(ENDERECO_01));
		assertFalse(cidade.equals(null));
		
		outraCidade.setNome(NOME_CIDADE_02);
		assertFalse(cidade.equals(outraCidade));
		outraCidade.setUf(UF_02);
		assertFalse(cidade.equals(outraCidade));
		outraCidade.setPais(NOME_CIDADE_02);
		assertFalse(cidade.equals(outraCidade));
		
		outraCidade.setUf(UF);
		assertFalse(cidade.equals(outraCidade));
		outraCidade.setNome(NOME_CIDADE);
		assertFalse(cidade.equals(outraCidade));
		outraCidade.setUf(UF_02);
		outraCidade.setPais(PAIS);
		assertFalse(cidade.equals(outraCidade));	
	}
	
	@Test
	public void test_19_metodo_tostring() {
		assertThat(
			cidade.toString(), 
			allOf(
				containsString(NOME_CIDADE),
				containsString(UF),
				containsString(PAIS)
			)
		);
	}
}
