package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;
import static br.com.six2six.bfgex.RandomGen.email;
import static br.com.six2six.bfgex.RandomGen.firstName;

import java.util.List;

import br.com.contmatic.model.contato.CorreioEletronico;
import br.com.six2six.fixturefactory.Rule;

public final class EmailFabricaObjetos {
    
    public static final Integer TAMANHO_MAX_EMAIL;
    public static final Integer TAMANHO_COMUM_EMAIL;
    public static final Integer QTD_MAX_EMAILS;
    public static final Integer ACIMA_LIMITE_EMAILS;
    public static final String DOMINIO_CONTMATIC;
    public static final String EMAIL_SEM_ARROBA;
    public static final String EMAIL_COM_ARROBA_INICIO;
    public static final Integer INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01;
    public static final Integer INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02;
    public static final CorreioEletronico EMAIL_TODOS_ARGS;
    public static final List<CorreioEletronico> EMAILS_IGUAIS_ARGS_OBRIGATORIOS;
    
    private EmailFabricaObjetos() {
        
    }
    
    static {
        DOMINIO_CONTMATIC = "contmatic.com.br";
        EMAIL_SEM_ARROBA = new StringBuilder(firstName()).append(DOMINIO_CONTMATIC).toString();
        EMAIL_COM_ARROBA_INICIO = new StringBuilder("@").append(DOMINIO_CONTMATIC).toString();
        TAMANHO_MAX_EMAIL = 40;
        TAMANHO_COMUM_EMAIL = 25;
        QTD_MAX_EMAILS = 4;
        ACIMA_LIMITE_EMAILS = QTD_MAX_EMAILS + 1;
        
        fabricarEmails();
        
        final int QTD_EMAILS_IGUAIS = 2;
        INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01 = 0;
        INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02 = 1;
        EMAIL_TODOS_ARGS = obterObjeto(CorreioEletronico.class, TODOS_ARGS);
        EMAILS_IGUAIS_ARGS_OBRIGATORIOS = obterVariosObjetos(CorreioEletronico.class, OBRIGATORIOS_ARGS, QTD_EMAILS_IGUAIS);
    }
    
    public static void fabricarEmails() {
        fabricarObjeto(CorreioEletronico.class, OBRIGATORIOS_ARGS, new Rule() {{
            add("endereco", gerarEmail(TAMANHO_MAX_EMAIL, DOMINIO_CONTMATIC));
        }});
        
        fabricarObjeto(CorreioEletronico.class, TODOS_ARGS, new Rule() {{
            add("endereco", gerarEmail(TAMANHO_COMUM_EMAIL, DOMINIO_CONTMATIC));
        }}); 
    }
    
    public static String gerarEmail(Integer tamanho, String dominio) {
        return email(tamanho, dominio);
    }
}
