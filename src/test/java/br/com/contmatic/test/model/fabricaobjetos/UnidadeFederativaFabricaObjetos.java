package br.com.contmatic.test.model.fabricaobjetos;

import br.com.contmatic.model.endereco.UnidadeFederativa;

public class UnidadeFederativaFabricaObjetos {
    
    public static Integer CODIGO_01;
    public static Integer CODIGO_02;
    public static String NOME_UF_01;
    public static String NOME_UF_02;
    public static String SIGLA_UF_01;
    public static String SIGLA_UF_02;
    public static UnidadeFederativa UF_01;
    public static UnidadeFederativa UF_02;
    
    static void construirUnidadeFederativa() {
       CODIGO_01 = 11;
       CODIGO_02 = 85;
       NOME_UF_01 = "Sao Paulo";
       NOME_UF_02 = "Mato Grosso";
       SIGLA_UF_01 = "SP";
       SIGLA_UF_02 = "MT";
       UF_01 = new UnidadeFederativa(CODIGO_01, NOME_UF_01, SIGLA_UF_01);
       UF_02 = new UnidadeFederativa(CODIGO_02, NOME_UF_02, SIGLA_UF_02);
    }

}
