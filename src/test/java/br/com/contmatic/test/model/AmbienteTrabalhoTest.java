package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.AMBIENTE_TRAB_TODOS_ARGUMENTOS;
import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_01;
import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_02;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.MAX_CHARS_GERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.SOMENTE_ESPACOS;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_1_CHAR;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_CHAR_NAO_ALFANUMERICO;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_CHAR_NUMERICO;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.VAZIO;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_01;
import static br.com.contmatic.test.model.fabricaobjetos.CriacaoObjetos.construirObjetos;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class AmbienteTrabalhoTest {
	
	@BeforeClass
	public static void pre_teste() {
	    construirObjetos();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_validar_nome_nulo() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_validar_nome_vazio() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setNome(VAZIO);
	}
	
	public void test_05_validar_nome_somente_com_espacos() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setNome(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_validar_nome_com_char_nao_alfanumerico() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setNome(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_validar_nome_com_maximo_de_chars_nome() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setNome(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_08_validar_tipo_de_estabelecimento_nulo() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setTipoEstabelecimento(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_validar_tipo_de_estabelecimento_vazio() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setTipoEstabelecimento(VAZIO);
	}
	
	public void test_10_validar_tipo_de_estabelecimento_somente_com_espacos() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setTipoEstabelecimento(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_validar_tipo_de_estabelecimento_com_char_nao_alfanumerico() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setTipoEstabelecimento(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_validar_tipo_de_estabelecimento_com_maximo_de_chars_nome() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setTipoEstabelecimento(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_13_validar_endereco_nulo() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setEndereco(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_14_validar_responsavel_nulo() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setResponsavel(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_validar_responsal_vazio() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setResponsavel(VAZIO);
	}
	
	public void test_16_validar_responvel_somente_com_espacos() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setResponsavel(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_validar_responsavel_com_char_nao_alfanumerico() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setResponsavel(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	@Test(expected = IllegalStateException.class)
	public void test_18_validar_responsavel_com_char_nao_alfanumerico() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setResponsavel(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_19_validar_responsavel_com_numeros() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setResponsavel(TEXTO_COM_CHAR_NUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_20_validar_responsavel_tamanho_maximo() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setResponsavel(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_21_validar_responsavel_de_tamanho_minimo() {
		AMBIENTE_TRAB_TODOS_ARGUMENTOS.setResponsavel(TEXTO_COM_1_CHAR);
	}
	
	@Test
	public void test_22_validar_metodo_hashcode_da_classe_ambiente() {
		assertThat(AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_01).hashCode(), 
		    equalTo(AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_02).hashCode())
	    );
	}

	@Test
	public void test_23_validar_metodo_equals_ambiente_com_ambiente() {
		assertTrue(AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS
		    .get(INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_01)
		    .equals(AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS
	            .get(INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_01)
            )
	    );
		
		assertTrue(AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS
            .get(INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_01)
            .equals(AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS
                .get(INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_02)
            )
        );
		
		assertFalse(AMBIENTE_TRAB_TODOS_ARGUMENTOS.equals(new Object()));
		assertFalse(AMBIENTE_TRAB_TODOS_ARGUMENTOS.equals(null));
	}
	
	@Test
	public void test_30_validar_metodo_to_string_da_classe_ambiente() {
		assertThat(
			AMBIENTE_TRAB_TODOS_ARGUMENTOS.toString(), 
			allOf(
				containsString(AMBIENTE_TRAB_TODOS_ARGUMENTOS.getNome()),
				containsString(AMBIENTE_TRAB_TODOS_ARGUMENTOS.getTipoEstabelecimento()),
				containsString(ENDERECO_01.toString()),
				containsString(AMBIENTE_TRAB_TODOS_ARGUMENTOS.getResponsavel()),
				containsString(AMBIENTE_TRAB_TODOS_ARGUMENTOS.getDescricao())
			)
		);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_31_validar_empresa_nulo() {
	    AMBIENTE_TRAB_TODOS_ARGUMENTOS.setEmpresa(null);
	}
}
