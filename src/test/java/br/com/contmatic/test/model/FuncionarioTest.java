package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.INDICE_01;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.INDICE_02;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.DATA_FUTURO;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.DATA_MENOR_IDADE;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.LISTA_NULA;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.LISTA_VAZIA;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.MAX_CHARS_GERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.NUMEROS_COM_LETRA_LITERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_1_CHAR;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_CHAR_NAO_ALFANUMERICO;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.VAZIO;
import static br.com.contmatic.test.model.fabricaobjetos.CriacaoObjetos.construirObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_01;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.CPF_COM_QUANTIDADE_DIG_DIFERENTE;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.CPF_INVALIDO;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.CPF_NUMEROS_REPETIDOS;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.DATA_ABAIXO_MIN;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.DATA_ACIMA_MAX;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.FUNCIONARIOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.FUNCIONARIO_01;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.FUNCIONARIO_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.SALARIO_ACIMA_LIMITE;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.SALARIO_NEGATIVO;
import static br.com.contmatic.test.model.fabricaobjetos.TelefoneFabricaObjetos.LISTA_TELEFONES_ACIMA_DO_LIMITE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.JVM)
public class FuncionarioTest {
	
	@BeforeClass
	public static void pre_test(){
		construirObjetos();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_cpf_nulo() {
		FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setCpf(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_cpf_vazio() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setCpf(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_cpf_numeros_repetidos() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setCpf(CPF_NUMEROS_REPETIDOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_cpf_invalido() {
		FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setCpf(CPF_INVALIDO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_cpf_com_tamanho_errado() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setCpf(CPF_COM_QUANTIDADE_DIG_DIFERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_06_nome_nulo() {
		FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_nome_vazio() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_nome_com_numeros(){
		FUNCIONARIO_TODOS_ATRIBUTOS.setNome(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_nome_min_chars() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_nome_max_chars(){
		FUNCIONARIO_TODOS_ATRIBUTOS.setNome(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_11_data_nascimento_nula() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setDataNascimento(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_data_nascimento_data_futuro() {
		FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setDataNascimento(DATA_FUTURO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_13_data_nascimento_menor_idade() {
		FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setDataNascimento(DATA_MENOR_IDADE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_14_rg_nulo() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setRg(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_rg_vazio() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setRg(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_16_rg_tamanho_min() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setRg(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_rg_tamanho_max() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setRg(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_18_rg_chars_nao_numerico() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setRg(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_19_endereco_nulo() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setEndereco(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_20_lista_telefones_nula() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setTelefones(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_21_lista_telefones_vazia() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setTelefones(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_22_lista_max_telefones() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setTelefones(LISTA_TELEFONES_ACIMA_DO_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_23_lista_emails_nula() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setEmails(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_24_lista_emails_vazia() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setEmails(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_25_lista_max_emails() {
	    // TODO-remove comments
		//FUNCIONARIO_TODOS_ATRIBUTOS.setEmails(LISTA_EMAILS_ACIMA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_26_setor_nula() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setSetor(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_27_setor_vazio() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setSetor(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_28_setor_acima_max_chars() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setSetor(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_29_setor_abaixo_min_chars() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setSetor(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_30_setor_nao_alfanumerico() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setSetor(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_31_cargo_nulo() {
		FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setCargo(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_32_ambiente_de_trabalho_nulo() {
		FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setAmbienteTrabalho(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_33_salario_nulo() {
		FUNCIONARIO_TODOS_ATRIBUTOS.setSalario(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_34_salario_negativo() {
		FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setSalario(SALARIO_NEGATIVO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_35_salario_acima_do_limite () {
		FUNCIONARIO_TODOS_ATRIBUTOS.setSalario(SALARIO_ACIMA_LIMITE);
	}
	
	@Test
	public void test_36_metodo_hashcode() {
		assertEquals(FUNCIONARIOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).hashCode(), FUNCIONARIOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_02).hashCode());
	}
	
	@Test
	public void test_37_metodo_equals() {
		assertTrue(FUNCIONARIO_TODOS_ATRIBUTOS.equals(FUNCIONARIO_TODOS_ATRIBUTOS));
		assertTrue(FUNCIONARIOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).equals(FUNCIONARIOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_02)));
		assertFalse(FUNCIONARIO_TODOS_ATRIBUTOS.equals(new Object()));
		assertFalse(FUNCIONARIO_TODOS_ATRIBUTOS.equals(null));
		assertFalse(FUNCIONARIO_TODOS_ATRIBUTOS.equals(FUNCIONARIOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01)));
	}
	
	@Test
	public void test_38_metodo_tostring() {
		assertThat(
			FUNCIONARIO_TODOS_ATRIBUTOS.toString(), 
			allOf(
				containsString(FUNCIONARIO_TODOS_ATRIBUTOS.getCpf()),
				containsString(FUNCIONARIO_TODOS_ATRIBUTOS.getNome()),
				containsString(FUNCIONARIO_TODOS_ATRIBUTOS.getCargo().toString()),
				containsString(FUNCIONARIO_TODOS_ATRIBUTOS.getDataNascimento().toString()),
				containsString(ENDERECO_01.toString()),
				containsString(FUNCIONARIO_TODOS_ATRIBUTOS.getSetor()),
				containsString(FUNCIONARIO_TODOS_ATRIBUTOS.getSalario().toString())
			)
		);
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void test_31_validar_empresa_nulo() {
       FUNCIONARIO_01.setEmpresa(null);
    }
	
	@Test()
    public void test_32_validar_metodo_setativo() {
        FUNCIONARIO_TODOS_ATRIBUTOS.setAtivo(false);
        assertFalse(FUNCIONARIO_TODOS_ATRIBUTOS.isAtivo());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_33_validar_nulo_metodo_setativo() {
        FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS.setAtivo(null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_34_validar_data_nascimento_acima_limite() {
        FUNCIONARIO_TODOS_ATRIBUTOS.setDataNascimento(DATA_ACIMA_MAX);
    }
    
    @Test(expected = IllegalStateException.class)
    public void test_35_validar_data_nascimento_abaixo_limite() {
        FUNCIONARIO_TODOS_ATRIBUTOS.setDataNascimento(DATA_ABAIXO_MIN);
    }	
}
