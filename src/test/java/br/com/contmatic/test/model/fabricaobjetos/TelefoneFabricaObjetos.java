package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;
import static br.com.six2six.bfgex.RegexGen.of;
import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.contato.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public final class TelefoneFabricaObjetos {
    
    private TelefoneFabricaObjetos() {
        
    }
    
    public static String DDI_DDD_EXPRESSAO_REGULAR;
    public static String NUMERO_TELEFONE_EXPRESSAO_REGULAR;
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
    public static Integer INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_01;
    public static Integer INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_02;
    public static Telefone TELEFONE_TODOS_ATRIBUTOS;
    public static List<Telefone> TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
    public static List<Telefone> TELEFONES;
    public static List<Telefone> LISTA_TELEFONES_ACIMA_DO_LIMITE;
    
    public static Integer DDI_ACIMA_MAX_CHARS;
    public static Integer DDD_ABAIXO_MIN_CHARS;
    public static Integer DDD_ACIMA_MAX_CHARS;
    public static String NUMERO_TELEFONE_ACIMA_MAX_CHARS;
    public static String NUMERO_TELEFONE_ABAIXO_MIN_CHARS;
    
    static {
        atribuirDados();
        atribuirValidacoes();
        fabricarTelefones();
        atribuirTelefones();
    }
    
    static void construirTelefone() {
        
    }
    
    private static void atribuirDados() {
        DDI_01 = 55;
        DDI_02 = 99;
        DDD_01 = 11;
        DDD_02 = 67;
        NUMERO_TELEFONE_01 = "996300338";
        NUMERO_TELEFONE_02 = "940028922";
        NUMERO_TELEFONE_03 = "25569976";
        NUMERO_TELEFONE_04 = "976439802";
        NUMERO_TELEFONE_05 = "983749321";
        
        DDI_ACIMA_MAX_CHARS = 1234;
        DDD_ABAIXO_MIN_CHARS = 1;
        DDD_ACIMA_MAX_CHARS = 1234;
        NUMERO_TELEFONE_ACIMA_MAX_CHARS = "1234567890";
        NUMERO_TELEFONE_ABAIXO_MIN_CHARS = "1234567";
    }
    
    private static void atribuirValidacoes() {
        DDI_DDD_EXPRESSAO_REGULAR = "[0-9]{2,3}";
        NUMERO_TELEFONE_EXPRESSAO_REGULAR = "[0-9]{8,9}";
    }
    
    private static void fabricarTelefones() {
        fabricarObjeto(Telefone.class, TODOS_ARGS, new Rule() {{
            add("ddi", parseInt(of(DDI_DDD_EXPRESSAO_REGULAR)));
            add("ddd", parseInt(of(DDI_DDD_EXPRESSAO_REGULAR)));
            add("numero", of(NUMERO_TELEFONE_EXPRESSAO_REGULAR));
        }});
        
        fabricarObjeto(Telefone.class, OBRIGATORIOS_ARGS, ew Rule() {{
            add("ddd", parseInt(of(DDI_DDD_EXPRESSAO_REGULAR)));
            add("numero", of(NUMERO_TELEFONE_EXPRESSAO_REGULAR));
        }});
    }
    
    private static void atribuirTelefones() {
        final int QTD_INSTANCIAS_IGUAIS = 2;
        INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_01 = 0;
        INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_02 = 1;
        TELEFONE_TODOS_ATRIBUTOS = obterObjeto(Telefone.class, TODOS_ARGS);
        TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS = Fixture.from(Telefone.class).gimme(QTD_INSTANCIAS_IGUAIS, OBRIGATORIOS_ARGS.name());
        
        TELEFONE_01 = new Telefone(DDI_01 ,DDD_01, NUMERO_TELEFONE_01);
        TELEFONE_02 = new Telefone(DDI_02, DDD_02, NUMERO_TELEFONE_02);
        TELEFONE_03 = new Telefone(DDD_01, NUMERO_TELEFONE_03);
        TELEFONE_04 = new Telefone(DDD_01, NUMERO_TELEFONE_04);
        TELEFONE_05 = new Telefone(DDD_01, NUMERO_TELEFONE_05);
        TELEFONES = new ArrayList<>();
        TELEFONE_ATRIBUTOS_OBRIGATORIOS = new Telefone(DDD_01, NUMERO_TELEFONE_01);
        TELEFONES.add(TELEFONE_01);
        TELEFONES.add(TELEFONE_02);
        TELEFONES.add(TELEFONE_03);
        TELEFONES.add(TELEFONE_04);
        TELEFONES.add(TELEFONE_05);
        LISTA_TELEFONES_ACIMA_DO_LIMITE = new ArrayList<>();
        LISTA_TELEFONES_ACIMA_DO_LIMITE.addAll(TELEFONES);
        LISTA_TELEFONES_ACIMA_DO_LIMITE.add(TELEFONE_01);  
    }
}
