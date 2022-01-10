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
import static br.com.contmatic.model.ConstantsTest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest {
	
	// objetos de teste
	private Produto produtoAtributosObrigatorios;
	private Produto produtoTodosAtributos;
	
	@Before
	public void pre_test(){
		produtoAtributosObrigatorios = new Produto(NOME_PRODUTO_01);
		produtoTodosAtributos = new Produto(NOME_PRODUTO_01, VERSAO_01, CODIGO_01);
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
	
	@Test(expected = IllegalArgumentException.class)
	public void test_09_codigo_produto_nula() {
		produtoAtributosObrigatorios.setVersao(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_codigo_produto_vazia() {
		produtoTodosAtributos.setVersao(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_codigo_produto_com_letra() {
		produtoTodosAtributos.setVersao(NUMEROS_COM_LETRA_LITERAL);
	}
	
	//TODO implementar o resto
	
	

}
