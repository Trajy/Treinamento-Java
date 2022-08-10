package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_01;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_02;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.gerarLetrasAleatorias;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.gerarNomeAleatorio;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.empresa.AmbienteTrabalho;
import br.com.contmatic.model.empresa.Empresa;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

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
    public static Integer QTD_AMBIENTES_TRAB_ACIMA_LIMITE;
    public static Integer INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_01;
    public static Integer INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_02;
    public static AmbienteTrabalho AMBIENTE_TRAB_TODOS_ARGUMENTOS;
    public static List<AmbienteTrabalho> AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
    public static AmbienteTrabalho AMBIENTE_TRAB_01;
    public static AmbienteTrabalho AMBIENTE_TRAB_02;
    public static AmbienteTrabalho AMBIENTE_TRAB_03;
    public static List<AmbienteTrabalho> AMBIENTES_DE_TRABALHO;
    public static List<AmbienteTrabalho> LISTA_AMBIENTES_ACIMA_LIMITE;
    
    static {
        atribuirDados();
        atribuirValidacoes();
        fabricarAmbientesTrabalho();
        atribuirAmbientesTrabalho();
    }
    
    static void construirAmbienteTrabalho() { 
        
    }
    
    private static void atribuirDados() {
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
    }
    
    private static void atribuirValidacoes() {
        
    }
    
    private static void fabricarAmbientesTrabalho() {
        Fixture.of(AmbienteTrabalho.class).addTemplate(TODOS_ARGS.name(), new Rule() {{ 
            add("nome", gerarLetrasAleatorias());
            add("tipoEstabelecimento", gerarLetrasAleatorias());
            add("endereco", ENDERECO_01);
            add("responsavel", gerarNomeAleatorio());
            add("descricao", gerarLetrasAleatorias());
            add("empresa", new Empresa("11222333000181")); 
        }});
        
        Fixture.of(AmbienteTrabalho.class).addTemplate(OBRIGATORIOS_ARGS.name(), new Rule() {{ 
            add("nome", gerarLetrasAleatorias());
            add("responsavel", gerarNomeAleatorio());
        }});
    }
    
    
    
    private static void atribuirAmbientesTrabalho() {
        final int QTD_AMBIENTES_TRAB_IGUAIS = 2;
        INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_01 = 0;
        INDICE_AMBIENTE_TRABALHO_ATRIBUTOS_OBRIGATORIOS_02 = 1;
        QTD_AMBIENTES_TRAB_ACIMA_LIMITE = 6;
        AMBIENTE_TRAB_TODOS_ARGUMENTOS = Fixture.from(AmbienteTrabalho.class).gimme(TODOS_ARGS.name());
        AMBIENTES_TRAB_IGUAIS_ATRIBUTOS_OBRIGATORIOS = Fixture.from(AmbienteTrabalho.class).gimme(QTD_AMBIENTES_TRAB_IGUAIS ,OBRIGATORIOS_ARGS.name());
        LISTA_AMBIENTES_ACIMA_LIMITE = Fixture.from(AmbienteTrabalho.class).gimme(QTD_AMBIENTES_TRAB_ACIMA_LIMITE, OBRIGATORIOS_ARGS.name());
        
        AMBIENTE_TRAB_01 = new AmbienteTrabalho(NOME_AMBINETE_TRAB_01, TIPO_AMBIENTE_TRAB_PROPRIO, ENDERECO_01, NOME_RESPONSAVEL_AMBIENTE, DESC_AMBIENTE);
        AMBIENTE_TRAB_02 = new AmbienteTrabalho(NOME_AMBIENTE_TRAB_02, TIPO_AMBIENTE_TRAB_PROPRIO);
        AMBIENTE_TRAB_03 = new AmbienteTrabalho(NOME_AMBINETE_TRAB_01, TIPO_AMBIENTE_TRAB_TERCEIROS, ENDERECO_02, NOME_RESPONSAVEL_AMBIENTE, DESC_AMBIENTE_02);
        AMBIENTES_DE_TRABALHO = new ArrayList<>();
        AMBIENTES_DE_TRABALHO.add(AMBIENTE_TRAB_01);
        AMBIENTES_DE_TRABALHO.add(AMBIENTE_TRAB_02);
    }
    
    
}
