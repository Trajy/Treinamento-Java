package br.com.contmatic.test.model.fabricaobjetos;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.six2six.fixturefactory.base.Range;
import br.com.six2six.fixturefactory.function.impl.RandomFunction;

public final class ComumErroFabricaObjetos {
    
    private ComumErroFabricaObjetos() {
        
    }
    
    public static int MAX_CHARS_GERAL_TAMANHO;
    public static int MIN_CHARS_GERAL_TAMANHO;
    public static LocalDate DATA_FUTURO;
    public static LocalDate DATA_MENOR_IDADE;
    public static String VAZIO;
    public static String SOMENTE_ESPACOS;
    public static String TEXTO_COM_CHAR_NAO_ALFANUMERICO;
    public static String LITERAL_NUMERICO_COM_10_CHARS;
    public static String MAX_CHARS_GERAL;
    public static String MIN_CHARS_GERAL;
    public static String NUMEROS_COM_LETRA_LITERAL;
    public static String TEXTO_COM_CHAR_NUMERICO;
    public static String TEXTO_COM_1_CHAR;
    public static List LISTA_NULA;
    public static List LISTA_VAZIA;
    
    static {     
        MAX_CHARS_GERAL_TAMANHO = 71;
        MIN_CHARS_GERAL_TAMANHO = 1;
        DATA_FUTURO = LocalDate.now().plusDays(new RandomFunction(Long.class, new Range(1l, 10l)).generateValue());
        DATA_MENOR_IDADE = LocalDate.now().minusYears(new RandomFunction(Long.class, new Range(1l, 18l)).generateValue());
        VAZIO = "";
        SOMENTE_ESPACOS = "      ";
        TEXTO_COM_CHAR_NAO_ALFANUMERICO = "123abcΩω";
        LITERAL_NUMERICO_COM_10_CHARS = "1456734876";
        MAX_CHARS_GERAL = randomAlphabetic(MAX_CHARS_GERAL_TAMANHO);
        MIN_CHARS_GERAL = randomAlphabetic(MIN_CHARS_GERAL_TAMANHO);
        NUMEROS_COM_LETRA_LITERAL = "1234a56";
        TEXTO_COM_CHAR_NUMERICO = "text0 com num3r0";
        TEXTO_COM_1_CHAR = "a";
        LISTA_NULA = null;
        LISTA_VAZIA = new ArrayList<>();
    }

}
