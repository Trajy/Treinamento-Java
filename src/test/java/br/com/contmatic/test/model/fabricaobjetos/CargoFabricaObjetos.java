package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.empresa.Cargo;
import br.com.contmatic.model.empresa.Empresa;
import br.com.six2six.fixturefactory.Rule;

public final class CargoFabricaObjetos<T> {
    
    private CargoFabricaObjetos() {
        
    }
    
    public static String CBO_01;
    public static String CBO_02;
    public static String CBO_03;
    public static String CBO_04;
    public static String NOME_CARGO_01;
    public static String NOME_CARGO_02;
    public static String DESCRICAO_CARGO_01;
    public static String DESCRICAO_CARGO_02;
    public static Cargo CARGO_01;
    public static Cargo CARGO_02;
    public static Cargo CARGO_03;
    public static Cargo CARGO_04;
    public static List<Cargo> CARGOS;
    public static List<Cargo> LISTA_CARGOS_ACIMA_LIMITE;
    
    
    
    static void construirCargo() { 
        CBO_01 = "85748394";
        CBO_02 = "83758292";
        CBO_03 = "09876543";
        CBO_04 = "56473829";
        NOME_CARGO_01 = "programador";
        NOME_CARGO_02 = "analista de QA";
        DESCRICAO_CARGO_01 = "desenvolvimento de software";
        DESCRICAO_CARGO_02 = "garantir a qualidade de software e metodologias de testes";
        
        String REGEX_GERAR_CBO = "[0-9]{2,3}";
        
        Class<Cargo> classe = Cargo.class;
        /*
        fabricarObjeto(classe, TODOS_ARGS, new Rule() {{
            add("cbo", );
            add("nome", );
            add("descricao", );
            add("empresa", );
        }});
        
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("cbo", );
        }});*/
        
        CARGO_01 = new Cargo(CBO_01, NOME_CARGO_01, DESCRICAO_CARGO_01);
        CARGO_02 = new Cargo(CBO_02, NOME_CARGO_02, DESCRICAO_CARGO_02);
        CARGO_03 = new Cargo(CBO_03);
        CARGO_04 = new Cargo(CBO_01);
        CARGOS = new ArrayList<>();
        CARGOS.add(CARGO_01);
        CARGOS.add(CARGO_02);
        CARGOS.add(CARGO_03);
        CARGOS.add(CARGO_04);
        LISTA_CARGOS_ACIMA_LIMITE = new ArrayList<>();
        LISTA_CARGOS_ACIMA_LIMITE.addAll(CARGOS);
        LISTA_CARGOS_ACIMA_LIMITE.add(CARGO_01);
        
    }
    
    
}
