package br.com.contmatic.test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static br.com.contmatic.test.model.ConstantsTest.*;
import br.com.contmatic.model.Funcionario;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioTest {
	
	// objetos de teste
	private Funcionario funcionarioAtributosObrigatorios;
	private Funcionario outroFuncionarioAtributosObrigatorios;
	private Funcionario funcinarioTodosOsAtributos;
	
	@BeforeClass
	public void aviso_inicio_testes() {
		System.out.println("Iniciando testes Funcionario");
	}
	
	@Before
	public void pre_test(){
		funcionarioAtributosObrigatorios = new Funcionario(CPF_01);
		outroFuncionarioAtributosObrigatorios = new Funcionario(CPF_02);
		funcinarioTodosOsAtributos = new Funcionario(CPF_01, NOME_01, DATA_NASCIMENTO_01 , ENDERECO_01, SETOR_01, CARGO_01, SALARIO_01);
		funcinarioTodosOsAtributos.setRg(RG_01);
		funcinarioTodosOsAtributos.setEmails(EMAILS);
		funcinarioTodosOsAtributos.setTelefones(TELEFONES);
		funcinarioTodosOsAtributos.setAmbienteTrabalho(AMBIENTE_TRAB_01);
	}
	
	@Test
	public void test_00_instancia() {
		assertEquals(CPF_01, funcinarioTodosOsAtributos.getCpf());
		assertEquals(NOME_01, funcinarioTodosOsAtributos.getNome());
		assertEquals(DATA_NASCIMENTO_01, funcinarioTodosOsAtributos.getDataNascimento());
		assertEquals(ENDERECO_01, funcinarioTodosOsAtributos.getEndereco());
		assertEquals(SETOR_01, funcinarioTodosOsAtributos.getSetor());
		assertEquals(CARGO_01, funcinarioTodosOsAtributos.getCargo());
		assertEquals(SALARIO_01, funcinarioTodosOsAtributos.getSalario());
		assertEquals(RG_01, funcinarioTodosOsAtributos.getRg());
		assertEquals(EMAILS, funcinarioTodosOsAtributos.getEmails());
		assertEquals(TELEFONES, funcinarioTodosOsAtributos.getTelefones());
		assertEquals(AMBIENTE_TRAB_01, funcinarioTodosOsAtributos.getAmbienteTrabalho());
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
	
	@Test(expected = IllegalArgumentException.class)
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
	
	@Test(expected = IllegalArgumentException.class)
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
	
	@Test
	public void test_36_metodo_hashcode() {
		assertEquals(funcinarioTodosOsAtributos.hashCode(), funcionarioAtributosObrigatorios.hashCode());
	}
	
	@Test
	public void test_37_metodo_equals() {
		assertTrue(funcinarioTodosOsAtributos.equals(funcinarioTodosOsAtributos));
		assertTrue(funcinarioTodosOsAtributos.equals(funcionarioAtributosObrigatorios));
		assertFalse(funcinarioTodosOsAtributos.equals(new Object()));
		assertFalse(funcinarioTodosOsAtributos.equals(null));
		assertFalse(funcionarioAtributosObrigatorios.equals(outroFuncionarioAtributosObrigatorios));
	}
	
	@Test
	public void test_38_metodo_tostring() {
		assertThat(
			funcinarioTodosOsAtributos.toString(), 
			allOf(
				containsString(CPF_01),
				containsString(NOME_01),
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
