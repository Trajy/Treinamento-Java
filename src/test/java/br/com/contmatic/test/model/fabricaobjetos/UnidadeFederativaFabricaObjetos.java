package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarNumerosAleatorios;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarLetrasAleatorias;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static java.lang.Integer.parseInt;
import br.com.contmatic.model.endereco.UnidadeFederativa;
import br.com.six2six.fixturefactory.Rule;

public class UnidadeFederativaFabricaObjetos {
    
    public static final Integer CODIGO_01;
    public static final Integer CODIGO_02;
    public static final String NOME_UF_01;
    public static final String NOME_UF_02;
    public static final String SIGLA_UF_01;
    public static final String SIGLA_UF_02;
    public static final UnidadeFederativa UF_01;
    public static final UnidadeFederativa UF_02;
    public static final UnidadeFederativa UF_ATRIBUTOS_OBRIGATORIOS;
    
    public static final UnidadeFederativa UF_TODOS_ATRIBUTOS;
    
    static {
        CODIGO_01 = 11;
        CODIGO_02 = 85;
        NOME_UF_01 = "Sao Paulo";
        NOME_UF_02 = "Mato Grosso";
        SIGLA_UF_01 = "SP";
        SIGLA_UF_02 = "MT";
        UF_01 = new UnidadeFederativa(CODIGO_01, NOME_UF_01, SIGLA_UF_01);
        UF_02 = new UnidadeFederativa(CODIGO_02, NOME_UF_02, SIGLA_UF_02);
        UF_ATRIBUTOS_OBRIGATORIOS = new UnidadeFederativa(CODIGO_01);
        
        Class<UnidadeFederativa> classe = UnidadeFederativa.class;
        fabricarUnidadesFederativas(classe);
        
        UF_TODOS_ATRIBUTOS = obterObjeto(classe, OBRIGATORIOS_ARGS);
    }
    
    static void construirUnidadeFederativa() {
       
    }
    
    private static void fabricarUnidadesFederativas(Class classe) {
        
        fabricarObjeto(classe, TODOS_ARGS, new Rule() {{
            add("codigo", gerarCodigo());
            add("nome", gerarNome());
            add("sigla", gerarSigla());
        }});
        
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("codigo", gerarCodigo());
        }});
    }

    private static Integer gerarCodigo() {
        final int TAMANHO_CODIGO = 2;
        return parseInt(gerarNumerosAleatorios(TAMANHO_CODIGO));
    }
    
    private static String gerarNome() {
        final int ESTADO_TAMANHO_MIN = 2;
        final int ESTADO_TAMANHO_MAX = 15;
        return gerarLetrasAleatorias(ESTADO_TAMANHO_MIN, ESTADO_TAMANHO_MAX);
    }
    
    private static String gerarSigla() {
        final int SIGLA_TAMANHO = 2;
        return gerarLetrasAleatorias(SIGLA_TAMANHO);
    }

}
