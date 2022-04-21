package br.com.contmatic.model.utils.constantes;

public final class ExpressoesRegulares {
    
    private ExpressoesRegulares() {
    
    }
    
    public static final String NUMEROS = "^\\d+$";
    public static final String NUMEROS_COM_PONTO = "([0-9.]*)";
    public static final String LETRAS = "^[^\s][A-Za-zá-úÁ-Ú., ]*[^\s]$";
    public static final String ALFANUMERICO = "^[^\s]([A-Za-zá-úÁ-Ú0-9., ]*)[^\s]$";
    public static final String RG = "^([0-9xX]+)$";
    public static final String IP = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    
}
