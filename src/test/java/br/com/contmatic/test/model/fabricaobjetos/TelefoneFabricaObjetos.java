package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.gerarDDDOuDDI;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.gerarTelefone;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.contato.Telefone;
import br.com.six2six.fixturefactory.Rule;

public final class TelefoneFabricaObjetos {
    
    private TelefoneFabricaObjetos() {
        
    }
    
    public static final Integer DDI_01;
    public static final Integer DDI_02;
    public static final Integer DDD_01;
    public static final Integer DDD_02;
    public static final String NUMERO_TELEFONE_01;
    public static final String NUMERO_TELEFONE_02;
    public static final String NUMERO_TELEFONE_03;
    public static final String NUMERO_TELEFONE_04;
    public static final String NUMERO_TELEFONE_05;
    public static final Telefone TELEFONE_01;
    public static final Telefone TELEFONE_02;
    public static final Telefone TELEFONE_03;
    public static final Telefone TELEFONE_04;
    public static final Telefone TELEFONE_05;
    public static final Telefone TELEFONE_ATRIBUTOS_OBRIGATORIOS;
    public static final Integer INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_01;
    public static final Integer INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_02;
    public static final Telefone TELEFONE_TODOS_ATRIBUTOS;
    public static final List<Telefone> TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
    public static final List<Telefone> TELEFONES;
    public static final List<Telefone> LISTA_TELEFONES_ACIMA_DO_LIMITE;
    
    public static final Integer DDI_ACIMA_MAX_CHARS;
    public static final Integer DDD_ABAIXO_MIN_CHARS;
    public static final Integer DDD_ACIMA_MAX_CHARS;
    public static final String NUMERO_TELEFONE_ACIMA_MAX_CHARS;
    public static final String NUMERO_TELEFONE_ABAIXO_MIN_CHARS;
    
    static {
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
        
        Class<Telefone> classe = Telefone.class;
        
        fabricarObjeto(classe, TODOS_ARGS, new Rule() {{
            add("ddi", gerarDDDOuDDI());
            add("ddd", gerarTelefone());
            add("numero", gerarTelefone());
        }});
        
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("ddd", gerarDDDOuDDI());
            add("numero", gerarTelefone());
        }});
        
        final int QTD_INSTANCIAS_IGUAIS = 2;
        INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_01 = 0;
        INDICE_TELEFONE_ATRIBUTOS_OBRIGATORIOS_02 = 1;
        TELEFONE_TODOS_ATRIBUTOS = obterObjeto(classe, TODOS_ARGS);
        TELEFONES_IGUAIS_ATRIBUTOS_OBRIGATORIOS = obterVariosObjetos(classe, TODOS_ARGS, QTD_INSTANCIAS_IGUAIS);
        
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
    
    static void construirTelefone() {
        
    }
}
