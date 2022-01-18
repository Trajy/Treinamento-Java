package br.com.contmatic.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.endereco.Cidade;

public final class ConstantsTest {
	
	//Email
	protected static final String EMAIL_LITERAL_01 = "henrique.araujo@contmatic.com.br";
	protected static final String EMAIL_LITERAL_02 = "jessica.silva@contmatic.com.br";
	protected static final String EMAIL_LITERAL_03 = "erich.miyamura@contmatic.com.br";
	protected static final String EMAIL_LITERAL_04 = "contmatic@contmatic.com.br";
	protected static final Email EMAIL_01 = new Email(EMAIL_LITERAL_01);
	protected static final Email EMAIL_02 = new Email(EMAIL_LITERAL_02);
	protected static final Email EMAIL_03 = new Email(EMAIL_LITERAL_03);
	protected static final Email EMAIL_04 = new Email(EMAIL_LITERAL_04);
	protected static final List<Email> EMAILS = new ArrayList<>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(EMAIL_01);
		add(EMAIL_02);
		add(EMAIL_03);
		add(EMAIL_04);
	}};
	
	//Telefone
	protected static final Integer DDI_01 = 55;
	protected static final Integer DDI_02 = 99;
	protected static final Integer DDD_01 = 11;
	protected static final Integer DDD_02 = 67;
	protected static final String NUMERO_TELEFONE_01 = "996300338";
	protected static final String NUMERO_TELEFONE_02 = "940028922";
	protected static final String NUMERO_TELEFONE_03 = "25569976";
	protected static final String NUMERO_TELEFONE_04 = "976439802";
	protected static final String NUMERO_TELEFONE_05 = "983749321";
	protected static final Telefone TELEFONE_01 = new Telefone(DDI_01 ,DDD_01, NUMERO_TELEFONE_01);
	protected static final Telefone TELEFONE_02 = new Telefone(DDI_02, DDD_02, NUMERO_TELEFONE_02);
	protected static final Telefone TELEFONE_03 = new Telefone(DDD_01, NUMERO_TELEFONE_03);
	protected static final Telefone TELEFONE_04 = new Telefone(DDD_01, NUMERO_TELEFONE_04);
	protected static final Telefone TELEFONE_05 = new Telefone(DDD_01, NUMERO_TELEFONE_05);
	protected static final List<Telefone> TELEFONES = new ArrayList<>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(TELEFONE_01);
		add(TELEFONE_02);
		add(TELEFONE_03);
		add(TELEFONE_04);
		add(TELEFONE_05);
	}};
		
	// Endereco
	protected static final Integer NUMERO_ENDERECO_01 = 1000;
	protected static final Integer NUMERO_ENDERECO_02 = 22;
	protected static final Integer NUMERO_ENDERECO_03 = 4000;
	protected static final Integer NUMERO_ENDERECO_04 = 1234;
	protected static final Integer NUMERO_ENDERECO_05 = 43;
	protected static final String CEP_01 = "12345678";
	protected static final String CEP_02 = "83940239";
	protected static final String CEP_03 = "67865678";
	protected static final String CEP_04 = "08076123";
	protected static final String CEP_05 = "39483920";
	protected static final String RUA_01 = "rua quinze";
	protected static final String RUA_02 = "novaes";
	protected static final String BAIRRO_01 = "liberdade";
	protected static final String BAIRRO_02 = "se";
	protected static final String NOME_CIDADE = "sao paulo";
	protected static final String NOME_CIDADE_02 = "Bahia";
	protected static final String UF = "SP";
	protected static final String UF_02 = "SC";
	protected static final String PAIS = "Brasil";
	protected static final String PAIS_02 = "Chile";
	protected static final Cidade CIDADE = new Cidade(NOME_CIDADE, UF, PAIS);
	protected static final Endereco ENDERECO_01 = new Endereco(NUMERO_ENDERECO_01, CEP_01, RUA_01,BAIRRO_01 , CIDADE);
	protected static final Endereco ENDERECO_02 = new Endereco(NUMERO_ENDERECO_02, CEP_02, RUA_02, BAIRRO_02, CIDADE);
	protected static final Endereco ENDERECO_03 = (new Endereco(NUMERO_ENDERECO_03,CEP_03));
	protected static final Endereco ENDERECO_04 = (new Endereco(NUMERO_ENDERECO_04, CEP_04));
	protected static final Endereco ENDERECO_05 = new Endereco(NUMERO_ENDERECO_05, CEP_05);
	protected static final List<Endereco> ENDERECOS = new ArrayList<>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(ENDERECO_01);
		add(ENDERECO_02);
		add(ENDERECO_03);
		add(ENDERECO_04);
		add(ENDERECO_05);
	}};
	
	// Cargo
	protected static final String CBO_01 = "85748394";
	protected static final String CBO_02 = "83758292";
	protected static final String CBO_03 = "09876543";
	protected static final String CBO_04 = "56473829";
	protected static final String NOME_CARGO_01 = "programador";
	protected static final String NOME_CARGO_02 = "analita de QA";
	protected static final String DESCRICAO_CARGO_01 = "desenvolvimento de software";
	protected static final String DESCRICAO_CARGO_02 = "garantir a qualidade de software e metodologias de testes";
	protected static final Cargo CARGO_01 = new Cargo(CBO_01, NOME_CARGO_01, DESCRICAO_CARGO_01);
	protected static final Cargo CARGO_02 = new Cargo(CBO_02, NOME_CARGO_02, DESCRICAO_CARGO_02);
	protected static final Cargo CARGO_03 = new Cargo(CBO_03);
	protected static final Cargo CARGO_04 = new Cargo(CBO_04);
	protected static final List<Cargo> CARGOS = new ArrayList<>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(CARGO_01);
		add(CARGO_02);
		add(CARGO_03);
		add(CARGO_04);
	}};
	
	// Ambiente de Trabalho
	protected static final String NOME_AMBINETE_TRAB_01 = "desenvolvimento";
	protected static final String NOME_AMBIENTE_TRAB_02 = "qualidade";
	protected static final String TIPO_AMBIENTE_TRAB_PROPRIO = "proprio";
	protected static final AmbienteTrabalho AMBIENTE_TRAB_01 = new AmbienteTrabalho(NOME_AMBINETE_TRAB_01, TIPO_AMBIENTE_TRAB_PROPRIO);
	protected static final AmbienteTrabalho AMBIENTE_TRAB_02 = new AmbienteTrabalho(NOME_AMBIENTE_TRAB_02, TIPO_AMBIENTE_TRAB_PROPRIO);
	protected static final List<AmbienteTrabalho> AMBIENTES_DE_TRABALHO = new ArrayList<>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(AMBIENTE_TRAB_01);
		add(AMBIENTE_TRAB_02);
	}};
	
	// Funcionario
	protected static final String CPF_01 = "44632236012";
	protected static final String CPF_02 = "38275183006";
	protected static final String CPF_03 = "16916182091";
	protected static final String CPF_04 = "62827689006";
	protected static final String CPF_05 = "16421920071";
	protected static final String CPF_06 = "45636760043";
	protected static final String CPF_07 = "77189772006";
	protected static final String CPF_08 = "82647631034";
	protected static final String NOME_01 = "Julio";
	protected static final String NOME_02 = "Ana";
	protected static final String RG_01 = "243847701";
	protected static final String RG_02 = "349694643";
	protected static final LocalDate DATA_NASCIMENTO_01 = LocalDate.of(1998, 5, 22);
	protected static final LocalDate DATA_NASCIMENTO_02 = LocalDate.of(2005, 12, 30);
	protected static final String SETOR_01 = "Programacao";
	protected static final String SETOR_02 = "Producao";
	protected static final Float SALARIO_01 = 2000.00f;
	protected static final Float SALARIO_02 = 4500.95f;
	protected static final Funcionario FUNCIONARIO_01 = new Funcionario(CPF_01, NOME_01, DATA_NASCIMENTO_01, ENDERECO_01, SETOR_01, CARGO_01, SALARIO_01);
	protected static final Funcionario FUNCIONARIO_02 = new Funcionario(CPF_02, NOME_02, DATA_NASCIMENTO_02, ENDERECO_02, SETOR_02, CARGO_02, SALARIO_02);
	protected static final Funcionario FUNCIONARIO_03 = new Funcionario(CPF_03);
	protected static final Funcionario FUNCIONARIO_04 = new Funcionario(CPF_04);
	protected static final Funcionario FUNCIONARIO_05 = new Funcionario(CPF_05);
	protected static final Funcionario FUNCIONARIO_06 = new Funcionario(CPF_06);
	protected static final Funcionario FUNCIONARIO_07 = new Funcionario(CPF_07);
	protected static final Funcionario FUNCIONARIO_08 = new Funcionario(CPF_08);
	protected static final List<Funcionario> FUNCIONARIOS = new ArrayList<>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(FUNCIONARIO_01);
		add(FUNCIONARIO_02);
		add(FUNCIONARIO_03);
		add(FUNCIONARIO_04);
		add(FUNCIONARIO_05);
		add(FUNCIONARIO_06);
		add(FUNCIONARIO_07);
		add(FUNCIONARIO_08);
	}};
	protected static final Produto PRODUT0_04 = null;
	
	// Produto
	protected static String NOME_PRODUTO_01 = "Gestao SST";
	protected static String NOME_PRODUTO_02 = "Simplifique";
	protected static String NOME_PRODUTO_03 = "Simplifique migration";
	protected static String NOME_PRODUTO_04 = "Teste produto";
	protected static String NOME_PRODUTO_05 = "Teste produto";
	protected static String VERSAO_01 = "1.0.1";
	protected static String VERSAO_02 = "1.0.1";
	protected static String VERSAO_03 = "0.8.3";
	protected static String VERSAO_04 = "2.6.7";
	protected static String VERSAO_05 = "2.6.7";
	protected static String CODIGO_01 = "30403";
	protected static String CODIGO_02 = "29789";
	protected static String CODIGO_03 = "29111";
	protected static String CODIGO_04 = "22334";
	protected static String CODIGO_05 = "22556";
	protected static Produto PRODUTO_01 = new Produto(NOME_PRODUTO_01, VERSAO_01, CODIGO_01);
	protected static Produto PRODUTO_02 = new Produto(NOME_PRODUTO_02, VERSAO_02, CODIGO_02);
	protected static Produto PRODUTO_03 = new Produto(NOME_PRODUTO_03, VERSAO_03, CODIGO_03);
	protected static Produto PRODUTO_04 = new Produto(NOME_PRODUTO_04, VERSAO_04, CODIGO_04);
	protected static Produto PRODUTO_05 = new Produto(NOME_PRODUTO_05, VERSAO_05, CODIGO_05);
	protected static final List<Produto> PRODUTOS = new ArrayList<>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add(PRODUTO_01);
		add(PRODUTO_02);
		add(PRODUTO_03);
		add(PRODUT0_04);
		add(PRODUTO_05);
	}};
	
	// constants corretas Empresa
	protected static final String CNPJ = "11222333000181";
	protected static final String OUTRO_CNPJ = "61830755000108";
	protected static final String RAZAO_SOCIAL = "SOFTMATIC ... LTDA";
	protected static final String OUTRA_RAZAO_SOCIAL = "Teste SOFTMATIC";
	protected static final String NOME_FANTASIA = "CONTMATIC ... LTDA";
	protected static final String OUTRO_NOME_FANTASIA = "Teste CONTMATIC";
	protected static final String AREA_ATUACAO = "Software";
	
	// constants de erro
	protected static final String CEP_CHARS_REPETIDOS = "11111111";
	protected static final String CEP_COM_LETRA = "123a5678";
	protected static final String CEP_TAMANHO_ERRADO = "123901203";
	protected static final Integer ENDERECO_NUM_ACIMA_TAMANHO_MAX = 123456789;
	protected static final Integer DDI_ACIMA_MAX_CHARS = 1234;
	protected static final Integer DDD_ABAIXO_MIN_CHARS = 1;
	protected static final Integer DDD_ACIMA_MAX_CHARS = 1234;
	protected static final String NUMERO_TELEFONE_ACIMA_MAX_CHARS = "1234567890";
	protected static final String NUMERO_TELEFONE_ABAIXO_MIN_CHARS = "1234567";
	protected static final String EMAIL_SEM_ARROBA = "emailcontmatic.com.br";
	protected static final String EMAIL_COM_ARROBA_INICIO = "@contmatic.com.br";
	protected static final LocalDate DATA_FUTURO = LocalDate.of(2025, 06, 15);
	protected static final LocalDate DATA_MENOR_IDADE = LocalDate.of(2020, 06, 15);
	protected static final Float SALARIO_NEGATIVO = -10f;
	protected static final Float SALARIO_ACIMA_LIMITE = 105000f;
	protected static final String NULO = null;
	protected static final String CPF_NUMEROS_REPETIDOS = "22222222222";
	protected static final String CPF_INVALIDO = "44632236011";
	protected static final String CPF_COM_QUANTIDADE_DIG_DIFERENTE = "446322360121";
	protected static final String CNPJ_INVALIDO = "58119371000178";
	protected static final String CNPJ_NUMEROS_REPETIDOS = "11111111111111";
	protected static final String CNPJ_COM_LETRA = "5811937a00017";
	protected static final String CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE = "123456789012345";
	protected static final String VAZIO = "";
	protected static final String SOMENTE_ESPACOS = "      ";
	protected static final String TEXTO_COM_CHAR_NAO_ALFANUMERICO = "123abcΩω";
	protected static final String LITERAL_NUMERICO_COM_10_CHARS = "1456734876";
	protected static final String TEXTO_COM_71_CHARS = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ1234567890123456789";
	protected static final String TEXTO_COM_1_CHAR = "a";
	protected static final String NUMEROS_COM_LETRA_LITERAL = "587a00";
	protected static final List LISTA_NULA = null;
	protected static final List LISTA_VAZIA = new ArrayList<>();
	protected static final List<Email> LISTA_EMAILS_ACIMA_LIMITE = new ArrayList<>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		addAll(EMAILS);
		add(EMAIL_01);
		
	}};
	protected static final List<Telefone> LISTA_TELEFONES_ACIMA_DO_LIMITE = new ArrayList<>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		addAll(TELEFONES);
		add(TELEFONE_01);
	}};
	protected static final List<Endereco> LISTA_ENDERECOS_ACIMA_LIMITE = new ArrayList<>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		addAll(ENDERECOS);
		add(ENDERECO_01);
	}};
	protected static final List<Cargo> LISTA_CARGOS_ACIMA_LIMITE = new ArrayList<>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		addAll(CARGOS);
		add(CARGO_01);
	}};
	protected static final List<AmbienteTrabalho> LISTA_AMBIENTES_ACIMA_LIMITE = new ArrayList<>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		addAll(AMBIENTES_DE_TRABALHO);
		add(AMBIENTE_TRAB_01);
	}};
	protected static final List<Funcionario> LISTA_FUNCINARIOS_ACIMA_LIMITE = new ArrayList<>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		addAll(FUNCIONARIOS);
		add(FUNCIONARIO_01);
	}};
	protected static final List<Produto> LISTA_PRODUTOS_ACIMA_LIMITE = new ArrayList<>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		addAll(PRODUTOS);
		add(PRODUTO_01);
	}};
	
	
}
