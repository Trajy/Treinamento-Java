package br.com.contmatic.model.utils.validacao;

import java.util.List;

import static br.com.contmatic.model.utils.constantes.ComumConstantes.*;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.*;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarQuantidadeCaracteres;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarListaNula;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarListaVazia;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarLimiteMaxLista;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarExpressaoRegular;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCaracteresRepetidos;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarMinNum;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarMaxNum;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarDataIgualHoje;

public final class ValidacaoComum {

    private ValidacaoComum() {}
    
    public static void validarExpressaoRegularETamanho(Object objeto, String aviso, Boolean validarRepetidos){
        validarCondicoes(objeto, aviso, analise -> 
            validarExpressaoRegular(analise, ALFANUMERICO) ||
            validarQuantidadeCaracteres(analise, COMUM_MIN, COMUM_MAX) ||
            validarCaracteresRepetidos(analise ,validarRepetidos)
        );
    }
    
    public static void validarExpressaoRegularETamanho(Object objeto, String expressaoRegular, String aviso, Boolean validarRepetidos){
        validarCondicoes(objeto, aviso, analise -> 
            validarExpressaoRegular(analise, expressaoRegular) ||
            validarQuantidadeCaracteres(analise, COMUM_MIN, COMUM_MAX) ||
            validarCaracteresRepetidos(analise ,validarRepetidos)
        );
    }
    
    public static void validarExpressaoRegularETamanho(Object objeto, Integer min, Integer max, String aviso, Boolean validarRepetidos){
        validarCondicoes(objeto, aviso, analise -> 
            validarExpressaoRegular(analise, ALFANUMERICO) ||
            validarQuantidadeCaracteres(analise, min, max) ||
            validarCaracteresRepetidos(analise ,validarRepetidos)
        );
    }
    
    public static void validarExpressaoRegularETamanho(Object objeto, String expressaoRegular, Integer min, Integer max, String aviso, Boolean validarRepetidos){
        validarCondicoes(objeto, aviso, analise -> 
            validarExpressaoRegular(analise, expressaoRegular) ||
            validarQuantidadeCaracteres(analise, min, max) ||
            validarCaracteresRepetidos(analise ,validarRepetidos)
        );
    }
    
    public static void validarExpressaoRegularETamanho(Object objeto, String expressaoRegular, Integer tamanho, String aviso, Boolean validarRepetidos){
        validarCondicoes(objeto, aviso, analise -> 
            validarExpressaoRegular(analise, expressaoRegular) ||
            validarQuantidadeCaracteres(analise, tamanho) ||
            validarCaracteresRepetidos(analise ,validarRepetidos)
        );
    }
    
    public static void validarNumeroEntre(Object objeto, Object limiteMin, Object limiteMax, String aviso) {
        validarCondicoes(objeto, aviso, analise ->
            validarMinNum(analise, limiteMin) ||
            validarMaxNum(analise, limiteMax)
        );
    }
    
    public static void validarAgora(Object objeto) {
        validarCondicoes(objeto, DATA_ATUAL_INVALIDA, analise ->
            validarDataIgualHoje(objeto)
        );
    }
                                      
    public static void validarLista(List<?> lista, int tamanhoMaxLista, String aviso) {
        validarListaNula(lista);
        validarListaVazia(lista, aviso);
        validarLimiteMaxLista(lista, tamanhoMaxLista, aviso);
    }
    
    public static void validarNulo(Object objeto) {
    	validarCondicoes(objeto, NULO, analise ->
    		false
    	);
    }
}
