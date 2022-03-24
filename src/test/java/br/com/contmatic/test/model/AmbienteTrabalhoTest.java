package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.FabricaObjetos.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmbienteTrabalhoTest {
	
	@BeforeClass
	public static void pre_teste() {
	    construirObjetos();
	}
	
	@Test
	public void test_02_validar_objeto_com_construtor_completo_da_classe_ambiente_de_trabalho() {
		assertEquals(NOME_AMBINETE_TRAB_01, AMBIENTE_TRAB_01.getNome());
		assertEquals(TIPO_AMBIENTE_TRAB_PROPRIO, AMBIENTE_TRAB_01.getTipoEstabelecimento());
		assertEquals(ENDERECO_01, AMBIENTE_TRAB_01.getEndereco());
		assertEquals(NOME_RESPONSAVEL_AMBIENTE, AMBIENTE_TRAB_01.getResponsavel());
		assertEquals(DESC_AMBIENTE, AMBIENTE_TRAB_01.getDescricao());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_validar_nome_nulo() {
		AMBIENTE_TRAB_01.setNome(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_validar_nome_vazio() {
		AMBIENTE_TRAB_01.setNome(VAZIO);
	}
	
	public void test_05_validar_nome_somente_com_espacos() {
		AMBIENTE_TRAB_01.setNome(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_validar_nome_com_char_nao_alfanumerico() {
		AMBIENTE_TRAB_01.setNome(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_validar_nome_com_maximo_de_chars_nome() {
		AMBIENTE_TRAB_01.setNome(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_08_validar_tipo_de_estabelecimento_nulo() {
		AMBIENTE_TRAB_01.setTipoEstabelecimento(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_validar_tipo_de_estabelecimento_vazio() {
		AMBIENTE_TRAB_01.setTipoEstabelecimento(VAZIO);
	}
	
	public void test_10_validar_tipo_de_estabelecimento_somente_com_espacos() {
		AMBIENTE_TRAB_01.setTipoEstabelecimento(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_validar_tipo_de_estabelecimento_com_char_nao_alfanumerico() {
		AMBIENTE_TRAB_01.setTipoEstabelecimento(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_validar_tipo_de_estabelecimento_com_maximo_de_chars_nome() {
		AMBIENTE_TRAB_01.setTipoEstabelecimento(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_13_validar_endereco_nulo() {
		AMBIENTE_TRAB_01.setEndereco(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_14_validar_responsavel_nulo() {
		AMBIENTE_TRAB_01.setResponsavel(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_validar_responsal_vazio() {
		AMBIENTE_TRAB_01.setResponsavel(VAZIO);
	}
	
	public void test_16_validar_responvel_somente_com_espacos() {
		AMBIENTE_TRAB_01.setResponsavel(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_validar_responsavel_com_char_nao_alfanumerico() {
		AMBIENTE_TRAB_01.setResponsavel(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	@Test(expected = IllegalStateException.class)
	public void test_18_validar_responsavel_com_char_nao_alfanumerico() {
		AMBIENTE_TRAB_01.setResponsavel(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_19_validar_responsavel_com_numeros() {
		AMBIENTE_TRAB_01.setResponsavel(TEXTO_COM_CHAR_NUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_20_validar_responsavel_tamanho_maximo() {
		AMBIENTE_TRAB_01.setResponsavel(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_21_validar_responsavel_de_tamanho_minimo() {
		AMBIENTE_TRAB_01.setResponsavel(TEXTO_COM_1_CHAR);
	}
	
	@Test
	public void test_22_validar_metodo_hashcode_da_classe_ambiente() {
		assertThat(AMBIENTE_TRAB_03.hashCode(), equalTo(AMBIENTE_TRAB_01.hashCode()));
	}

	@Test
	public void test_23_validar_metodo_equals_ambiente_com_ambiente() {
		assertTrue(AMBIENTE_TRAB_03.equals(AMBIENTE_TRAB_01));
	}
	
	@Test
	public void test_24_validar_metodo_equals_de_ambiente_com_objeto_de_outra_classe() {
		assertFalse(AMBIENTE_TRAB_01.equals(new Object()));
	}
	
	@Test
	public void test_25_validar_metodo_equals_de_ambiente_com_nulo() {
		assertFalse(AMBIENTE_TRAB_02.equals(null));	
	}
	
	@Test
	public void test_26_validar_metodo_equals_de_ambiente_com_outro_objeto_da_mesma_classe() {
		assertTrue(AMBIENTE_TRAB_01.equals(AMBIENTE_TRAB_01));
	}
	
	@Test
	public void test_27_validar_() {
		AMBIENTE_TRAB_02.setNome(NOME_02);
		assertFalse(AMBIENTE_TRAB_02.equals(AMBIENTE_TRAB_01));
	}
	
	@Test
	public void test_28_validar_() {
		AMBIENTE_TRAB_02.setResponsavel(NOME_02);
		assertFalse(AMBIENTE_TRAB_02.equals(AMBIENTE_TRAB_01));
	}
	
	@Test
	public void test_29_validar_() {
		AMBIENTE_TRAB_02.setNome(NOME_AMBIENTE_TRAB_03);
		assertFalse(AMBIENTE_TRAB_02.equals(AMBIENTE_TRAB_01));
	}
	
	@Test
	public void test_30_validar_metodo_to_string_da_classe_ambiente() {
		assertThat(
			AMBIENTE_TRAB_01.toString(), 
			allOf(
				containsString(NOME_RESPONSAVEL_AMBIENTE),
				containsString(TIPO_AMBIENTE_TRAB_PROPRIO),
				containsString(ENDERECO_01.toString()),
				containsString(NOME_RESPONSAVEL_AMBIENTE),
				containsString(DESC_AMBIENTE)
			)
		);
	}
}
