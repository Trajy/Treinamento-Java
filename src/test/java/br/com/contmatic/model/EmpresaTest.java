package br.com.contmatic.model;

import static br.com.contmatic.model.ConstantsTest.AMBIENTES_DE_TRABALHO;
import static br.com.contmatic.model.ConstantsTest.AREA_ATUACAO;
import static br.com.contmatic.model.ConstantsTest.CARGOS;
import static br.com.contmatic.model.ConstantsTest.CNPJ;
import static br.com.contmatic.model.ConstantsTest.CNPJ_COM_LETRA;
import static br.com.contmatic.model.ConstantsTest.CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE;
import static br.com.contmatic.model.ConstantsTest.CNPJ_INVALIDO;
import static br.com.contmatic.model.ConstantsTest.CNPJ_NUMEROS_REPETIDOS;
import static br.com.contmatic.model.ConstantsTest.EMAILS;
import static br.com.contmatic.model.ConstantsTest.ENDERECOS;
import static br.com.contmatic.model.ConstantsTest.ENDERECO_01;
import static br.com.contmatic.model.ConstantsTest.FUNCIONARIOS;
import static br.com.contmatic.model.ConstantsTest.LISTA_AMBIENTES_ACIMA_LIMITE;
import static br.com.contmatic.model.ConstantsTest.LISTA_CARGOS_ACIMA_LIMITE;
import static br.com.contmatic.model.ConstantsTest.LISTA_EMAILS_ACIMA_LIMITE;
import static br.com.contmatic.model.ConstantsTest.LISTA_ENDERECOS_ACIMA_LIMITE;
import static br.com.contmatic.model.ConstantsTest.LISTA_FUNCINARIOS_ACIMA_LIMITE;
import static br.com.contmatic.model.ConstantsTest.LISTA_NULA;
import static br.com.contmatic.model.ConstantsTest.LISTA_PRODUTOS_ACIMA_LIMITE;
import static br.com.contmatic.model.ConstantsTest.LISTA_TELEFONES_ACIMA_DO_LIMITE;
import static br.com.contmatic.model.ConstantsTest.LISTA_VAZIA;
import static br.com.contmatic.model.ConstantsTest.NOME_FANTASIA;
import static br.com.contmatic.model.ConstantsTest.NULO;
import static br.com.contmatic.model.ConstantsTest.OUTRA_RAZAO_SOCIAL;
import static br.com.contmatic.model.ConstantsTest.OUTRO_CNPJ;
import static br.com.contmatic.model.ConstantsTest.OUTRO_NOME_FANTASIA;
import static br.com.contmatic.model.ConstantsTest.PRODUTOS;
import static br.com.contmatic.model.ConstantsTest.RAZAO_SOCIAL;
import static br.com.contmatic.model.ConstantsTest.SOMENTE_ESPACOS;
import static br.com.contmatic.model.ConstantsTest.TELEFONES;
import static br.com.contmatic.model.ConstantsTest.TEXTO_COM_1_CHAR;
import static br.com.contmatic.model.ConstantsTest.TEXTO_COM_71_CHARS;
import static br.com.contmatic.model.ConstantsTest.TEXTO_COM_CHAR_NAO_ALFANUMERICO;
import static br.com.contmatic.model.ConstantsTest.VAZIO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

	// objetos de teste
	private Empresa empresaAtributosObrigatorios;
	private Empresa outraEmpresaTodosOsAtributos;
	private Empresa empresaTodosOsAtributos;


	@Before
	public void pre_test(){
		empresaAtributosObrigatorios = new Empresa(CNPJ, RAZAO_SOCIAL);
		empresaTodosOsAtributos = new Empresa(CNPJ, RAZAO_SOCIAL, NOME_FANTASIA, AREA_ATUACAO);
		outraEmpresaTodosOsAtributos = new Empresa(CNPJ, RAZAO_SOCIAL, NOME_FANTASIA, AREA_ATUACAO);
	}

	@Test
	public void test_01_validar_instancia_com_contrutor_obrigatorio_da_classe_empresa(){
		assertEquals(CNPJ, empresaAtributosObrigatorios.getCnpj());
		assertEquals(RAZAO_SOCIAL, empresaAtributosObrigatorios.getRazaoSocial());
	}

	@Test
	public void test_02_validar_instancia_com_construtor_completo_da_classe_empressa(){
		assertEquals(CNPJ, empresaTodosOsAtributos.getCnpj());
		assertEquals(NOME_FANTASIA, empresaTodosOsAtributos.getNomeFantasia());
		assertEquals(AREA_ATUACAO, empresaTodosOsAtributos.getAreaAtuacao());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_03_validar_cnpj_nulo(){
		empresaTodosOsAtributos.setCnpj(NULO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_04_validar_cnpj_invalido(){
		empresaAtributosObrigatorios.setCnpj(CNPJ_INVALIDO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_05_validar_cnpj_com_numeros_repetidos(){
		empresaAtributosObrigatorios.setCnpj(CNPJ_NUMEROS_REPETIDOS);
	}

	@Test(expected = IllegalStateException.class)
	public void test_06_validar_cnpj_com_apenas_espacos(){
		empresaAtributosObrigatorios.setCnpj(SOMENTE_ESPACOS);
	}

	@Test(expected = IllegalStateException.class)
	public void test_07_validar_cnpj_com_tamanho_diferente_do_padrao(){
		empresaAtributosObrigatorios.setCnpj(CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE);
	}

	@Test(expected = IllegalStateException.class)
	public void test_08_validar_cnpj_sem_nenhum_char(){
		empresaAtributosObrigatorios.setCnpj(VAZIO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_09_validar_cnpj_com_letra(){
		empresaTodosOsAtributos.setCnpj(CNPJ_COM_LETRA);
	}

	@Test
	public void test_10_validar_alteracao_com_cnpj_valido(){
		empresaTodosOsAtributos.setCnpj(OUTRO_CNPJ);
		assertEquals(OUTRO_CNPJ, empresaTodosOsAtributos.getCnpj());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_11_validar_razao_social_nulo(){
		empresaTodosOsAtributos.setRazaoSocial(NULO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_12_validar_razao_social_maior_que_permitido(){
		empresaAtributosObrigatorios.setRazaoSocial(TEXTO_COM_71_CHARS);
	}

	@Test(expected = IllegalStateException.class)
	public void test_13_validar_razao_sozial_menor_que_permitido(){
		empresaAtributosObrigatorios.setRazaoSocial(TEXTO_COM_1_CHAR);
	}

	@Test(expected = IllegalStateException.class)
	public void test_14_validar_razao_social_com_apenas_espacos(){
		empresaAtributosObrigatorios.setRazaoSocial(SOMENTE_ESPACOS);
	}

	@Test(expected = IllegalStateException.class)
	public void test_15_validar_razao_social_sem_nenhum_char(){
		empresaAtributosObrigatorios.setRazaoSocial(VAZIO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_16_validar_razao_social_com_char_nao_alfanumerico(){
		empresaTodosOsAtributos.setRazaoSocial(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}

	@Test
	public void test_17_validar_alteracao_com_cnpj_valido(){
		empresaTodosOsAtributos.setRazaoSocial(OUTRA_RAZAO_SOCIAL);
		assertEquals(OUTRA_RAZAO_SOCIAL, empresaTodosOsAtributos.getRazaoSocial());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_18_validar_nome_fantasia_nulo(){
		empresaTodosOsAtributos.setNomeFantasia(NULO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_19_validar_nome_fantasia_maior_que_permitido(){
		empresaAtributosObrigatorios.setNomeFantasia(TEXTO_COM_71_CHARS);
	}

	@Test(expected = IllegalStateException.class)
	public void test_20_validar_nome_fantasia_menor_que_permitido(){
		empresaAtributosObrigatorios.setNomeFantasia(TEXTO_COM_1_CHAR);
	}

	@Test(expected = IllegalStateException.class)
	public void test_21_validar_nome_fantasia_com_apenas_espacos(){
		empresaAtributosObrigatorios.setNomeFantasia(SOMENTE_ESPACOS);
	}

	@Test(expected = IllegalStateException.class)
	public void test_22_validar_nome_fantasia_sem_nenhum_char(){
		empresaAtributosObrigatorios.setNomeFantasia(VAZIO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_23_validar_nome_fantasia_com_char_nao_alfanumerico(){
		empresaTodosOsAtributos.setNomeFantasia(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}

	@Test
	public void test_24_validar_alteracao_com_nome_fantasia_valido(){
		empresaTodosOsAtributos.setNomeFantasia(OUTRO_NOME_FANTASIA);
		assertEquals(OUTRO_NOME_FANTASIA, empresaTodosOsAtributos.getNomeFantasia());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_25_validar_area_atuacao_nulo(){
		empresaTodosOsAtributos.setAreaAtuacao(NULO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_26_validar_area_atuacao_maior_que_permitido(){
		empresaAtributosObrigatorios.setAreaAtuacao(TEXTO_COM_71_CHARS);
	}

	@Test(expected = IllegalStateException.class)
	public void test_27_validar_area_atuacao_menor_que_permitido(){
		empresaAtributosObrigatorios.setAreaAtuacao(TEXTO_COM_1_CHAR);
	}

	@Test(expected = IllegalStateException.class)
	public void test_28_validar_area_atuacao_com_apenas_espacos(){
		empresaAtributosObrigatorios.setAreaAtuacao(SOMENTE_ESPACOS);
	}

	@Test(expected = IllegalStateException.class)
	public void test_29_validar_area_atuacao_sem_nenhum_char(){
		empresaAtributosObrigatorios.setAreaAtuacao(VAZIO);
	}

	@Test(expected = IllegalStateException.class)
	public void test_30_validar_area_atuacao_com_char_nao_alfanumerico(){
		empresaTodosOsAtributos.setAreaAtuacao(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}

	@Test
	public void test_31_validar_alteracao_com_area_atuacao_valida(){
		empresaTodosOsAtributos.setAreaAtuacao(OUTRO_NOME_FANTASIA);
		assertEquals(OUTRO_NOME_FANTASIA, empresaTodosOsAtributos.getAreaAtuacao());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_32_validar_emails_lista_nula(){
		empresaTodosOsAtributos.setEmails(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_33_validar_emails_lista_vazia() {
		empresaTodosOsAtributos.setEmails(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_34_validar_emails_limite_maximo_de_elementos() {
		empresaTodosOsAtributos.setEmails(LISTA_EMAILS_ACIMA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_35_validar_telefones_lista_nula(){
		empresaTodosOsAtributos.setTelefones(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_36_validar_telefones_lista_vazia() {
		empresaTodosOsAtributos.setTelefones(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_37_validar_telefones_limite_maximo_de_elementos() {
		empresaTodosOsAtributos.setTelefones(LISTA_TELEFONES_ACIMA_DO_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_38_validar_enderecos_lista_nula(){
		empresaTodosOsAtributos.setEnderecos(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_39_validar_enderecos_lista_vazia() {
		empresaTodosOsAtributos.setEnderecos(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_40_validar_enderecos_limite_maximo_de_elementos() {
		empresaTodosOsAtributos.setEnderecos(LISTA_ENDERECOS_ACIMA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_41_validar_funcionarios_lista_nula(){
		empresaTodosOsAtributos.setFuncionarios(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_42_validar_funcionarios_lista_vazia() {
		empresaTodosOsAtributos.setFuncionarios(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_43_validar_funcionarios_limite_maximo_de_elementos() {
		empresaTodosOsAtributos.setFuncionarios(LISTA_FUNCINARIOS_ACIMA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_44_validar_produtos_lista_nula(){
		empresaTodosOsAtributos.setProdutos(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_45_validar_produtos_lista_vazia() {
		empresaTodosOsAtributos.setProdutos(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_46_validar_produtos_limite_maximo_de_elementos() {
		empresaTodosOsAtributos.setProdutos(LISTA_PRODUTOS_ACIMA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_47_validar_cargos_lista_nula(){
		empresaTodosOsAtributos.setCargos(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_48_validar_cargos_lista_vazia() {
		empresaTodosOsAtributos.setCargos(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_49_validar_cargos_limite_maximo_de_elementos() {
		empresaTodosOsAtributos.setCargos(LISTA_CARGOS_ACIMA_LIMITE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_50_validar_ambientes_de_trabalho_lista_nula(){
		empresaTodosOsAtributos.setAmbientesTrabalho(LISTA_NULA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_51_validar_ambientes_de_trabalho_lista_vazia() {
		empresaTodosOsAtributos.setAmbientesTrabalho(LISTA_VAZIA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_52_validar_ambientes_de_trabalho_limite_maximo_de_elementos() {
		empresaTodosOsAtributos.setAmbientesTrabalho(LISTA_AMBIENTES_ACIMA_LIMITE);
	}
	
	@Test
	public void test_53_validar_metodo_hashCode_de_empresa() {
		assertThat(empresaTodosOsAtributos.hashCode(), equalTo(empresaAtributosObrigatorios.hashCode()));
	}
	
	@Test
	public void test_54_validar_metodo_equals_de_empresa_com_empresa() {
		assertTrue(empresaAtributosObrigatorios.equals(empresaTodosOsAtributos));
	}
	
	@Test
	public void test_55_validar_metodo_equals_de_empresa_com_objeto_de_classe_diferente() {
		assertFalse(empresaTodosOsAtributos.equals(ENDERECO_01));
	}
	
	@Test
	public void test_56_validar_metodo_equals_de_empresa_com_nulo() {
		assertFalse(empresaTodosOsAtributos.equals(NULO));
	}

	@Test
	public void test_57_validar_metodo_equals_de_empresa_com_outro_objeto_da_mesma_classe() {
		assertTrue(empresaTodosOsAtributos.equals(empresaTodosOsAtributos));
	}
	
	// pode fazer 
	@Test
	public void test_58_validar_metodo_tostring_de_empresa() {
		assertThat(empresaTodosOsAtributos.toString(), equalTo(outraEmpresaTodosOsAtributos.toString()));
	}

}

