package br.com.contmatic.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
		funcinarioTodosOsAtributos = new Funcionario(CPF_02, NOME_02,DATA_NASCIMENTO_01 , ENDERECO_01, SETOR_01, CARGO_01, SALARIO_01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_cpf_nulo() {
		funcionarioAtributosObrigatorios.setCpf(CPF_01);
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
	
	
	
	

}
