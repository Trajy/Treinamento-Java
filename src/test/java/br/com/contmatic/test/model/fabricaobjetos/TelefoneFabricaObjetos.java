package br.com.contmatic.test.model.fabricaobjetos;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.contato.Telefone;

public final class TelefoneFabricaObjetos {
    
    private TelefoneFabricaObjetos() {
        
    }
    
    public static Integer DDI_01;
    public static Integer DDI_02;
    public static Integer DDD_01;
    public static Integer DDD_02;
    public static String NUMERO_TELEFONE_01;
    public static String NUMERO_TELEFONE_02;
    public static String NUMERO_TELEFONE_03;
    public static String NUMERO_TELEFONE_04;
    public static String NUMERO_TELEFONE_05;
    public static Telefone TELEFONE_01;
    public static Telefone TELEFONE_02;
    public static Telefone TELEFONE_03;
    public static Telefone TELEFONE_04;
    public static Telefone TELEFONE_05;
    public static Telefone TELEFONE_ATRIBUTOS_OBRIGATORIOS;
    public static Telefone TELEFONE_TODOS_ATRIBUTOS;
    public static List<Telefone> TELEFONES;
    public static List<Telefone> LISTA_TELEFONES_ACIMA_DO_LIMITE;
    
    public static Integer DDI_ACIMA_MAX_CHARS;
    public static Integer DDD_ABAIXO_MIN_CHARS;
    public static Integer DDD_ACIMA_MAX_CHARS;
    public static String NUMERO_TELEFONE_ACIMA_MAX_CHARS;
    public static String NUMERO_TELEFONE_ABAIXO_MIN_CHARS;
    
    
    static void construirTelefone() {
        DDI_01 = 55;
        DDI_02 = 99;
        DDD_01 = 11;
        DDD_02 = 67;
        NUMERO_TELEFONE_01 = "996300338";
        NUMERO_TELEFONE_02 = "940028922";
        NUMERO_TELEFONE_03 = "25569976";
        NUMERO_TELEFONE_04 = "976439802";
        NUMERO_TELEFONE_05 = "983749321";
        TELEFONE_01 = new Telefone(DDI_01 ,DDD_01, NUMERO_TELEFONE_01);
        TELEFONE_02 = new Telefone(DDI_02, DDD_02, NUMERO_TELEFONE_02);
        TELEFONE_03 = new Telefone(DDD_01, NUMERO_TELEFONE_03);
        TELEFONE_04 = new Telefone(DDD_01, NUMERO_TELEFONE_04);
        TELEFONE_05 = new Telefone(DDD_01, NUMERO_TELEFONE_05);
        TELEFONES = new ArrayList<>();
        TELEFONE_ATRIBUTOS_OBRIGATORIOS = new Telefone(DDD_01, NUMERO_TELEFONE_01);
        TELEFONE_TODOS_ATRIBUTOS = new Telefone(DDI_01, DDD_01, NUMERO_TELEFONE_01);
        TELEFONES.add(TELEFONE_01);
        TELEFONES.add(TELEFONE_02);
        TELEFONES.add(TELEFONE_03);
        TELEFONES.add(TELEFONE_04);
        TELEFONES.add(TELEFONE_05);
        LISTA_TELEFONES_ACIMA_DO_LIMITE = new ArrayList<>();
        LISTA_TELEFONES_ACIMA_DO_LIMITE.addAll(TELEFONES);
        LISTA_TELEFONES_ACIMA_DO_LIMITE.add(TELEFONE_01);
        
        DDI_ACIMA_MAX_CHARS = 1234;
        DDD_ABAIXO_MIN_CHARS = 1;
        DDD_ACIMA_MAX_CHARS = 1234;
        NUMERO_TELEFONE_ACIMA_MAX_CHARS = "1234567890";
        NUMERO_TELEFONE_ABAIXO_MIN_CHARS = "1234567";
    }
}
