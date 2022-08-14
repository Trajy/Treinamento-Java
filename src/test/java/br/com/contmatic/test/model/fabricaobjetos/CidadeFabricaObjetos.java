package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarLetrasComTamanhoPadraoEndereco;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.UnidadeFederativaFabricaObjetos.UF_TODOS_ATRIBUTOS;

import java.util.List;

import br.com.contmatic.model.endereco.Cidade;
import br.com.six2six.fixturefactory.Rule;

public final class CidadeFabricaObjetos {
    
    private CidadeFabricaObjetos() { }
    
    public static final Cidade CIDADE_TODOS_ARTRIBUTOS;
    public static final List<Cidade> CIDADES_IGUAIS_TODOS_ATRIBUTOS;
    
    static {
        Class<Cidade> classe = Cidade.class;
        fabricarCidades(classe);
        
        final int QTD_CIDADES_IGUAIS = 2;
        CIDADE_TODOS_ARTRIBUTOS = obterObjeto(classe, OBRIGATORIOS_ARGS);
        CIDADES_IGUAIS_TODOS_ATRIBUTOS = obterVariosObjetos(classe, OBRIGATORIOS_ARGS, QTD_CIDADES_IGUAIS);
    }
    
    private static void fabricarCidades(Class classe) {
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("nome", gerarLetrasComTamanhoPadraoEndereco());            
            add("uf", UF_TODOS_ATRIBUTOS);
            add("pais", gerarLetrasComTamanhoPadraoEndereco());
        }});
    }

}
