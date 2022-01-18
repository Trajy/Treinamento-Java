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

import br.com.contmatic.model.endereco.Endereco;

import static br.com.contmatic.model.ConstantsTest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnderecoTest {
	
	// objetos de teste
	private Endereco enderecoAtributosObrigatorios;
	private Endereco enderecoTodosOsAtributos;
	private Endereco outroEnderecoTodosOsAtributos;
	
	@Before
	public void pre_test(){
		enderecoAtributosObrigatorios = new Endereco(NUMERO_ENDERECO_01, CEP_01);
		enderecoTodosOsAtributos = new Endereco(NUMERO_ENDERECO_01, CEP_01, RUA_01, BAIRRO_01, CIDADE);
		outroEnderecoTodosOsAtributos = new Endereco(NUMERO_ENDERECO_01, CEP_01, RUA_01, BAIRRO_01, CIDADE);
	}
	
	@Test
	public void test_01_instancia_atributos_obrigatorios() {
		assertEquals(NUMERO_ENDERECO_01, enderecoAtributosObrigatorios.getNumero());
		assertEquals(CEP_01, enderecoAtributosObrigatorios.getCEP());
	}
	
	@Test
	public void test_02_instancia_todos_atributos() {
		assertEquals(NUMERO_ENDERECO_01, enderecoTodosOsAtributos.getNumero());
		assertEquals(CEP_01, enderecoTodosOsAtributos.getCEP());
		assertEquals(RUA_01, enderecoTodosOsAtributos.getRua());
		assertEquals(BAIRRO_01, enderecoTodosOsAtributos.getBairro());
		assertEquals(CIDADE, enderecoTodosOsAtributos.getCidade());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_numero_nulo() {
		enderecoTodosOsAtributos.setNumero(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_numero_acima_max_chars() {
		enderecoTodosOsAtributos.setNumero(ENDERECO_NUM_ACIMA_TAMANHO_MAX);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_05_cep_nulo() {
		enderecoTodosOsAtributos.setCEP(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_cep_vazio() {
		enderecoTodosOsAtributos.setCEP(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_cep_tamanho_errado() {
		enderecoTodosOsAtributos.setCEP(CEP_TAMANHO_ERRADO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_cep_com_letra() {
		enderecoTodosOsAtributos.setCEP(CEP_COM_LETRA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_cep_com_chars_repstidos() {
		enderecoTodosOsAtributos.setCEP(CEP_CHARS_REPETIDOS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_10_rua_nula() {
		enderecoTodosOsAtributos.setRua(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_rua_vazia() {
		enderecoTodosOsAtributos.setRua(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_rua_com_char_nao_alfanumerico() {
		enderecoTodosOsAtributos.setRua(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_13_rua_abaixo_min_chars() {
		enderecoTodosOsAtributos.setRua(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_14_rua_acima_max_chars() {
		enderecoTodosOsAtributos.setRua(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_15_bairro_nulo() {
		enderecoTodosOsAtributos.setBairro(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_16_bairro_vazio() {
		enderecoTodosOsAtributos.setBairro(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_bairro_com_chars_nao_alfanumerico() {
		enderecoTodosOsAtributos.setBairro(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_18_barrio_abaixo_min_chars() {
		enderecoTodosOsAtributos.setBairro(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_19_bairro_acima_max_chars() {
		enderecoTodosOsAtributos.setBairro(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_20_cidade_nula() {
		enderecoTodosOsAtributos.setCidade(null);
	}
	
	@Test
	public void test_21_metodo_hashcode() {
		assertEquals(enderecoTodosOsAtributos.hashCode(), enderecoAtributosObrigatorios.hashCode());
	}
	
	@Test
	public void test_22_metodo_equals() {
		assertTrue(enderecoTodosOsAtributos.equals(enderecoTodosOsAtributos));
		assertTrue(enderecoAtributosObrigatorios.equals(enderecoTodosOsAtributos));
		assertFalse(enderecoAtributosObrigatorios.equals(null));
		assertFalse(enderecoTodosOsAtributos.equals(FUNCIONARIO_01));
		
		enderecoAtributosObrigatorios.setNumero(NUMERO_ENDERECO_02);
		assertFalse(enderecoAtributosObrigatorios.equals(enderecoTodosOsAtributos));
		enderecoAtributosObrigatorios.setCEP(CEP_02);
		assertFalse(enderecoAtributosObrigatorios.equals(enderecoTodosOsAtributos));	
	}
	
	@Test
	public void test_23_metodo_tostring() {
		assertThat(
			enderecoTodosOsAtributos.toString(), 
			allOf(
				containsString(NUMERO_ENDERECO_01.toString()),
				containsString(CEP_01),
				containsString(RUA_01),
				containsString(BAIRRO_01),
				containsString(CIDADE.toString())
			)
		);
	}
}
