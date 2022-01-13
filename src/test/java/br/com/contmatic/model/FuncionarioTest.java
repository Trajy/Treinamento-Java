package br.com.contmatic.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.print.attribute.standard.DateTimeAtProcessing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static br.com.contmatic.model.ConstantsTest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioTest {
	
	// objetos de teste
	private Funcionario funcionarioAtributosObrigatorios;
	private Funcionario funcinarioTodosOsAtributos;
	
	@Before
	public void pre_test(){
		funcionarioAtributosObrigatorios = new Funcionario(CPF_01);
		funcinarioTodosOsAtributos = new Funcionario(CPF_02, NOME_02, DATA_NASCIMENTO_01 , ENDERECO_01, SETOR_01, CARGO_01, SALARIO_01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_cpf_nulo() {
		funcionarioAtributosObrigatorios.setCpf(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_cpf_vazio() {
		funcinarioTodosOsAtributos.setCpf(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_cpf_numeros_repetidos() {
		funcinarioTodosOsAtributos.setCpf(CPF_NUMEROS_REPETIDOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_cpf_invalido() {
		funcionarioAtributosObrigatorios.setCpf(CPF_INVALIDO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_cpf_com_tamanho_errado() {
		funcinarioTodosOsAtributos.setCpf(CPF_COM_QUANTIDADE_DIG_DIFERENTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_06_nome_nulo() {
		funcionarioAtributosObrigatorios.setNome(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_nome_vazio() {
		funcinarioTodosOsAtributos.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_08_nome_com_numeros(){
		funcinarioTodosOsAtributos.setNome(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_nome_min_chars() {
		funcinarioTodosOsAtributos.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_nome_max_chars(){
		funcinarioTodosOsAtributos.setNome(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_11_data_nascimento_nula() {
		funcinarioTodosOsAtributos.setDataNascimento(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_data_nascimento_data_futuro() {
		funcionarioAtributosObrigatorios.setDataNascimento(DATA_FUTURO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_13_data_nascimento_menor_idade() {
		funcionarioAtributosObrigatorios.setDataNascimento(DATA_MENOR_IDADE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_14_rg_nulo() {
		funcinarioTodosOsAtributos.setRg(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_rg_vazio() {
		funcinarioTodosOsAtributos.setRg(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_16_rg_tamanho_min() {
		funcinarioTodosOsAtributos.setRg(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_rg_tamanho_max() {
		funcinarioTodosOsAtributos.setRg(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_18_rg_chars_nao_numerico() {
		funcinarioTodosOsAtributos.setRg(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_19_endereco_nulo() {
		funcinarioTodosOsAtributos.setEndereco(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_20_lista_telefones_nula() {
		funcinarioTodosOsAtributos.setTelefones(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_21_lista_telefones_vazia() {
		funcinarioTodosOsAtributos.setTelefones(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_22_lista_max_telefones() {
		funcinarioTodosOsAtributos.setTelefones(LISTA_TELEFONES_ACIMA_DO_LIMITE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_23_lista_emails_nula() {
		funcinarioTodosOsAtributos.setEmails(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_24_lista_emails_vazia() {
		funcinarioTodosOsAtributos.setEmails(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_25_lista_max_emails() {
		funcinarioTodosOsAtributos.setEmails(LISTA_EMAILS_ACIMA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_26_setor_nula() {
		funcinarioTodosOsAtributos.setSetor(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_27_setor_vazio() {
		funcinarioTodosOsAtributos.setSetor(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_28_setor_acima_max_chars() {
		funcinarioTodosOsAtributos.setSetor(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_29_setor_abaixo_min_chars() {
		funcinarioTodosOsAtributos.setSetor(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_30_setor_nao_alfanumerico() {
		funcinarioTodosOsAtributos.setSetor(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_31_cargo_nulo() {
		funcionarioAtributosObrigatorios.setCargo(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_32_ambiente_de_trabalho_nulo() {
		funcionarioAtributosObrigatorios.setAmbienteTrabalho(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_33_salario_nulo() {
		funcinarioTodosOsAtributos.setSalario(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_34_salario_negativo() {
		funcionarioAtributosObrigatorios.setSalario(SALARIO_NEGATIVO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_35_salario_acima_do_limite () {
		funcinarioTodosOsAtributos.setSalario(SALARIO_ACIMA_LIMITE);
	}
	
	//TODO implementar testes para os metodos equals e hashcode
	
	@Test
	public void test_xx_metodo_tostring() {
		assertThat(
				funcinarioTodosOsAtributos.toString(), 
				allOf(
					containsString(CPF_02),
					containsString(NOME_02),
					containsString(DESCRICAO_CARGO_01),
					containsString(DATA_NASCIMENTO_01.toString()),
					containsString(ENDERECO_01.toString()),
					containsString(SETOR_01),
					containsString(CARGO_01.toString()),
					containsString(SALARIO_01.toString())
			)
		);
	}	
}
