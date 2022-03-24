package br.com.contmatic.test.model.fabricaobjetos;

import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.contato.Email;

public final class EmailFabricaObjetos {
    
    private EmailFabricaObjetos() {
        
    }
    
    public static String EMAIL_LITERAL_01;
    public static String EMAIL_LITERAL_02;
    public static String EMAIL_LITERAL_03;
    public static String EMAIL_LITERAL_04;
    public static Email EMAIL_01;
    public static Email EMAIL_02;
    public static Email EMAIL_03;
    public static Email EMAIL_04;
    public static List<Email> EMAILS;
    public static List<Email> LISTA_EMAILS_ACIMA_LIMITE;
    
    public static String EMAIL_SEM_ARROBA;
    public static String EMAIL_COM_ARROBA_INICIO;
    
    static void construirEmail() {
        EMAIL_LITERAL_01 = "henrique.araujo@contmatic.com.br";
        EMAIL_LITERAL_02 = "jessica.silva@contmatic.com.br";
        EMAIL_LITERAL_03 = "erich.miyamura@contmatic.com.br";
        EMAIL_LITERAL_04 = "contmatic@contmatic.com.br";
        EMAIL_01 = new Email(EMAIL_LITERAL_01);
        EMAIL_02 = new Email(EMAIL_LITERAL_01);
        EMAIL_03 = new Email(EMAIL_LITERAL_03);
        EMAIL_04 = new Email(EMAIL_LITERAL_04);
        EMAILS = new ArrayList<>();
        EMAILS.add(EMAIL_01);
        EMAILS.add(EMAIL_02);
        EMAILS.add(EMAIL_03);
        EMAILS.add(EMAIL_04);
        LISTA_EMAILS_ACIMA_LIMITE = new ArrayList<>();
        LISTA_EMAILS_ACIMA_LIMITE.addAll(EMAILS);
        LISTA_EMAILS_ACIMA_LIMITE.add(EMAIL_01);
        
        EMAIL_SEM_ARROBA = "emailcontmatic.com.br";
        EMAIL_COM_ARROBA_INICIO = "@contmatic.com.br";
    }

}
