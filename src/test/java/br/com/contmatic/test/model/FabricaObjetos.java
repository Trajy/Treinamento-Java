package br.com.contmatic.test.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.empresa.AmbienteTrabalho;
import br.com.contmatic.model.empresa.Cargo;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Funcionario;
import br.com.contmatic.model.empresa.Produto;
import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.Endereco;

final class FabricaObjetos {
    
    //Email
    protected static String EMAIL_LITERAL_01;
    protected static String EMAIL_LITERAL_02;
    protected static String EMAIL_LITERAL_03;
    protected static String EMAIL_LITERAL_04;
    protected static Email EMAIL_01;
    protected static Email EMAIL_02;
    protected static Email EMAIL_03;
    protected static Email EMAIL_04;
    protected static List<Email> EMAILS;
    
    //Telefone
    protected static Integer DDI_01;
    protected static Integer DDI_02;
    protected static Integer DDD_01;
    protected static Integer DDD_02;
    protected static String NUMERO_TELEFONE_01;
    protected static String NUMERO_TELEFONE_02;
    protected static String NUMERO_TELEFONE_03;
    protected static String NUMERO_TELEFONE_04;
    protected static String NUMERO_TELEFONE_05;
    protected static Telefone TELEFONE_01;
    protected static Telefone TELEFONE_02;
    protected static Telefone TELEFONE_03;
    protected static Telefone TELEFONE_04;
    protected static Telefone TELEFONE_05;
    protected static Telefone TELEFONE_ATRIBUTOS_OBRIGATORIOS;
    protected static Telefone TELEFONE_TODOS_ATRIBUTOS;
    protected static List<Telefone> TELEFONES;
        
    // Endereco
    protected static Integer NUMERO_ENDERECO_01;
    protected static Integer NUMERO_ENDERECO_02;
    protected static Integer NUMERO_ENDERECO_03;
    protected static Integer NUMERO_ENDERECO_04;
    protected static Integer NUMERO_ENDERECO_05;
    protected static String CEP_01;
    protected static String CEP_02;
    protected static String CEP_03;
    protected static String CEP_04;
    protected static String CEP_05;
    protected static String RUA_01;
    protected static String RUA_02;
    protected static String BAIRRO_01;
    protected static String BAIRRO_02;
    protected static String NOME_CIDADE;
    protected static String NOME_CIDADE_02;
    protected static String UF;
    protected static String UF_02;
    protected static String PAIS;
    protected static String PAIS_02;
    protected static Cidade CIDADE;
    protected static Cidade OUTRA_CIDADE;
    protected static Endereco ENDERECO_01;
    protected static Endereco ENDERECO_02;
    protected static Endereco ENDERECO_03;
    protected static Endereco ENDERECO_04;
    protected static Endereco ENDERECO_05;
    protected static List<Endereco> ENDERECOS;
    
    // Cargo
    protected static String CBO_01;
    protected static String CBO_02;
    protected static String CBO_03;
    protected static String CBO_04;
    protected static String NOME_CARGO_01;
    protected static String NOME_CARGO_02;
    protected static String DESCRICAO_CARGO_01;
    protected static String DESCRICAO_CARGO_02;
    protected static Cargo CARGO_01;
    protected static Cargo CARGO_02;
    protected static Cargo CARGO_03;
    protected static Cargo CARGO_04;
    protected static List<Cargo> CARGOS;
    
    // Ambiente de Trabalho
    protected static String NOME_AMBINETE_TRAB_01;
    protected static String NOME_AMBIENTE_TRAB_02;
    protected static String NOME_AMBIENTE_TRAB_03;
    protected static String TIPO_AMBIENTE_TRAB_PROPRIO;
    protected static String TIPO_AMBIENTE_TRAB_TERCEIROS;
    protected static String NOME_RESPONSAVEL_AMBIENTE;
    protected static String DESC_AMBIENTE;
    protected static String DESC_AMBIENTE_02;
    protected static AmbienteTrabalho AMBIENTE_TRAB_01;
    protected static AmbienteTrabalho AMBIENTE_TRAB_02;
    protected static AmbienteTrabalho AMBIENTE_TRAB_03;
    protected static List<AmbienteTrabalho> AMBIENTES_DE_TRABALHO;
    
    // Funcionario
    protected static String CPF_01;
    protected static String CPF_02;
    protected static String CPF_03;
    protected static String CPF_04;
    protected static String CPF_05;
    protected static String CPF_06;
    protected static String CPF_07;
    protected static String CPF_08;
    protected static String NOME_01;
    protected static String NOME_02;
    protected static String RG_01;
    protected static String RG_02;
    protected static LocalDate DATA_NASCIMENTO_01;
    protected static LocalDate DATA_NASCIMENTO_02;
    protected static String  SETOR_01;
    protected static String SETOR_02;
    protected static Float SALARIO_01;
    protected static Float SALARIO_02;
    protected static Funcionario FUNCIONARIO_01;
    protected static Funcionario FUNCIONARIO_02;
    protected static Funcionario FUNCIONARIO_03;
    protected static Funcionario FUNCIONARIO_04;
    protected static Funcionario FUNCIONARIO_05;
    protected static Funcionario FUNCIONARIO_06;
    protected static Funcionario FUNCIONARIO_07;
    protected static Funcionario FUNCIONARIO_08;
    protected static Funcionario FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS;
    protected static Funcionario OUTRO_FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS;
    protected static Funcionario FUNCIONARIO_TODOS_ATRIBUTOS;
    protected static List<Funcionario> FUNCIONARIOS;
    
    
    // Produto
    protected static String NOME_PRODUTO_01;
    protected static String NOME_PRODUTO_02;
    protected static String NOME_PRODUTO_03;
    protected static String NOME_PRODUTO_04;
    protected static String NOME_PRODUTO_05;
    protected static String VERSAO_01;
    protected static String VERSAO_02;
    protected static String VERSAO_03;
    protected static String VERSAO_04;
    protected static String VERSAO_05;
    protected static String CODIGO_01;
    protected static String CODIGO_02;
    protected static String CODIGO_03;
    protected static String CODIGO_04;
    protected static String CODIGO_05;
    protected static Produto PRODUTO_ATRIBUTOS_OBRIGATORIOS;
    protected static Produto OUTRO_PRODUTO_ATRIBUTOS_OBRIGATORIOS;
    protected static Produto PRODUTO_TODOS_ATRIBUTOS;
    protected static Produto PRODUTO_01;
    protected static Produto PRODUTO_02;
    protected static Produto PRODUTO_03;
    protected static Produto PRODUTO_04;
    protected static Produto PRODUTO_05;
    protected static List<Produto> PRODUTOS;
    
    // constants corretas Empresa
    protected static String CNPJ;
    protected static String OUTRO_CNPJ;
    protected static String RAZAO_SOCIAL;
    protected static String OUTRA_RAZAO_SOCIAL;
    protected static String NOME_FANTASIA;
    protected static String OUTRO_NOME_FANTASIA;
    protected static String AREA_ATUACAO;
    protected static Empresa EMPRESA_TODOS_ATRIBUTOS;

    protected static Empresa EMPRESA_ATRIBUTOS_OBRIGATORIOS;
    
    // constants de erro
    protected static String CEP_CHARS_REPETIDOS;
    protected static String CEP_COM_LETRA;
    protected static String CEP_TAMANHO_ERRADO;
    protected static Integer ENDERECO_NUM_ACIMA_TAMANHO_MAX;
    protected static Integer DDI_ACIMA_MAX_CHARS;
    protected static Integer DDD_ABAIXO_MIN_CHARS;
    protected static Integer DDD_ACIMA_MAX_CHARS;
    protected static String NUMERO_TELEFONE_ACIMA_MAX_CHARS;
    protected static String NUMERO_TELEFONE_ABAIXO_MIN_CHARS;
    protected static String EMAIL_SEM_ARROBA;
    protected static String EMAIL_COM_ARROBA_INICIO;
    protected static LocalDate DATA_FUTURO;
    protected static LocalDate DATA_MENOR_IDADE;
    protected static Float SALARIO_NEGATIVO;
    protected static Float SALARIO_NEGATIVO_COM_PONTO;
    protected static Float SALARIO_ACIMA_LIMITE;
    protected static String NULO;
    protected static String CPF_NUMEROS_REPETIDOS;
    protected static String CPF_INVALIDO;
    protected static String CPF_COM_QUANTIDADE_DIG_DIFERENTE;
    protected static String CNPJ_INVALIDO;
    protected static String CNPJ_NUMEROS_REPETIDOS;
    protected static String CNPJ_COM_LETRA;
    protected static String CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE;
    protected static String VAZIO;
    protected static String SOMENTE_ESPACOS;
    protected static String TEXTO_COM_CHAR_NAO_ALFANUMERICO;
    protected static String LITERAL_NUMERICO_COM_10_CHARS;
    protected static String TEXTO_COM_71_CHARS;
    protected static String TEXTO_COM_1_CHAR;
    protected static String NUMEROS_COM_LETRA_LITERAL;
    protected static String TEXTO_COM_CHAR_NUMERICO;
    protected static List LISTA_NULA;
    protected static List LISTA_VAZIA;
    protected static List<Email> LISTA_EMAILS_ACIMA_LIMITE;
    protected static List<Telefone> LISTA_TELEFONES_ACIMA_DO_LIMITE;
    protected static List<Endereco> LISTA_ENDERECOS_ACIMA_LIMITE;
    protected static List<Cargo> LISTA_CARGOS_ACIMA_LIMITE;
    protected static List<AmbienteTrabalho> LISTA_AMBIENTES_ACIMA_LIMITE;
    protected static List<Funcionario> LISTA_FUNCINARIOS_ACIMA_LIMITE;
    protected static List<Produto> LISTA_PRODUTOS_ACIMA_LIMITE;
    
    
    protected static final void construirObjetos() {
	
    	//Email
    	EMAIL_LITERAL_01 = "henrique.araujo@contmatic.com.br";
    	EMAIL_LITERAL_02 = "jessica.silva@contmatic.com.br";
    	EMAIL_LITERAL_03 = "erich.miyamura@contmatic.com.br";
    	EMAIL_LITERAL_04 = "contmatic@contmatic.com.br";
    	EMAIL_01 = new Email(EMAIL_LITERAL_01);
    	EMAIL_02 = new Email(EMAIL_LITERAL_01);
    	EMAIL_03 = new Email(EMAIL_LITERAL_03);
    	EMAIL_04 = new Email(EMAIL_LITERAL_04);
    	EMAILS = new ArrayList<>();
    	EMAILS.add(EMAIL_01);
    	EMAILS.add(EMAIL_02);
    	EMAILS.add(EMAIL_03);
    	EMAILS.add(EMAIL_04);
    	
    	//Telefone
    	DDI_01 = 55;
    	DDI_02 = 99;
    	DDD_01 = 11;
    	DDD_02 = 67;
    	NUMERO_TELEFONE_01 = "996300338";
    	NUMERO_TELEFONE_02 = "940028922";
    	NUMERO_TELEFONE_03 = "25569976";
    	NUMERO_TELEFONE_04 = "976439802";
    	NUMERO_TELEFONE_05 = "983749321";
    	TELEFONE_01 = new Telefone(DDI_01 ,DDD_01, NUMERO_TELEFONE_01);
    	TELEFONE_02 = new Telefone(DDI_02, DDD_02, NUMERO_TELEFONE_02);
    	TELEFONE_03 = new Telefone(DDD_01, NUMERO_TELEFONE_03);
    	TELEFONE_04 = new Telefone(DDD_01, NUMERO_TELEFONE_04);
    	TELEFONE_05 = new Telefone(DDD_01, NUMERO_TELEFONE_05);
    	TELEFONES = new ArrayList<>();
    	TELEFONE_ATRIBUTOS_OBRIGATORIOS = new Telefone(DDD_01, NUMERO_TELEFONE_01);
        TELEFONE_TODOS_ATRIBUTOS = new Telefone(DDI_01, DDD_01, NUMERO_TELEFONE_01);
    	TELEFONES.add(TELEFONE_01);
    	TELEFONES.add(TELEFONE_02);
    	TELEFONES.add(TELEFONE_03);
    	TELEFONES.add(TELEFONE_04);
    	TELEFONES.add(TELEFONE_05);
    		
    	// Endereco
    	NUMERO_ENDERECO_01 = 1000;
    	NUMERO_ENDERECO_02 = 22;
    	NUMERO_ENDERECO_03 = 4000;
    	NUMERO_ENDERECO_04 = 1234;
    	NUMERO_ENDERECO_05 = 43;
    	CEP_01 = "12345678";
    	CEP_02 = "83940239";
    	CEP_03 = "67865678";
    	CEP_04 = "08076123";
    	CEP_05 = "39483920";
    	RUA_01 = "rua quinze";
    	RUA_02 = "novaes";
    	BAIRRO_01 = "liberdade";
    	BAIRRO_02 = "se";
    	NOME_CIDADE = "sao paulo";
    	NOME_CIDADE_02 = "Bahia";
    	UF = "SP";
    	UF_02 = "SC";
    	PAIS = "Brasil";
    	PAIS_02 = "Chile";
    	CIDADE = new Cidade(NOME_CIDADE, UF, PAIS);
    	OUTRA_CIDADE = new Cidade(NOME_CIDADE, UF, PAIS);
    	ENDERECO_01 = new Endereco(NUMERO_ENDERECO_01, CEP_01, RUA_01,BAIRRO_01 , CIDADE);
    	ENDERECO_02 = new Endereco(NUMERO_ENDERECO_02, CEP_02, RUA_02, BAIRRO_02, CIDADE);
    	ENDERECO_03 = (new Endereco(NUMERO_ENDERECO_03,CEP_03));
    	ENDERECO_04 = (new Endereco(NUMERO_ENDERECO_04, CEP_04));
    	ENDERECO_05 = new Endereco(NUMERO_ENDERECO_05, CEP_05);
    	ENDERECOS = new ArrayList<>();
        ENDERECOS.add(ENDERECO_01);
    	ENDERECOS.add(ENDERECO_02);
    	ENDERECOS.add(ENDERECO_03);
    	ENDERECOS.add(ENDERECO_04);
    	ENDERECOS.add(ENDERECO_05);
    	
    	// Cargo
    	CBO_01 = "85748394";
    	CBO_02 = "83758292";
    	CBO_03 = "09876543";
    	CBO_04 = "56473829";
    	NOME_CARGO_01 = "programador";
    	NOME_CARGO_02 = "analista de QA";
    	DESCRICAO_CARGO_01 = "desenvolvimento de software";
    	DESCRICAO_CARGO_02 = "garantir a qualidade de software e metodologias de testes";
    	CARGO_01 = new Cargo(CBO_01, NOME_CARGO_01, DESCRICAO_CARGO_01);
    	CARGO_02 = new Cargo(CBO_02, NOME_CARGO_02, DESCRICAO_CARGO_02);
    	CARGO_03 = new Cargo(CBO_03);
    	CARGO_04 = new Cargo(CBO_01);
    	CARGOS = new ArrayList<>();
    	CARGOS.add(CARGO_01);
    	CARGOS.add(CARGO_02);
    	CARGOS.add(CARGO_03);
    	CARGOS.add(CARGO_04);
    	
    	// Ambiente de Trabalho
    	NOME_AMBINETE_TRAB_01 = "desenvolvimento";
    	NOME_AMBIENTE_TRAB_02 = "qualidade";
    	NOME_AMBIENTE_TRAB_03 = "devops";
    	TIPO_AMBIENTE_TRAB_PROPRIO = "proprio";
    	TIPO_AMBIENTE_TRAB_TERCEIROS = "terceiros";
    	NOME_RESPONSAVEL_AMBIENTE = "jubileu";
    	DESC_AMBIENTE = "ambiente de trabalho";
    	DESC_AMBIENTE_02 = "ambiente de trabalho diferente";
    	AMBIENTE_TRAB_01 = new AmbienteTrabalho(NOME_AMBINETE_TRAB_01, TIPO_AMBIENTE_TRAB_PROPRIO, ENDERECO_01, NOME_RESPONSAVEL_AMBIENTE, DESC_AMBIENTE);
    	AMBIENTE_TRAB_02 = new AmbienteTrabalho(NOME_AMBIENTE_TRAB_02, TIPO_AMBIENTE_TRAB_PROPRIO);
    	AMBIENTE_TRAB_03 = new AmbienteTrabalho(NOME_AMBINETE_TRAB_01, TIPO_AMBIENTE_TRAB_TERCEIROS, ENDERECO_02, NOME_RESPONSAVEL_AMBIENTE, DESC_AMBIENTE_02);
    	AMBIENTES_DE_TRABALHO = new ArrayList<>();
    	AMBIENTES_DE_TRABALHO.add(AMBIENTE_TRAB_01);
    	AMBIENTES_DE_TRABALHO.add(AMBIENTE_TRAB_02);
    	
    	// Funcionario
    	CPF_01 = "44632236012";
    	CPF_02 = "38275183006";
    	CPF_03 = "16916182091";
    	CPF_04 = "62827689006";
    	CPF_05 = "16421920071";
    	CPF_06 = "45636760043";
    	CPF_07 = "77189772006";
    	CPF_08 = "82647631034";
    	NOME_01 = "Julio";
    	NOME_02 = "Ana";
    	RG_01 = "243847701";
    	RG_02 = "349694643";
    	DATA_NASCIMENTO_01 = LocalDate.of(1998, 5, 22);
    	DATA_NASCIMENTO_02 = LocalDate.of(2000, 12, 30);
    	SETOR_01 = "Programacao";
    	SETOR_02 = "Producao";
    	SALARIO_01 = 20000.00f;
    	SALARIO_02 = 4500.95f;
    	FUNCIONARIO_01 = new Funcionario(CPF_01, NOME_01, DATA_NASCIMENTO_01, ENDERECO_01, SETOR_01, CARGO_01, SALARIO_01);
    	FUNCIONARIO_02 = new Funcionario(CPF_02, NOME_02, DATA_NASCIMENTO_02, ENDERECO_02, SETOR_02, CARGO_02, SALARIO_02);
    	FUNCIONARIO_03 = new Funcionario(CPF_03);
    	FUNCIONARIO_04 = new Funcionario(CPF_04);
    	FUNCIONARIO_05 = new Funcionario(CPF_05);
    	FUNCIONARIO_06 = new Funcionario(CPF_06);
    	FUNCIONARIO_07 = new Funcionario(CPF_07);
    	FUNCIONARIO_08 = new Funcionario(CPF_08);
    	FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS = new Funcionario(CPF_01);
        OUTRO_FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS = new Funcionario(CPF_02);
        FUNCIONARIO_TODOS_ATRIBUTOS = new Funcionario(CPF_01, NOME_01, DATA_NASCIMENTO_01 , ENDERECO_01, SETOR_01, CARGO_01, SALARIO_01);
        FUNCIONARIO_TODOS_ATRIBUTOS.setRg(RG_01);
        FUNCIONARIO_TODOS_ATRIBUTOS.setEmails(EMAILS);
        FUNCIONARIO_TODOS_ATRIBUTOS.setTelefones(TELEFONES);
        FUNCIONARIO_TODOS_ATRIBUTOS.setAmbienteTrabalho(AMBIENTE_TRAB_01);
    	FUNCIONARIOS = new ArrayList<>();
    	FUNCIONARIOS.add(FUNCIONARIO_01);
    	FUNCIONARIOS.add(FUNCIONARIO_02);
    	FUNCIONARIOS.add(FUNCIONARIO_03);
    	FUNCIONARIOS.add(FUNCIONARIO_04);
    	FUNCIONARIOS.add(FUNCIONARIO_05);
    	FUNCIONARIOS.add(FUNCIONARIO_06);
    	FUNCIONARIOS.add(FUNCIONARIO_07);
    	FUNCIONARIOS.add(FUNCIONARIO_08);
    	
    	// Produto
    	NOME_PRODUTO_01 = "Gestao SST";
    	NOME_PRODUTO_02 = "Simplifique";
    	NOME_PRODUTO_03 = "Simplifique migration";
    	NOME_PRODUTO_04 = "Teste produto";
    	NOME_PRODUTO_05 = "Teste produto";
    	VERSAO_01 = "1.0.1";
    	VERSAO_02 = "1.0.1";
    	VERSAO_03 = "0.8.3";
    	VERSAO_04 = "2.6.7";
    	VERSAO_05 = "2.6.7";
    	CODIGO_01 = "30403";
    	CODIGO_02 = "29789";
    	CODIGO_03 = "29111";
    	CODIGO_04 = "22334";
    	CODIGO_05 = "22556";
    	PRODUTO_01 = new Produto(NOME_PRODUTO_01, VERSAO_01, CODIGO_01);
    	PRODUTO_02 = new Produto(NOME_PRODUTO_02, VERSAO_02, CODIGO_02);
    	PRODUTO_03 = new Produto(NOME_PRODUTO_03, VERSAO_03, CODIGO_03);
    	PRODUTO_04 = new Produto(NOME_PRODUTO_04, VERSAO_04, CODIGO_04);
    	PRODUTO_05 = new Produto(NOME_PRODUTO_05, VERSAO_05, CODIGO_05);
    	PRODUTO_ATRIBUTOS_OBRIGATORIOS = new Produto(CODIGO_01);
        OUTRO_PRODUTO_ATRIBUTOS_OBRIGATORIOS = new Produto(CODIGO_02);
        PRODUTO_TODOS_ATRIBUTOS = new Produto(NOME_PRODUTO_01, VERSAO_01, CODIGO_01);
    	PRODUTOS = new ArrayList<>();
    	PRODUTOS.add(PRODUTO_01);
    	PRODUTOS.add(PRODUTO_02);
    	PRODUTOS.add(PRODUTO_03);
    	PRODUTOS.add(PRODUTO_04);
    	PRODUTOS.add(PRODUTO_05);
    	
    	// constants corretas Empresa
    	CNPJ = "11222333000181";
    	OUTRO_CNPJ = "61830755000108";
    	RAZAO_SOCIAL = "SOFTMATIC ... LTDA";
    	OUTRA_RAZAO_SOCIAL = "Teste SOFTMATIC";
    	NOME_FANTASIA = "CONTMATIC ... LTDA";
    	OUTRO_NOME_FANTASIA = "Teste CONTMATIC";
    	AREA_ATUACAO = "Software";
    	
    	EMPRESA_TODOS_ATRIBUTOS = new Empresa(CNPJ, RAZAO_SOCIAL, NOME_FANTASIA, AREA_ATUACAO);
        EMPRESA_TODOS_ATRIBUTOS.setEmails(EMAILS);
        EMPRESA_TODOS_ATRIBUTOS.setTelefones(TELEFONES);
        EMPRESA_TODOS_ATRIBUTOS.setEnderecos(ENDERECOS);
        EMPRESA_TODOS_ATRIBUTOS.setFuncionarios(FUNCIONARIOS);
        EMPRESA_TODOS_ATRIBUTOS.setProdutos(PRODUTOS);
        EMPRESA_TODOS_ATRIBUTOS.setCargos(CARGOS);
        EMPRESA_TODOS_ATRIBUTOS.setAmbientesTrabalho(AMBIENTES_DE_TRABALHO);
        
        EMPRESA_ATRIBUTOS_OBRIGATORIOS = new Empresa(CNPJ);
    	
    	//setEmpresa nos demais objetos
    	AMBIENTE_TRAB_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
    	CARGO_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
    	FUNCIONARIO_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
    	PRODUTO_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
    	ENDERECO_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
    	
    	// constants de erro
    	CEP_CHARS_REPETIDOS = "11111111";
    	CEP_COM_LETRA = "123a5678";
    	CEP_TAMANHO_ERRADO = "123901203";
    	ENDERECO_NUM_ACIMA_TAMANHO_MAX = 123456789;
    	DDI_ACIMA_MAX_CHARS = 1234;
    	DDD_ABAIXO_MIN_CHARS = 1;
    	DDD_ACIMA_MAX_CHARS = 1234;
    	NUMERO_TELEFONE_ACIMA_MAX_CHARS = "1234567890";
    	NUMERO_TELEFONE_ABAIXO_MIN_CHARS = "1234567";
    	EMAIL_SEM_ARROBA = "emailcontmatic.com.br";
    	EMAIL_COM_ARROBA_INICIO = "@contmatic.com.br";
    	DATA_FUTURO = LocalDate.of(2025, 06, 15);
    	DATA_MENOR_IDADE = LocalDate.of(2020, 06, 15);
    	SALARIO_NEGATIVO = -1000f;
    	SALARIO_NEGATIVO_COM_PONTO = 0.0f;
    	SALARIO_ACIMA_LIMITE = 105000f;
    	NULO = null;
    	CPF_NUMEROS_REPETIDOS = "22222222222";
    	CPF_INVALIDO = "44632236011";
    	CPF_COM_QUANTIDADE_DIG_DIFERENTE = "446322360121";
    	CNPJ_INVALIDO = "58119371000178";
    	CNPJ_NUMEROS_REPETIDOS = "11111111111111";
    	CNPJ_COM_LETRA = "5811937a00017";
    	CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE = "123456789012345";
    	VAZIO = "";
    	SOMENTE_ESPACOS = "      ";
    	TEXTO_COM_CHAR_NAO_ALFANUMERICO = "123abcΩω";
    	LITERAL_NUMERICO_COM_10_CHARS = "1456734876";
    	TEXTO_COM_71_CHARS = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ1234567890123456789";
    	TEXTO_COM_1_CHAR = "a";
    	NUMEROS_COM_LETRA_LITERAL = "587a00";
    	TEXTO_COM_CHAR_NUMERICO = "text0 com num3r0";
    	LISTA_NULA = null;
    	LISTA_VAZIA = new ArrayList<>();
    	LISTA_EMAILS_ACIMA_LIMITE = new ArrayList<>();
    	LISTA_EMAILS_ACIMA_LIMITE.addAll(EMAILS);
    	LISTA_EMAILS_ACIMA_LIMITE.add(EMAIL_01);
    	LISTA_TELEFONES_ACIMA_DO_LIMITE = new ArrayList<>();
    	LISTA_TELEFONES_ACIMA_DO_LIMITE.addAll(TELEFONES);
    	LISTA_TELEFONES_ACIMA_DO_LIMITE.add(TELEFONE_01);
    	LISTA_ENDERECOS_ACIMA_LIMITE = new ArrayList<>();
    	LISTA_ENDERECOS_ACIMA_LIMITE.addAll(ENDERECOS);
    	LISTA_ENDERECOS_ACIMA_LIMITE.add(ENDERECO_01);
    	LISTA_CARGOS_ACIMA_LIMITE = new ArrayList<>();
    	LISTA_CARGOS_ACIMA_LIMITE.addAll(CARGOS);
    	LISTA_CARGOS_ACIMA_LIMITE.add(CARGO_01);
    	LISTA_AMBIENTES_ACIMA_LIMITE = new ArrayList<>();
    	LISTA_AMBIENTES_ACIMA_LIMITE.addAll(AMBIENTES_DE_TRABALHO);
    	LISTA_AMBIENTES_ACIMA_LIMITE.add(AMBIENTE_TRAB_01);
    	LISTA_FUNCINARIOS_ACIMA_LIMITE = new ArrayList<>();
    	LISTA_FUNCINARIOS_ACIMA_LIMITE.addAll(FUNCIONARIOS);
    	LISTA_FUNCINARIOS_ACIMA_LIMITE.add(FUNCIONARIO_01);
    	LISTA_PRODUTOS_ACIMA_LIMITE = new ArrayList<>();
    	LISTA_PRODUTOS_ACIMA_LIMITE.addAll(PRODUTOS);
    	LISTA_PRODUTOS_ACIMA_LIMITE.add(PRODUTO_01);
    }	
}
