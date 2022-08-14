package br.com.contmatic.model.utils.constantes;

public final class EnderecoConstantes {
    
    private EnderecoConstantes() {
        
    }
    
    public static final int ENDERECO_NUMERO_MAX = 8;
    public static final int ENDERECO_NUMERO_MIN = 1;
    public static final int CEP_TAMANHO = 8;
    public static final int RUA_MAX = 60;
    public static final int RUA_MIN = 2;
    public static final int BAIRRO_MAX = 25;
    public static final int BAIRRO_MIN = 2;
    public static final int CIDADE_MAX = 25;
    public static final int CIDADE_MIN = 2;
    public static final int ESTADO_MAX = 15;
    public static final int ESTADO_MIN = 2;
    public static final int PAIS_MAX = 25;
    public static final int PAIS_MIN = 2;
    
    public static final String NUMERO_ENDERECO_INVALIDO = "numero do endereco fornecido invalido"; 
    public static final String CEP_INVALIDO = "CEP fornecido e invalido";
    public static final String RUA_INVALIDO = "rua fornecida invalida";
    public static final String BAIRRO_INVALIDO = "bairro invalido";
    public static final String CIDADE_INVALIDO = "cidade invalida";
    public static final String ESTADO_INVALIDO = "estado invalido";
    public static final String PAIS_INVALIDO = "pais invalido";

}
