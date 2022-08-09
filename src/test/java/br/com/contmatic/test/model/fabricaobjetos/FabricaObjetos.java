package br.com.contmatic.test.model.fabricaobjetos;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public final class FabricaObjetos {
    
    private FabricaObjetos() { }
    
    public static <T> void fabricarObjeto(Class<T> classe, ObjetoFixtureTemplate template, Rule rule) {
        Fixture.of(classe).addTemplate(template.name(), rule);
    }
    
    public static <T> T obterObjeto(Class<T> classe, ObjetoFixtureTemplate template) {
        return Fixture.from(classe).gimme(template.name());
    }
    
    public static <T> List<T> obterVariosObjetos(Class<T> classe, ObjetoFixtureTemplate template, Integer quantidade) {
        return Fixture.from(classe).gimme(quantidade, template.name());
    }
    
    
    
}
