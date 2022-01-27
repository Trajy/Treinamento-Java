package br.com.contmatic.model.utils.validacao;

import java.util.List;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarSomenteLetras;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarQuantidadeDeCaracteresEntre;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarSomenteNumeros;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarMaxCaracteres;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarSomenteAlfanumerico;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarListaNula;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarListaVazia;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarLimiteMaxLista;
import static br.com.contmatic.model.utils.constants.Avisos.*;
import static br.com.contmatic.model.utils.constants.CamposLimites.*;

public final class ValidacaoComum {

    private ValidacaoComum() {}

    public static void validarNome(String nome){
        validarCondicoes(nome, NOME_INVALIDO, analise -> 
            validarSomenteLetras(analise) ||
            validarQuantidadeDeCaracteresEntre(analise, NOME_MIN, NOME_MAX)  
        );
    }
    
    // TODO - validar X
    public static void validarRg(String numero){
        validarCondicoes(numero, NUMERO_INVALIDO, analise -> 
        	validarQuantidadeDeCaracteresEntre(analise, RG_MIN, RG_MAX) ||
            validarSomenteNumeros(analise)
        );
    }

    public static void validarNumeros(String numero){
        validarCondicoes(numero, NUMERO_INVALIDO, analise -> 
        	validarMaxCaracteres(analise, COMUM_MAX) ||
            validarSomenteNumeros(analise)
        );
    }
    
    // TODO - sobrecarca de metodos
    public static void validarComumAlfanumerico(String dado) {
        validarCondicoes(dado, COMUM_INVALIDO, analise ->
            validarQuantidadeDeCaracteresEntre(analise, COMUM_MIN, COMUM_MAX) ||
            validarSomenteAlfanumerico(analise)
        );
    }

    public static void validarLista(List<?> lista, int tamanhoMaxLista) {
        validarListaNula(lista);
        validarListaVazia(lista);
        validarLimiteMaxLista(lista, tamanhoMaxLista);
    }
    
    public static void validarNulo(Object objeto) {
    	validarCondicoes(objeto, NULO, analise ->
    		false
    	);
    }
}
