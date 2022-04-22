package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.UnidadeFederativaFabricaObjetos.*;
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
public class CidadeTest {
	
	@BeforeClass
	public static void pre_teste() {
		construirObjetos();
	}
	
	@Test
	public void test_01_instancia() {
		assertEquals(NOME_CIDADE, CIDADE.getNome());
		assertEquals(UF_01, CIDADE.getUf());
		assertEquals(PAIS, CIDADE.getPais());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_02_CIDADE_nome_nulo() {
		CIDADE.setNome(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_nome_CIDADE_vazio() {
		CIDADE.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_nome_CIDADE_com_numero() {
		CIDADE.setNome(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_nome_CIDADE_abaixo_min_chars() {
		CIDADE.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_nome_CIDADE_acima_max_chars() {
		CIDADE.setNome(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_07_uf_nulo() {
		CIDADE.setUf(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_12_pais_nulo() {
		CIDADE.setPais(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_13_pais_vazio() {
		CIDADE.setPais(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_14_pais_com_numero() {
		CIDADE.setPais(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_pais_abaixo_min_chars() {
		CIDADE.setPais(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_16_pais_acima_max_chars() {
		CIDADE.setPais(TEXTO_COM_1_CHAR);
	}
	
	@Test
	public void test_17_metodo_hashcode() {
		assertEquals(CIDADE.hashCode(), OUTRA_CIDADE.hashCode());
	}
	
	@Test
	public void test_18_validar_metodo_equals() {
		assertTrue(CIDADE.equals(CIDADE));
		assertTrue(CIDADE.equals(OUTRA_CIDADE));
		assertFalse(CIDADE.equals(new Object()));
		assertFalse(CIDADE.equals(null));
		
		OUTRA_CIDADE.setNome(NOME_CIDADE_02);
		assertFalse(CIDADE.equals(OUTRA_CIDADE));
		
		OUTRA_CIDADE.setUf(UF_02);
		assertFalse(CIDADE.equals(OUTRA_CIDADE));
		
		OUTRA_CIDADE.setPais(NOME_CIDADE_02);
		assertFalse(CIDADE.equals(OUTRA_CIDADE));
		
		OUTRA_CIDADE.setUf(UF_01);
		assertFalse(CIDADE.equals(OUTRA_CIDADE));
		
		OUTRA_CIDADE.setNome(NOME_CIDADE);
		assertFalse(CIDADE.equals(OUTRA_CIDADE));
		
		OUTRA_CIDADE.setUf(UF_02);
		OUTRA_CIDADE.setPais(PAIS);
		assertFalse(CIDADE.equals(OUTRA_CIDADE));	
	}
	
	@Test
	public void test_19_metodo_tostring() {
		assertThat(
			CIDADE.toString(), 
			allOf(
				containsString(NOME_CIDADE),
				containsString(UF_01.toString()),
				containsString(PAIS)
			)
		);
	}
	
	@Test
	public void test_20_metodos_get_unidade_federativa() {
	    assertEquals(CODIGO_01, CIDADE.getUf().getCodigo());
	    assertEquals(NOME_UF_01, CIDADE.getUf().getNome());
	    assertEquals(SIGLA_UF_01, CIDADE.getUf().getSigla());
	}
	
    @Test
    public void test_21_metodo_equals_unidade_federativa() {
        assertFalse(CIDADE.getUf().equals(null));
        assertFalse(CIDADE.getUf().equals(new Object()));
    }
}
