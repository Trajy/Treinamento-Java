package br.com.contmatic.test.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.empresa.AmbienteTrabalho;
import br.com.contmatic.model.empresa.Endereco;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmbienteTrabalhoTest {
	
	// objetos de teste
	private AmbienteTrabalho ambienteDeTrabalhoAtributosObrigatorios;
	private AmbienteTrabalho ambienteDeTrabalhoTodosOsAtributos;
	
	// constantes corretas
	private final String NOME = "Desenvolvimento";
	private final String NOME_02 = "Quality Assurance";
	private final String TIPO_DE_ESTABELECIMENTO = "Estabelicimento de terceiros";
	private final Endereco ENDERECO = new Endereco(123, "12345678");
	private final String RESPONSAVEL = "Nome hipotético";
	private final String RESPONSAVEL_02 = "Fulano de tal";
	private final String DESCRICAO = "Ambiente de desenvolvimento de software";
	
	// constantes de erro
	private final String NULO = null;
	private final String VAZIO = "";
	private final String ESPACOS = "               ";
	private final String TEXTO_COM_CHAR_NAO_ALFANUMERICO = "abcΩω";
	private final String TEXTO_COM_CHAR_NUMERICO = "123abc";
	private final String TEXTO_COM_71_CHARS = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ1234567890123456789";
	private final String TEXTO_COM_51_CHARS = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWY";
	private final String TEXTO_COM_2_CHARS = "an";
	
	@Before
	public void pre_test() {
		ambienteDeTrabalhoAtributosObrigatorios = new AmbienteTrabalho(NOME, RESPONSAVEL);
		ambienteDeTrabalhoTodosOsAtributos = new AmbienteTrabalho(NOME, TIPO_DE_ESTABELECIMENTO, ENDERECO, RESPONSAVEL, DESCRICAO);
	}
	
	@Test
	public void test_01_validar_objeto_com_construtor_obrigatorio_da_classe_ambiente_de_trabalho() {
		assertEquals(NOME, ambienteDeTrabalhoAtributosObrigatorios.getNome());
		assertEquals(RESPONSAVEL, ambienteDeTrabalhoAtributosObrigatorios.getResponsavel());
	}
	
	@Test
	public void test_02_validar_objeto_com_construtor_completo_da_classe_ambiente_de_trabalho() {
		assertEquals(NOME, ambienteDeTrabalhoTodosOsAtributos.getNome());
		assertEquals(TIPO_DE_ESTABELECIMENTO, ambienteDeTrabalhoTodosOsAtributos.getTipoEstabelecimento());
		assertEquals(ENDERECO, ambienteDeTrabalhoTodosOsAtributos.getEndereco());
		assertEquals(RESPONSAVEL, ambienteDeTrabalhoTodosOsAtributos.getResponsavel());
		assertEquals(DESCRICAO, ambienteDeTrabalhoTodosOsAtributos.getDescricao());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_validar_nome_nulo() {
		ambienteDeTrabalhoTodosOsAtributos.setNome(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_validar_nome_vazio() {
		ambienteDeTrabalhoTodosOsAtributos.setNome(VAZIO);
	}
	
	public void test_05_validar_nome_somente_com_espacos() {
		ambienteDeTrabalhoTodosOsAtributos.setNome(ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_validar_nome_com_char_nao_alfanumerico() {
		ambienteDeTrabalhoTodosOsAtributos.setNome(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_validar_nome_com_maximo_de_chars_nome() {
		ambienteDeTrabalhoTodosOsAtributos.setNome(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_08_validar_tipo_de_estabelecimento_nulo() {
		ambienteDeTrabalhoTodosOsAtributos.setTipoEstabelecimento(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_validar_tipo_de_estabelecimento_vazio() {
		ambienteDeTrabalhoTodosOsAtributos.setTipoEstabelecimento(VAZIO);
	}
	
	public void test_10_validar_tipo_de_estabelecimento_somente_com_espacos() {
		ambienteDeTrabalhoTodosOsAtributos.setTipoEstabelecimento(ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_validar_tipo_de_estabelecimento_com_char_nao_alfanumerico() {
		ambienteDeTrabalhoTodosOsAtributos.setTipoEstabelecimento(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_validar_tipo_de_estabelecimento_com_maximo_de_chars_nome() {
		ambienteDeTrabalhoTodosOsAtributos.setTipoEstabelecimento(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_13_validar_endereco_nulo() {
		ambienteDeTrabalhoTodosOsAtributos.setEndereco(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_14_validar_responsavel_nulo() {
		ambienteDeTrabalhoTodosOsAtributos.setResponsavel(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_validar_responsal_vazio() {
		ambienteDeTrabalhoTodosOsAtributos.setResponsavel(VAZIO);
	}
	
	public void test_16_validar_responvel_somente_com_espacos() {
		ambienteDeTrabalhoTodosOsAtributos.setResponsavel(ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_validar_responsavel_com_char_nao_alfanumerico() {
		ambienteDeTrabalhoTodosOsAtributos.setResponsavel(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	@Test(expected = IllegalStateException.class)
	public void test_18_validar_responsavel_com_char_nao_alfanumerico() {
		ambienteDeTrabalhoTodosOsAtributos.setResponsavel(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_19_validar_responsavel_com_numeros() {
		ambienteDeTrabalhoTodosOsAtributos.setResponsavel(TEXTO_COM_CHAR_NUMERICO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_20_validar_responsavel_tamanho_maximo() {
		ambienteDeTrabalhoTodosOsAtributos.setResponsavel(TEXTO_COM_51_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_21_validar_responsavel_de_tamanho_minimo() {
		ambienteDeTrabalhoTodosOsAtributos.setResponsavel(TEXTO_COM_2_CHARS);
	}
	
	@Test
	public void test_22_validar_metodo_hashcode_da_classe_ambiente() {
		assertThat(ambienteDeTrabalhoAtributosObrigatorios.hashCode(), equalTo(ambienteDeTrabalhoTodosOsAtributos.hashCode()));
	}

	@Test
	public void test_23_validar_metodo_equals_ambiente_com_ambiente() {
		assertTrue(ambienteDeTrabalhoAtributosObrigatorios.equals(ambienteDeTrabalhoTodosOsAtributos));
	}
	
	@Test
	public void test_24_validar_metodo_equals_de_ambiente_com_objeto_de_outra_classe() {
		assertFalse(ambienteDeTrabalhoTodosOsAtributos.equals(new Object()));
	}
	
	@Test
	public void test_25_validar_metodo_equals_de_ambiente_com_nulo() {
		assertFalse(ambienteDeTrabalhoAtributosObrigatorios.equals(null));	
	}
	
	@Test
	public void test_26_validar_metodo_equals_de_ambiente_com_outro_objeto_da_mesma_classe() {
		assertTrue(ambienteDeTrabalhoTodosOsAtributos.equals(ambienteDeTrabalhoTodosOsAtributos));
	}
	
	@Test
	public void test_27_validar_() {
		ambienteDeTrabalhoAtributosObrigatorios.setNome(NOME_02);
		assertFalse(ambienteDeTrabalhoAtributosObrigatorios.equals(ambienteDeTrabalhoTodosOsAtributos));
	}
	
	@Test
	public void test_28_validar_() {
		ambienteDeTrabalhoAtributosObrigatorios.setResponsavel(RESPONSAVEL_02);
		assertFalse(ambienteDeTrabalhoAtributosObrigatorios.equals(ambienteDeTrabalhoTodosOsAtributos));
	}
	
	@Test
	public void test_29_validar_() {
		ambienteDeTrabalhoAtributosObrigatorios.setNome(NOME_02);
		ambienteDeTrabalhoAtributosObrigatorios.setResponsavel(RESPONSAVEL_02);
		assertFalse(ambienteDeTrabalhoAtributosObrigatorios.equals(ambienteDeTrabalhoTodosOsAtributos));
	}
	
	@Test
	public void test_30_validar_metodo_to_string_da_classe_ambiente() {
		assertThat(
			ambienteDeTrabalhoTodosOsAtributos.toString(), 
			allOf(
				containsString(NOME),
				containsString(TIPO_DE_ESTABELECIMENTO),
				containsString(ENDERECO.toString()),
				containsString(RESPONSAVEL),
				containsString(DESCRICAO)
			)
		);
	}
}
