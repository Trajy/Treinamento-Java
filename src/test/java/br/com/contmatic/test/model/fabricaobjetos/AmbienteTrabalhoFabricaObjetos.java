package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_01;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_02;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.empresa.AmbienteTrabalho;

public final class AmbienteTrabalhoFabricaObjetos {
    
    private AmbienteTrabalhoFabricaObjetos() {
        
    }
    
    public static String NOME_RESPONSAVEL_01_;
    public static String NOME_RESPONSAVEL_02;
    public static String NOME_AMBINETE_TRAB_01;
    public static String NOME_AMBIENTE_TRAB_02;
    public static String NOME_AMBIENTE_TRAB_03;
    public static String TIPO_AMBIENTE_TRAB_PROPRIO;
    public static String TIPO_AMBIENTE_TRAB_TERCEIROS;
    public static String NOME_RESPONSAVEL_AMBIENTE;
    public static String DESC_AMBIENTE;
    public static String DESC_AMBIENTE_02;
    public static AmbienteTrabalho AMBIENTE_TRAB_01;
    public static AmbienteTrabalho AMBIENTE_TRAB_02;
    public static AmbienteTrabalho AMBIENTE_TRAB_03;
    public static List<AmbienteTrabalho> AMBIENTES_DE_TRABALHO;
    public static List<AmbienteTrabalho> LISTA_AMBIENTES_ACIMA_LIMITE;
    
    static void construirAmbienteTrabalho() {
        NOME_RESPONSAVEL_01_ = "Julio";
        NOME_RESPONSAVEL_02 = "Ana";
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
        LISTA_AMBIENTES_ACIMA_LIMITE = new ArrayList<>();
        LISTA_AMBIENTES_ACIMA_LIMITE.addAll(AMBIENTES_DE_TRABALHO);
        LISTA_AMBIENTES_ACIMA_LIMITE.add(AMBIENTE_TRAB_01);
        
    }

}
