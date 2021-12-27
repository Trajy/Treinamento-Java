package br.com.contmatic.model.utils.validacao;

import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarQuantidadeDeCaracteresEntre;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarNumerosComPonto;
import static br.com.contmatic.model.utils.constants.Warning.*;
import static br.com.contmatic.model.utils.constants.ValidacaoLimite.*;

public final class ValidacaoProduto {
	
	private ValidacaoProduto(){ }
	
	public static void validarVersao(String versao){
		validarCondicoes(versao, VERSAO_INVALIDA, analise ->
			validarQuantidadeDeCaracteresEntre(analise, PRODUTO_VERSAO_TAMANHO_MIN, PRODUTO_VERSAO_TAMANHO_MAX) ||
			validarNumerosComPonto(analise)
		);
	}
	
	public static void validarCodigo(String codigo) {
		validarCondicoes(codigo, CODIGO_INVALIDO, analise -> 
			validarQuantidadeDeCaracteresEntre(analise, PROTUDO_CODIGO_TAMANHO_MIN, PRODUTO_CODIGO_TAMANHO_MAX) ||
			validarNumerosComPonto(analise)
		);
	}

}
