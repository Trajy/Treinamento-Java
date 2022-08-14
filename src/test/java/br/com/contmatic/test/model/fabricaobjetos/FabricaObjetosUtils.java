package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.six2six.bfgex.RandomGen.firstName;
import static br.com.six2six.bfgex.RandomGen.pickRange;
import static br.com.six2six.bfgex.RandomGen.word;
import static br.com.six2six.bfgex.RegexGen.of;

import java.util.List;

import org.apache.commons.lang.math.NumberRange;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public final class FabricaObjetosUtils {
    
    private FabricaObjetosUtils() { }
    
    public static final Integer INDICE_01 = 0;
    
    public static final Integer INDICE_02 = 1;
    
    public static <T> void fabricarObjeto(Class<T> classe, ObjetoFixtureTemplate template, Rule rule) {
        Fixture.of(classe).addTemplate(template.name(), rule);
    }
    
    public static <T> T obterObjeto(Class<T> classe, ObjetoFixtureTemplate template) {
        return Fixture.from(classe).gimme(template.name());
    }
    
    public static <T> List<T> obterVariosObjetos(Class<T> classe, ObjetoFixtureTemplate template, Integer quantidade) {
        return Fixture.from(classe).gimme(quantidade, template.name());
    }
    
    public static String gerarNumerosAleatorios(Integer tamanho) {
        return of(new StringBuilder("[0-9]{")
            .append(tamanho)
            .append("}")
            .toString());
    }
    
    public static String gerarNumerosAleatorios(Integer tamanhoMinimo, Integer tamanhoMaximo) {
         return of(new StringBuilder("[0-9]{")
             .append(tamanhoMinimo)
             .append(",")
             .append(tamanhoMaximo)
             .append("}")
             .toString());
    }
    
    public static String gerarLetrasAleatorias() {
        final int COMUM_MIN = 2;
        final int COMUM_MAX = 70;
        return gerarLetrasAleatorias(COMUM_MIN, COMUM_MAX);
    }
    
    public static String gerarLetrasAleatorias(Integer tamanho) {
        String palavraAleatoria = "";
        do {
            palavraAleatoria =  word(tamanho).replaceAll("[^A-Za-zá-úÁ-Ú., ]", "");
        } while (palavraAleatoria.length() < tamanho);
        return palavraAleatoria;
    }
    
    public static String gerarLetrasAleatorias(Integer tamanhoMinimo, Integer tamanhoMaximo) {
        String palavraAleatoria = "";
        do {
            palavraAleatoria =  word(
                pickRange(
                    new NumberRange(tamanhoMinimo, tamanhoMaximo)
                ).intValue()
            ).replaceAll("[^A-Za-zá-úÁ-Ú., ]", "");
        } while (palavraAleatoria.length() < tamanhoMinimo);
        return palavraAleatoria; 
    }
    
    public static String gerarLetrasComTamanhoPadraoEndereco() {
        final int TAMANHO_MIN_PADRAO_ENDERECO = 2;
        final int TAMANHO_MAX_PADRAO_ENDEROCO = 25;
        return gerarLetrasAleatorias(TAMANHO_MIN_PADRAO_ENDERECO, TAMANHO_MAX_PADRAO_ENDEROCO);
    }
    
    public static String gerarNomeAleatorio() {
        return firstName();
    }
    
    public static String gerarAPartirRegex(String regex) {
        return of(regex);
    }
}
