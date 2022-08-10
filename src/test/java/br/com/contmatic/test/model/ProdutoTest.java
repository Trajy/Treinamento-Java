package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.CriacaoObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.EMPRESA_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.ProdutoFabricaObjetos.*;
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
public class ProdutoTest {

	@BeforeClass
	public static void pre_test(){
		construirObjetos();
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_nome_produto_nulo() {
		PRODUTO_TODOS_ATRIBUTOS.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_nome_produto_vazio() {
		PRODUTO_TODOS_ATRIBUTOS.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_nome_produto_acima_max_chars() {
		PRODUTO_TODOS_ATRIBUTOS.setNome(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_nome_produto_abaixo_min_chars() {
		PRODUTO_TODOS_ATRIBUTOS.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_nome_produto_nao_alfanumerico() {
		PRODUTO_TODOS_ATRIBUTOS.setNome(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_06_versao_produto_nula() {
		PRODUTO_TODOS_ATRIBUTOS.setVersao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_versao_produto_vazia() {
		PRODUTO_TODOS_ATRIBUTOS.setVersao(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_versao_produto_com_letra() {
		PRODUTO_TODOS_ATRIBUTOS.setVersao(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_1_versao_produto_maior_que_max_chars() {
		PRODUTO_TODOS_ATRIBUTOS.setVersao(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_2_versao_produto_menor_min_chars() {
		PRODUTO_TODOS_ATRIBUTOS.setVersao(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_09_codigo_produto_nula() {
		PRODUTO_TODOS_ATRIBUTOS.setCodigo(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_codigo_produto_vazia() {
		PRODUTO_TODOS_ATRIBUTOS.setCodigo(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_codigo_produto_com_letra() {
		PRODUTO_TODOS_ATRIBUTOS.setCodigo(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_1_codigo_produto_acima_max_chars() {
		PRODUTO_TODOS_ATRIBUTOS.setCodigo(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_2_codigo_produto_abaixo_min_chars() {
		PRODUTO_TODOS_ATRIBUTOS.setCodigo(TEXTO_COM_1_CHAR);
	}
	
	@Test
	public void test_12_metodo_hashcode() {
		assertEquals(PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).hashCode(), PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).hashCode());
	}
	
	@Test
	public void test_13_metodo_equals() {
		assertTrue(PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).equals(PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01)));
		assertTrue(PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).equals(PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_02)));
		assertFalse(PRODUTO_TODOS_ATRIBUTOS.equals(new Object()));
		assertFalse(PRODUTO_TODOS_ATRIBUTOS.equals(null));
		assertFalse(PRODUTO_TODOS_ATRIBUTOS.equals(PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01)));
	}
	
	@Test
	public void test_14_metodo_tostring() {
		assertThat(
			PRODUTO_TODOS_ATRIBUTOS.toString(), 
			allOf(
				containsString(PRODUTO_TODOS_ATRIBUTOS.getNome()),
				containsString(PRODUTO_TODOS_ATRIBUTOS.getCodigo()),
				containsString(PRODUTO_TODOS_ATRIBUTOS.getVersao())
			)
		);
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void test_31_validar_empresa_nulo() {
        PRODUTO_01.setEmpresa(null);
    }
	
	@Test(expected = IllegalStateException.class)
	public void test_32_validar_preco_abaixo_limite() {
	    PRODUTO_TODOS_ATRIBUTOS.setPreco(PRECO_ABAIXO_MIN);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_33_validar_preco_acima_limite() {
	    PRODUTO_TODOS_ATRIBUTOS.setPreco(PRECO_ABAIXO_MIN);
	}
}
