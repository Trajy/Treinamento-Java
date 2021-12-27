package br.com.contmatic.model.utils.validacao;

import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarQuantidadeDeCaracteresEntre;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarSomenteNumeros;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarSomenteAlfanumerico;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCaracteresRepetidos;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarQuantidadeCaracteres;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarSomenteLetras;
import static br.com.contmatic.model.utils.constants.Warning.*;
import static br.com.contmatic.model.utils.constants.ValidacaoLimite.*;

public final class ValidacaoEndereco {

    private ValidacaoEndereco() {}

    public static void validarCep(String cep){
        validarCondicoes(cep, CEP_INVALIDO, analise -> 
        	validarCaracteresRepetidos(analise) || 
            validarQuantidadeCaracteres(analise, CEP_LENGHT) ||
            validarSomenteNumeros(analise)
        );
    }

    public static void validarNumeroEndereco(Object numero) {
        validarCondicoes(numero, NUMERO_INVALIDO, analise ->
            validarSomenteNumeros(analise) || 
            validarQuantidadeDeCaracteresEntre(analise, ENDERECO_NUMERO_MIN, ENDERECO_NUMERO_MAX)
        );
    }

    public static void validarRua(String rua) {
        validarCondicoes(rua, RUA_INVALIDO, analise ->
            validarSomenteAlfanumerico(analise) || 
            validarQuantidadeDeCaracteresEntre(analise, RUA_MIN, RUA_MAX)
        );
    }

    public static void validarBairro(String bairro) {
        validarCondicoes(bairro, BAIRRO_INVALIDO, analise ->
            validarSomenteAlfanumerico(analise) || 
            validarQuantidadeDeCaracteresEntre(analise, BAIRRO_MIN, BAIRRO_MAX)
        );
    }

    public static void validarCidade(String cidade) {
        validarCondicoes(cidade, CIDADE_INVALIDO, analise ->
            validarSomenteAlfanumerico(analise) || 
            validarQuantidadeDeCaracteresEntre(analise, CIDADE_MIN, CIDADE_MAX)
        );
    }

    public static void validarEstado(String estado) {
        validarCondicoes(estado, ESTADO_INVALIDO, analise ->
            validarSomenteLetras(analise) || 
            validarQuantidadeDeCaracteresEntre(analise, ESTADO_MIN, ESTADO_MAX)
        );
    }

    public static void validarPais(String pais) {
        validarCondicoes(pais, PAIS_INVALIDO, analise ->
            validarSomenteLetras(analise) || 
            validarQuantidadeDeCaracteresEntre(analise, PAIS_MIN, PAIS_MAX)
        );
    }
}
