package br.com.contmatic.test.model.fabricaobjetos;

import java.time.LocalDate;

public class AuditoriaFabricaObjetos {
    
    public static String NOME_USUARIO_CRIACAO;
    public static LocalDate DATA_CRIACAO;
    public static String IP_CRIACAO;
    public static String NOME_USUARIO_ALTERACAO;
    public static LocalDate DATA_ALTERACAO;
    public static String IP_ALTERACAO;
    public static LocalDate HOJE;
    
    public static void construirAuditoria() {
        
        NOME_USUARIO_CRIACAO = "usuario criacao";
        NOME_USUARIO_ALTERACAO = "usuario alteracao";
        IP_CRIACAO = "192.168.255.255";
        IP_ALTERACAO = "253.199.56.2";
        HOJE = LocalDate.now();
        DATA_CRIACAO = LocalDate.of(HOJE.getYear(), HOJE.getMonth(), HOJE.getDayOfMonth() - 2);
        DATA_ALTERACAO = LocalDate.of(HOJE.getYear(), HOJE.getMonth(), HOJE.getDayOfMonth() - 1);
        
    }

}
