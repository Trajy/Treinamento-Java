package br.com.contmatic.test.model.fabricaobjetos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.empresa.Produto;

public final class ProdutoFabricaObjetos {
    
    private ProdutoFabricaObjetos() {
        
    }
    
    public static String NOME_PRODUTO_01;
    public static String NOME_PRODUTO_02;
    public static String NOME_PRODUTO_03;
    public static String NOME_PRODUTO_04;
    public static String NOME_PRODUTO_05;
    public static String VERSAO_01;
    public static String VERSAO_02;
    public static String VERSAO_03;
    public static String VERSAO_04;
    public static String VERSAO_05;
    public static String CODIGO_01;
    public static String CODIGO_02;
    public static String CODIGO_03;
    public static String CODIGO_04;
    public static String CODIGO_05;
    public static String DESCRICAO_01;
    public static String DESCRICAO_02;
    public static String DESCRICAO_03;
    public static String DESCRICAO_04;
    public static String DESCRICAO_05;
    public static BigDecimal PRECO_01;
    public static Produto PRODUTO_ATRIBUTOS_OBRIGATORIOS;
    public static Produto OUTRO_PRODUTO_ATRIBUTOS_OBRIGATORIOS;
    public static Produto PRODUTO_TODOS_ATRIBUTOS;
    public static Produto PRODUTO_01;
    public static Produto PRODUTO_02;
    public static Produto PRODUTO_03;
    public static Produto PRODUTO_04;
    public static Produto PRODUTO_05;
    public static List<Produto> PRODUTOS;
    public static List<Produto> LISTA_PRODUTOS_ACIMA_LIMITE;
    
    public static BigDecimal PRECO_ABAIXO_MIN;
    public static BigDecimal PRECO_ACIMA_MAX;
    
    static void construirProduto() {
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
        DESCRICAO_01 = "produto voltado para gestao de SST";
        DESCRICAO_02 = "Software ERP para gestao";
        DESCRICAO_03 = "migracao de dados entre gestao emp. e simplifique";
        DESCRICAO_04 = "produto para testes";
        DESCRICAO_05 = "teste de software";
        PRECO_01 = new BigDecimal("500000");
        PRODUTO_01 = new Produto(NOME_PRODUTO_01, VERSAO_01, CODIGO_01, DESCRICAO_01, PRECO_01);
        PRODUTO_02 = new Produto(NOME_PRODUTO_02, VERSAO_02, CODIGO_02, DESCRICAO_02, PRECO_01);
        PRODUTO_03 = new Produto(NOME_PRODUTO_03, VERSAO_03, CODIGO_03, DESCRICAO_03, PRECO_01);
        PRODUTO_04 = new Produto(NOME_PRODUTO_04, VERSAO_04, CODIGO_04, DESCRICAO_04, PRECO_01);
        PRODUTO_05 = new Produto(NOME_PRODUTO_05, VERSAO_05, CODIGO_05, DESCRICAO_05, PRECO_01);
        PRODUTO_ATRIBUTOS_OBRIGATORIOS = new Produto(CODIGO_01);
        OUTRO_PRODUTO_ATRIBUTOS_OBRIGATORIOS = new Produto(CODIGO_02);
        PRODUTO_TODOS_ATRIBUTOS = new Produto(NOME_PRODUTO_01, VERSAO_01, CODIGO_01, DESCRICAO_01, PRECO_01);
        PRODUTOS = new ArrayList<>();
        PRODUTOS.add(PRODUTO_01);
        PRODUTOS.add(PRODUTO_02);
        PRODUTOS.add(PRODUTO_03);
        PRODUTOS.add(PRODUTO_04);
        PRODUTOS.add(PRODUTO_05);
        LISTA_PRODUTOS_ACIMA_LIMITE = new ArrayList<>();
        LISTA_PRODUTOS_ACIMA_LIMITE.addAll(PRODUTOS);
        LISTA_PRODUTOS_ACIMA_LIMITE.add(PRODUTO_01);
        
        PRECO_ABAIXO_MIN = BigDecimal.ZERO;
        PRECO_ACIMA_MAX = new BigDecimal("1000001");
    }
}
