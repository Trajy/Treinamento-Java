package br.com.contmatic.test.model.fabricaobjetos;

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
        LISTA_PRODUTOS_ACIMA_LIMITE = new ArrayList<>();
        LISTA_PRODUTOS_ACIMA_LIMITE.addAll(PRODUTOS);
        LISTA_PRODUTOS_ACIMA_LIMITE.add(PRODUTO_01);
          
    }
}