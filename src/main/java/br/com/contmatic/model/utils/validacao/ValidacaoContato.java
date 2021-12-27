package br.com.contmatic.model.utils.validacao;

import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCaracteresRepetidos;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarSomenteNumeros;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarQuantidadeDeCaracteresEntre;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarArroba;
import static br.com.contmatic.model.utils.constants.ValidacaoLimite.*;
import static br.com.contmatic.model.utils.constants.Warning.*;

public final class ValidacaoContato{

    private ValidacaoContato() {}
    
    public static void validarDdi(Integer ddi) {
    	validarCondicoes(ddi, DDI_INVALIDO, analise -> 
			validarQuantidadeDeCaracteresEntre(analise, DDI_TAMANHO_MIN, DDI_TAMANHO_MAX)
		);
    }
    
    public static void validarDdd(Integer ddd) {
    	validarCondicoes(ddd, DDD_INVALIDO, analase ->
    		validarQuantidadeDeCaracteresEntre(analase, DDD_TAMANHO_MIN, DDD_TAMANHO_MAX)
    	);
    }
    
    public static void validarNumeroTelefone(String telefone) {
        validarCondicoes(telefone, TELEFONE_INVALIDO, analise ->
        	validarCaracteresRepetidos(analise) ||
            validarSomenteNumeros(analise) ||
            validarQuantidadeDeCaracteresEntre(analise, TELEFONE_MIN, TELEFONE_MAX)
        );
    }

    public static void validarEmail(String email) {
        validarCondicoes(email, EMAIL_INVALIDO, analise ->
            validarArroba(analise)
        );
    }
}

