package br.com.contmatic.test.model.fabricaobjetos;

import java.time.LocalDateTime;

public class AuditoriaFabricaObjetos {
    
    public static String NOME_USUARIO_CRIACAO;
    public static LocalDateTime DATA_CRIACAO;
    public static String IP_CRIACAO;
    public static String NOME_USUARIO_ALTERACAO;
    public static LocalDateTime DATA_ALTERACAO;
    public static String IP_ALTERACAO;
    public static LocalDateTime HOJE;
    
    public static void construirAuditoria() {
        
        NOME_USUARIO_CRIACAO = "usuario criacao";
        NOME_USUARIO_ALTERACAO = "usuario alteracao";
        IP_CRIACAO = "192.168.255.255";
        IP_ALTERACAO = "253.199.56.2";
        HOJE = LocalDateTime.now();
        
        DATA_CRIACAO = LocalDateTime.of(HOJE.getYear(), HOJE.getMonth(), HOJE.minusDays(2).getDayOfMonth(), HOJE.getHour(), HOJE.getMinute());
        DATA_ALTERACAO = LocalDateTime.of(HOJE.getYear(), HOJE.getMonth(), HOJE.minusDays(1).getDayOfMonth(), HOJE.getHour(), HOJE.getMinute());
        
    }

}
