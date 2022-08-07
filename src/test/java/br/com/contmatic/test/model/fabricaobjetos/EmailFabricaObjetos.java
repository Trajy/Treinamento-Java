package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.six2six.bfgex.RandomGen.email;
import static br.com.six2six.bfgex.RandomGen.firstName;

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
    
    private EmailFabricaObjetos() {
        
    }
    
    static {
        TAMANHO_MAX_EMAIL = 40;
        TAMANHO_COMUM_EMAIL = 25;
        QTD_MAX_EMAILS = 4;
        ACIMA_LIMITE_EMAILS = QTD_MAX_EMAILS + 1;
        DOMINIO_CONTMATIC = "contmatic.com.br";
        EMAIL_SEM_ARROBA = new StringBuilder(firstName()).append(DOMINIO_CONTMATIC).toString();
        EMAIL_COM_ARROBA_INICIO = new StringBuilder("@").append(DOMINIO_CONTMATIC).toString();
    }
    
    public static void construirEmails() {
        Fixture.of(Email.class).addTemplate("obrigatoriosArgs", new Rule() {{
            add("enderecoEmail", email(TAMANHO_MAX_EMAIL, "contmatic.com.br"));
        }});
        
        Fixture.of(Email.class).addTemplate("todosArgs", new Rule() {{
            add("enderecoEmail", email(TAMANHO_COMUM_EMAIL, "contmatic.com.br"));
        }});
    }
    
    public static List<Email> getEmailsIguais(Integer quantidade){
        List<Email> lista = Fixture.from(Email.class).gimme(quantidade, "obrigatoriosArgs");
        lista.forEach(x -> x.setEmail(lista.get(0).getEmail()));
        return lista;
    }

}
