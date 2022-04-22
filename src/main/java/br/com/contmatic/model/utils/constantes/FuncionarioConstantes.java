package br.com.contmatic.model.utils.constantes;

import java.math.BigDecimal;

public final class FuncionarioConstantes {
    
    private FuncionarioConstantes() {
        
    }
    
    public static final int IDADE_MIN_TRABALHISTA = 16;
    public static final int IDADE_MAX_TRABALHISTA = 100;
    public static final int LIMITE_IDADE_CONTRATACAO = 100;
    public static final int RG_MAX = 10;
    public static final int RG_MIN = 5;
    public static final BigDecimal SALARIO_MIN = new BigDecimal("800");
    public static final BigDecimal SALARIO_MAX = new BigDecimal("100000");
    
    public static final String NOME_INVALIDO = "Nome do funcionario invalido";
    public static final String DATA_FUNCIONARIO_INVALIDA = "Data invalida de nascimento do funcinario invalida";
    public static final String CPF_INVALIDO = "CPF do funcinario fornecido invalido";
    public static final String RG_FUNCINARIO_INVALIDO = "rg fornecido para o funcinario invalido";
    public static final String SALARIO_FUNCINARIO_INVALIDO = "Salario do funcinario fornecido invalido";
    public static final String SETOR_FUNCIONARIO_INVALIDO = "setor fornecido ao funcinario invalido";
    
}
