package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.six2six.bfgex.RandomGen.email;
import static br.com.six2six.bfgex.RegexGen.of;
import static java.lang.Integer.parseInt;

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
    
    public static String gerarEmail(Integer tamanho, String dominio) {
        return email(tamanho, dominio);
    }
    
    public static Integer gerarDddOuDdi() {
        final String DDI_DDD_EXPRESSAO_REGULAR = "[0-9]{2,3}";
        return parseInt(of(DDI_DDD_EXPRESSAO_REGULAR));
        
    }
    
    public static String gerarTelefone() {
        final String NUMERO_TELEFONE_EXPRESSAO_REGULAR = "[0-9]{8,9}";
        return of(NUMERO_TELEFONE_EXPRESSAO_REGULAR);
    }
    
    
    
    
    
}
