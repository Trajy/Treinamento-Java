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

import br.com.contmatic.model.empresa.Produto;

import static br.com.contmatic.test.model.ConstantsTest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest {
	
	// objetos de teste
	private Produto produtoAtributosObrigatorios;
	private Produto outroProdutoAtributosObrigatorios;
	private Produto produtoTodosAtributos;
	
	@Before
	public void pre_test(){
		produtoAtributosObrigatorios = new Produto(CODIGO_01);
		outroProdutoAtributosObrigatorios = new Produto(CODIGO_02);
		produtoTodosAtributos = new Produto(NOME_PRODUTO_01, VERSAO_01, CODIGO_01);
	}
	
	@Test
	public void test_00_instancias() {
		assertEquals(NOME_PRODUTO_01, produtoTodosAtributos.getNome());
		assertEquals(VERSAO_01, produtoTodosAtributos.getVersao());
		assertEquals(CODIGO_01, produtoTodosAtributos.getCodigo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_nome_produto_nulo() {
		produtoTodosAtributos.setNome(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_nome_produto_vazio() {
		produtoTodosAtributos.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_nome_produto_acima_max_chars() {
		produtoTodosAtributos.setNome(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_nome_produto_abaixo_min_chars() {
		produtoTodosAtributos.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_nome_produto_nao_alfanumerico() {
		produtoTodosAtributos.setNome(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_06_versao_produto_nula() {
		produtoAtributosObrigatorios.setVersao(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_versao_produto_vazia() {
		produtoTodosAtributos.setVersao(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_versao_produto_com_letra() {
		produtoTodosAtributos.setVersao(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_1_versao_produto_maior_que_max_chars() {
		produtoTodosAtributos.setVersao(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_2_versao_produto_menor_min_chars() {
		produtoTodosAtributos.setVersao(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_09_codigo_produto_nula() {
		produtoAtributosObrigatorios.setCodigo(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_codigo_produto_vazia() {
		produtoTodosAtributos.setCodigo(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_codigo_produto_com_letra() {
		produtoTodosAtributos.setCodigo(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_1_codigo_produto_acima_max_chars() {
		produtoTodosAtributos.setCodigo(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_2_codigo_produto_abaixo_min_chars() {
		produtoTodosAtributos.setCodigo(TEXTO_COM_1_CHAR);
	}
	
	@Test
	public void test_12_metodo_hashcode() {
		assertEquals(produtoAtributosObrigatorios.hashCode(), produtoTodosAtributos.hashCode());
	}
	
	@Test
	public void test_13_metodo_equals() {
		assertTrue(produtoTodosAtributos.equals(produtoTodosAtributos));
		assertTrue(produtoTodosAtributos.equals(produtoAtributosObrigatorios));
		assertFalse(produtoTodosAtributos.equals(new Object()));
		assertFalse(produtoTodosAtributos.equals(null));
		assertFalse(produtoAtributosObrigatorios.equals(outroProdutoAtributosObrigatorios));
	}
	
	@Test
	public void test_14_metodo_tostring() {
		assertThat(
			produtoTodosAtributos.toString(), 
			allOf(
				containsString(NOME_PRODUTO_01),
				containsString(CODIGO_01),
				containsString(VERSAO_01)
			)
		);
	}
}
