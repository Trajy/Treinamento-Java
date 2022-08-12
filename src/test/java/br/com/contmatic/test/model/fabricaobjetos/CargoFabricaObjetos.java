package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarLetrasAleatorias;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarNumerosAleatorios;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.empresa.Cargo;
import br.com.contmatic.model.empresa.Empresa;
import br.com.six2six.fixturefactory.Rule;

public final class CargoFabricaObjetos<T> {
    
    private CargoFabricaObjetos() {
        
    }
    
    public static final String CBO_01;
    public static final String CBO_02;
    public static final String CBO_03;
    public static final String CBO_04;
    public static final String NOME_CARGO_01;
    public static final String NOME_CARGO_02;
    public static final String DESCRICAO_CARGO_01;
    public static final String DESCRICAO_CARGO_02;
    public static final Cargo CARGO_01;
    public static final Cargo CARGO_02;
    public static final Cargo CARGO_03;
    public static final Cargo CARGO_04;
    public static final List<Cargo> CARGOS;
    public static final List<Cargo> LISTA_CARGOS_ACIMA_LIMITE;
    public static final Integer INDICE_01;
    public static final Integer INDICE_02;
    public static final Cargo CARGO_TODOS_ATRIBUDOS;
    public static final List<Cargo> CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
    
    static {
        CBO_01 = "85748394";
        CBO_02 = "83758292";
        CBO_03 = "09876543";
        CBO_04 = "56473829";
        NOME_CARGO_01 = "programador";
        NOME_CARGO_02 = "analista de QA";
        DESCRICAO_CARGO_01 = "desenvolvimento de software";
        DESCRICAO_CARGO_02 = "garantir a qualidade de software e metodologias de testes";
        
        Class<Cargo> classe = Cargo.class;
        fabricarCargos(classe);
        
        final int QUANTIDADE_CARGOS_IGUAIS = 2;
        INDICE_01 = 0;
        INDICE_02 = 1;
        CARGO_TODOS_ATRIBUDOS = obterObjeto(classe, TODOS_ARGS);
        CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS = obterVariosObjetos(classe, OBRIGATORIOS_ARGS, QUANTIDADE_CARGOS_IGUAIS);
        
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
    
    static void construirCargo() { 
    
    }
    
    public static void fabricarCargos(Class classe) {   
        fabricarObjeto(classe, TODOS_ARGS, new Rule() {{
            add("cbo", gerarCbo());
            add("nome", gerarCharsAleatorios());
            add("descricao", gerarCharsAleatorios());
            add("empresa", new Empresa("11222333000181"));
        }});
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("cbo", gerarCbo());
        }});     
    }
    
    public static String gerarCbo() {
        final int TAMANHO_MIN_CBO = 4;
        final int TAMANHO_MAX_CBO = 8;
        return gerarNumerosAleatorios(TAMANHO_MIN_CBO, TAMANHO_MAX_CBO);
    }
    
    public static String gerarCharsAleatorios() {
        final int COMUM_MIN = 2;
        final int COMUM_MAX = 70;
        return gerarLetrasAleatorias(COMUM_MIN, COMUM_MAX);
    }
    
}
