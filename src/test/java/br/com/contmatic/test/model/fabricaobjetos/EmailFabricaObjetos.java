package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.six2six.bfgex.RandomGen.email;
import static br.com.six2six.bfgex.RandomGen.firstName;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;

import java.util.List;

import br.com.contmatic.model.contato.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public final class EmailFabricaObjetos {
    
    public static Integer TAMANHO_MAX_EMAIL;
    public static Integer TAMANHO_COMUM_EMAIL;
    public static Integer QTD_MAX_EMAILS;
    public static Integer ACIMA_LIMITE_EMAILS;
    public static String DOMINIO_CONTMATIC;
    public static String EMAIL_SEM_ARROBA;
    public static String EMAIL_COM_ARROBA_INICIO;
    public static Integer QTD_EMAILS_IGUAIS;
    public static Integer INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01;
    public static Integer INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02;
    public static Email EMAIL_TODOS_ARGS;
    public static List<Email> EMAILS_IGUAIS_ARGS_OBRIGATORIOS;
    
    private EmailFabricaObjetos() {
        
    }
    
    static {
        atribuirDados();
        atribuirValidacoes();         
        fabricarEmails();
        atribuirEmails();
    }
    
    private static void atribuirDados() {
        DOMINIO_CONTMATIC = "contmatic.com.br";
        EMAIL_SEM_ARROBA = new StringBuilder(firstName()).append(DOMINIO_CONTMATIC).toString();
        EMAIL_COM_ARROBA_INICIO = new StringBuilder("@").append(DOMINIO_CONTMATIC).toString();
    }
    
    private static void atribuirValidacoes() {
        TAMANHO_MAX_EMAIL = 40;
        TAMANHO_COMUM_EMAIL = 25;
        QTD_MAX_EMAILS = 4;
        ACIMA_LIMITE_EMAILS = QTD_MAX_EMAILS + 1;
    }
    
    private static void fabricarEmails() {
        Fixture.of(Email.class).addTemplate(OBRIGATORIOS_ARGS.name(), new Rule() {{
            add("enderecoEmail", email(TAMANHO_MAX_EMAIL, DOMINIO_CONTMATIC));
        }});
        
        Fixture.of(Email.class).addTemplate(TODOS_ARGS.name(), new Rule() {{
            add("enderecoEmail", email(TAMANHO_COMUM_EMAIL, DOMINIO_CONTMATIC));
        }});
    }
    
    private static void atribuirEmails() {
        QTD_EMAILS_IGUAIS = 2;
        INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01 = 0;
        INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02 = 1;
        EMAIL_TODOS_ARGS = Fixture.from(Email.class).gimme(TODOS_ARGS.name());
        EMAILS_IGUAIS_ARGS_OBRIGATORIOS = Fixture.from(Email.class).gimme(QTD_EMAILS_IGUAIS, OBRIGATORIOS_ARGS.name());
    }
    
    
}
