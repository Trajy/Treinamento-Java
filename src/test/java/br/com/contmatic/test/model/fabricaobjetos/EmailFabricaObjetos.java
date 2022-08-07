package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.six2six.bfgex.RandomGen.email;
import static br.com.six2six.bfgex.RandomGen.firstName;

import java.util.List;

import br.com.contmatic.model.contato.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public final class EmailFabricaObjetos {
    
    public static final Integer TAMANHO_MAX_EMAIL;
    public static final Integer TAMANHO_COMUM_EMAIL;
    public static final Integer QTD_MAX_EMAILS;
    public static final Integer ACIMA_LIMITE_EMAILS;
    public static final String DOMINIO_CONTMATIC;
    public static final String EMAIL_SEM_ARROBA;
    public static final String EMAIL_COM_ARROBA_INICIO;
    public static final Integer QTD_EMAILS_IGUAIS;
    public static final Integer INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01;
    public static final Integer INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02;
    public static Email EMAIL_TODOS_ARGS;
    public static List<Email> EMAILS_IGUAIS_ARGS_OBRIGATORIOS;
    
    private EmailFabricaObjetos() {
        
    }
    
    static {
        fabricarEmails();
        
        TAMANHO_MAX_EMAIL = 40;
        TAMANHO_COMUM_EMAIL = 25;
        QTD_MAX_EMAILS = 4;
        ACIMA_LIMITE_EMAILS = QTD_MAX_EMAILS + 1;
        DOMINIO_CONTMATIC = "contmatic.com.br";
        EMAIL_SEM_ARROBA = new StringBuilder(firstName()).append(DOMINIO_CONTMATIC).toString();
        EMAIL_COM_ARROBA_INICIO = new StringBuilder("@").append(DOMINIO_CONTMATIC).toString();
        QTD_EMAILS_IGUAIS = 2;
        INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01 = 0;
        INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02 = 1;
        EMAIL_TODOS_ARGS = Fixture.from(Email.class).gimme("todosArgs");
        EMAILS_IGUAIS_ARGS_OBRIGATORIOS = getEmailsIguais(QTD_EMAILS_IGUAIS);
        
    }
    
    private static void fabricarEmails() {
        Fixture.of(Email.class).addTemplate("obrigatoriosArgs", new Rule() {{
            add("enderecoEmail", email(TAMANHO_MAX_EMAIL, "contmatic.com.br"));
        }});
        
        Fixture.of(Email.class).addTemplate("todosArgs", new Rule() {{
            add("enderecoEmail", email(TAMANHO_COMUM_EMAIL, "contmatic.com.br"));
        }});
    }
    
    private static List<Email> getEmailsIguais(Integer quantidade){
        return Fixture.from(Email.class).gimme(quantidade, "obrigatoriosArgs");
    }

}
