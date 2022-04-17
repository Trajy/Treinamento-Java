package br.com.contmatic.test.model.fabricaobjetos;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.Endereco;
import static br.com.contmatic.test.model.fabricaobjetos.UnidadeFederativaFabricaObjetos.UF_01;

public final class EnderecoFabricaObjetos {
    
    private EnderecoFabricaObjetos() {
        
    }
    
    public static Integer NUMERO_ENDERECO_01;
    public static Integer NUMERO_ENDERECO_02;
    public static Integer NUMERO_ENDERECO_03;
    public static Integer NUMERO_ENDERECO_04;
    public static Integer NUMERO_ENDERECO_05;
    public static String CEP_01;
    public static String CEP_02;
    public static String CEP_03;
    public static String CEP_04;
    public static String CEP_05;
    public static String RUA_01;
    public static String RUA_02;
    public static String BAIRRO_01;
    public static String BAIRRO_02;
    public static String NOME_CIDADE;
    public static String NOME_CIDADE_02;
    public static String PAIS;
    public static String PAIS_02;
    public static Cidade CIDADE;
    public static Cidade OUTRA_CIDADE;
    public static Endereco ENDERECO_01;
    public static Endereco ENDERECO_02;
    public static Endereco ENDERECO_03;
    public static Endereco ENDERECO_04;
    public static Endereco ENDERECO_05;
    public static Endereco ENDERECO_ATRIBUTOS_OBRIGATORIOS;
    public static Endereco ENDERECO_TODOS_ATRIBUTOS;
    public static List<Endereco> ENDERECOS;
    public static List<Endereco> LISTA_ENDERECOS_ACIMA_LIMITE;
    
    public static String CEP_CHARS_REPETIDOS;
    public static String CEP_COM_LETRA;
    public static String CEP_TAMANHO_ERRADO;
    public static Integer ENDERECO_NUM_ACIMA_TAMANHO_MAX;
    
    static void construirEndereco() {
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
        PAIS = "Brasil";
        PAIS_02 = "Chile";
        CIDADE = new Cidade(NOME_CIDADE, UF_01, PAIS);
        OUTRA_CIDADE = new Cidade(NOME_CIDADE, UF_01, PAIS);
        ENDERECO_01 = new Endereco(NUMERO_ENDERECO_01, CEP_01, RUA_01,BAIRRO_01 , CIDADE);
        ENDERECO_02 = new Endereco(NUMERO_ENDERECO_02, CEP_02, RUA_02, BAIRRO_02, CIDADE);
        ENDERECO_03 = (new Endereco(NUMERO_ENDERECO_03,CEP_03));
        ENDERECO_04 = (new Endereco(NUMERO_ENDERECO_04, CEP_04));
        ENDERECO_05 = new Endereco(NUMERO_ENDERECO_05, CEP_05);
        ENDERECO_ATRIBUTOS_OBRIGATORIOS = new Endereco(NUMERO_ENDERECO_01, CEP_01);
        ENDERECO_TODOS_ATRIBUTOS = new Endereco(NUMERO_ENDERECO_01, CEP_01, RUA_01, BAIRRO_01, CIDADE);
        ENDERECOS = new ArrayList<>();
        ENDERECOS.add(ENDERECO_01);
        ENDERECOS.add(ENDERECO_02);
        ENDERECOS.add(ENDERECO_03);
        ENDERECOS.add(ENDERECO_04);
        ENDERECOS.add(ENDERECO_05);
        LISTA_ENDERECOS_ACIMA_LIMITE = new ArrayList<>();
        LISTA_ENDERECOS_ACIMA_LIMITE.addAll(ENDERECOS);
        LISTA_ENDERECOS_ACIMA_LIMITE.add(ENDERECO_01);
        
        CEP_CHARS_REPETIDOS = "11111111";
        CEP_COM_LETRA = "123a5678";
        CEP_TAMANHO_ERRADO = "123901203";
        ENDERECO_NUM_ACIMA_TAMANHO_MAX = 123456789;
        
    }
}
