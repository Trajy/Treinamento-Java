package br.com.contmatic.test.model.fabricaobjetos;

import java.util.ArrayList;
import java.util.List;


import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarNumerosAleatorios;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarAPartirRegex;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarLetrasAleatorias;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;
import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.Endereco;
import br.com.six2six.fixturefactory.Rule;

import static java.lang.Integer.parseInt;

import static br.com.contmatic.test.model.fabricaobjetos.UnidadeFederativaFabricaObjetos.UF_01;

public final class EnderecoFabricaObjetos {

    private EnderecoFabricaObjetos() {

    }

    public static final Integer NUMERO_ENDERECO_01;
    public static final Integer NUMERO_ENDERECO_02;
    public static final Integer NUMERO_ENDERECO_03;
    public static final Integer NUMERO_ENDERECO_04;
    public static final Integer NUMERO_ENDERECO_05;
    public static final String CEP_01;
    public static final String CEP_02;
    public static final String CEP_03;
    public static final String CEP_04;
    public static final String CEP_05;
    public static final String RUA_01;
    public static final String RUA_02;
    public static final String BAIRRO_01;
    public static final String BAIRRO_02;
    public static final String NOME_CIDADE;
    public static final String NOME_CIDADE_02;
    public static final String PAIS;
    public static final String PAIS_02;
    public static final Cidade CIDADE;
    public static final Cidade OUTRA_CIDADE;
    public static final Endereco ENDERECO_01;
    public static final Endereco ENDERECO_02;
    public static final Endereco ENDERECO_03;
    public static final Endereco ENDERECO_04;
    public static final Endereco ENDERECO_05;
    public static final Endereco ENDERECO_ATRIBUTOS_OBRIGATORIOS;
    
    public static final List<Endereco> ENDERECOS;
    public static final List<Endereco> LISTA_ENDERECOS_ACIMA_LIMITE;

    public static final String CEP_CHARS_REPETIDOS;
    public static final String CEP_COM_LETRA;
    public static final String CEP_TAMANHO_ERRADO;
    public static final Integer ENDERECO_NUM_ACIMA_TAMANHO_MAX;
     
    public static final Endereco ENDERECO_TODOS_ATRIBUTOS;
    public static final List<Endereco> ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS;

    static {
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
        
        Class<Endereco> classe = Endereco.class;
        fabricarEnderecos(classe);
        final int QTD_OBJETOS_IGUAIS = 2;
        ENDERECO_TODOS_ATRIBUTOS = obterObjeto(classe, TODOS_ARGS);
        ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS = obterVariosObjetos(classe, OBRIGATORIOS_ARGS, QTD_OBJETOS_IGUAIS);
        
        OUTRA_CIDADE = new Cidade(NOME_CIDADE, UF_01, PAIS);
        ENDERECO_01 = new Endereco(NUMERO_ENDERECO_01, CEP_01, RUA_01, BAIRRO_01, CIDADE);
        ENDERECO_02 = new Endereco(NUMERO_ENDERECO_02, CEP_02, RUA_02, BAIRRO_02, CIDADE);
        ENDERECO_03 = (new Endereco(NUMERO_ENDERECO_03, CEP_03));
        ENDERECO_04 = (new Endereco(NUMERO_ENDERECO_04, CEP_04));
        ENDERECO_05 = new Endereco(NUMERO_ENDERECO_05, CEP_05);
        ENDERECO_ATRIBUTOS_OBRIGATORIOS = new Endereco(NUMERO_ENDERECO_01, CEP_01);
        
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

    static void construirEndereco() {
        
    }

    private static void fabricarEnderecos(Class classe) {
        fabricarObjeto(classe, TODOS_ARGS, new Rule() {{
            add("numero", gerarNumero());
            add("cep", gerarCep());
            add("rua", gerarRua());
            add("bairro", gerarLetrasComTamanhoPadraoEndereco());
            add("cidade", CIDADE);
        }});
        
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("numero", gerarNumero());
            add("cep", gerarCep());
        }});
    }
    
    private static Integer gerarNumero() {
        final String EXPRESSAO_REGULAR_NUMERO = "[1-9]{1,8}";
        return parseInt(gerarAPartirRegex(EXPRESSAO_REGULAR_NUMERO));
    }
    
    private static String gerarCep() {
        final int CEP_TAMANHO = 8;
        return gerarNumerosAleatorios(CEP_TAMANHO);
    }
    
    private static String gerarRua() {
        final int RUA_TAMANHO_MIN = 2;
        final int RUA_TAMANHO_MAX = 60;
        return gerarLetrasAleatorias(RUA_TAMANHO_MIN, RUA_TAMANHO_MAX);
    }
    
    private static String gerarLetrasComTamanhoPadraoEndereco() {
        final int TAMANHO_MIN_PADRAO_ENDERECO = 2;
        final int TAMANHO_MAX_PADRAO_ENDEROCO = 25;
        return gerarLetrasAleatorias(TAMANHO_MIN_PADRAO_ENDERECO, TAMANHO_MAX_PADRAO_ENDEROCO);
    }
}
