package br.com.contmatic.test.model.fabricaobjetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class ComumErroFabricaObjetos {
    
    private ComumErroFabricaObjetos() {
        
    }
    
    
    
    public static LocalDate DATA_FUTURO;
    public static LocalDate DATA_MENOR_IDADE;
    public static String NULO;
    public static String VAZIO;
    public static String SOMENTE_ESPACOS;
    public static String TEXTO_COM_CHAR_NAO_ALFANUMERICO;
    public static String LITERAL_NUMERICO_COM_10_CHARS;
    public static String TEXTO_COM_71_CHARS;
    public static String TEXTO_COM_1_CHAR;
    public static String NUMEROS_COM_LETRA_LITERAL;
    public static String TEXTO_COM_CHAR_NUMERICO;
    public static List LISTA_NULA;
    public static List LISTA_VAZIA;
    
    static void construirComumErro() {
        
        
        DATA_FUTURO = LocalDate.of(2025, 06, 15);
        DATA_MENOR_IDADE = LocalDate.of(2020, 06, 15);
        
        NULO = null;
        
        
        VAZIO = "";
        SOMENTE_ESPACOS = "      ";
        TEXTO_COM_CHAR_NAO_ALFANUMERICO = "123abcΩω";
        LITERAL_NUMERICO_COM_10_CHARS = "1456734876";
        TEXTO_COM_71_CHARS = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ1234567890123456789";
        TEXTO_COM_1_CHAR = "a";
        NUMEROS_COM_LETRA_LITERAL = "587a00";
        TEXTO_COM_CHAR_NUMERICO = "text0 com num3r0";
        LISTA_NULA = null;
        LISTA_VAZIA = new ArrayList<>();
    }

}
