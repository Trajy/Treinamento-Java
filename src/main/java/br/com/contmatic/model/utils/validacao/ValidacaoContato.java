package br.com.contmatic.model.utils.validacao;

import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarQuantidadeCaracteres;
import static br.com.contmatic.model.utils.constantes.Avisos.*;
import static br.com.contmatic.model.utils.constantes.CamposLimites.*;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarArroba;

public final class ValidacaoContato{

    private ValidacaoContato() {}

    public static void validarEmail(String email) {
        validarCondicoes(email, EMAIL_INVALIDO, analise ->
            validarArroba(analise) ||
            validarQuantidadeCaracteres(analise, EMAIL_MIN, EMAIL_MAX)
        );
    }
}

