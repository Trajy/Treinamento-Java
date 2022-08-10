package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.gerarAPartirRegex;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.gerarLetrasAleatorias;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.gerarNumerosAleatorios;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Produto;
import br.com.six2six.fixturefactory.Rule;

public final class ProdutoFabricaObjetos {
    
    private ProdutoFabricaObjetos() {
        
    }
    
    public static final String NOME_PRODUTO_01;
    public static final String NOME_PRODUTO_02;
    public static final String NOME_PRODUTO_03;
    public static final String NOME_PRODUTO_04;
    public static final String NOME_PRODUTO_05;
    public static final String VERSAO_01;
    public static final String VERSAO_02;
    public static final String VERSAO_03;
    public static final String VERSAO_04;
    public static final String VERSAO_05;
    public static final String CODIGO_01;
    public static final String CODIGO_02;
    public static final String CODIGO_03;
    public static final String CODIGO_04;
    public static final String CODIGO_05;
    public static final String DESCRICAO_01;
    public static final String DESCRICAO_02;
    public static final String DESCRICAO_03;
    public static final String DESCRICAO_04;
    public static final String DESCRICAO_05;
    public static final BigDecimal PRECO_01;
    public static final Produto PRODUTO_ATRIBUTOS_OBRIGATORIOS;
    public static final Produto OUTRO_PRODUTO_ATRIBUTOS_OBRIGATORIOS;
    public static final Produto PRODUTO_TODOS_ATRIBUTOS;
    public static final Produto PRODUTO_01;
    public static final Produto PRODUTO_02;
    public static final Produto PRODUTO_03;
    public static final Produto PRODUTO_04;
    public static final Produto PRODUTO_05;
    public static final List<Produto> PRODUTOS;
    public static final List<Produto> LISTA_PRODUTOS_ACIMA_LIMITE;
    
    public static final BigDecimal PRECO_ABAIXO_MIN;
    public static final BigDecimal PRECO_ACIMA_MAX;
    
    public static final Integer INDICE_01;
    public static final Integer INDICE_02;
    public static final List<Produto> PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
    
    static {
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
        
        Class<Produto> classe = Produto.class;
        fabricarProdutos(classe);
        final int QUANTIDADE_PRODUTOS_IGUAIS = 2;
        INDICE_01 = 0;
        INDICE_02 = 1;
        PRODUTO_TODOS_ATRIBUTOS = obterObjeto(classe, TODOS_ARGS);
        PRODUTOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS = obterVariosObjetos(classe, OBRIGATORIOS_ARGS, QUANTIDADE_PRODUTOS_IGUAIS);
        
        PRECO_01 = new BigDecimal("500000");
        PRODUTO_01 = new Produto(NOME_PRODUTO_01, VERSAO_01, CODIGO_01, DESCRICAO_01, PRECO_01);
        PRODUTO_02 = new Produto(NOME_PRODUTO_02, VERSAO_02, CODIGO_02, DESCRICAO_02, PRECO_01);
        PRODUTO_03 = new Produto(NOME_PRODUTO_03, VERSAO_03, CODIGO_03, DESCRICAO_03, PRECO_01);
        PRODUTO_04 = new Produto(NOME_PRODUTO_04, VERSAO_04, CODIGO_04, DESCRICAO_04, PRECO_01);
        PRODUTO_05 = new Produto(NOME_PRODUTO_05, VERSAO_05, CODIGO_05, DESCRICAO_05, PRECO_01);
        PRODUTO_ATRIBUTOS_OBRIGATORIOS = new Produto(CODIGO_01);
        OUTRO_PRODUTO_ATRIBUTOS_OBRIGATORIOS = new Produto(CODIGO_02);
         
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
    
    static void construirProduto() {
        
    }
    
    private static void fabricarProdutos(Class classe) {
        fabricarObjeto(classe, TODOS_ARGS, new Rule() {{
            add("nome", gerarLetrasAleatorias());
            add("versao", gerarVersaoOuCodigo());
            add("codigo", gerarVersaoOuCodigo());
            add("descricao", gerarLetrasAleatorias());
            add("preco", gerarPreco());
            add("empresa", new Empresa("11222333000181"));
        }});
        
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("codigo", gerarVersaoOuCodigo());
        }});
    }
    
    private static String gerarVersaoOuCodigo() {
        final String EXPRESSAO_REGULAR_CODIGO = "[0-9]{1,2}.[0-9]{1,2}.[0-9]{1,2}";
        return gerarAPartirRegex(EXPRESSAO_REGULAR_CODIGO);
    }
    
    private static BigDecimal gerarPreco() {
        return new BigDecimal(gerarNumerosAleatorios(1, 6));
    }
}
