package br.com.contmatic.model.utils.constantes;

import java.math.BigDecimal;

public final class ProdutoConstantes {
    
    private ProdutoConstantes() {
        
    }
    
    public static final int PRODUTO_VERSAO_TAMANHO_MAX = 10;
    public static final int PRODUTO_VERSAO_TAMANHO_MIN = 3;
    public static final int PRODUTO_CODIGO_TAMANHO_MAX = 10;
    public static final int PRODUTO_CODIGO_TAMANHO_MIN = 5;
    public static final BigDecimal PRECO_MIN_PRODUTO = new BigDecimal("1");
    public static final BigDecimal PRECO_MAX_PRODUTO = new BigDecimal("1000000");
    
    public static final String NOME_PRODUTO_INVALIDO = "nome do produto fornecido invalido";
    public static final String VERSAO_INVALIDA = "versao invalida";
    public static final String CODIGO_INVALIDO = "codigo invalido";
    public static final String DESCRICAO_PRODUTO_INVALIDA = "descricao do produto invalida";
    public static final String PRECO_PRODUTO_INVALIDO = "Preco fornecido para o produto invalido";

}
