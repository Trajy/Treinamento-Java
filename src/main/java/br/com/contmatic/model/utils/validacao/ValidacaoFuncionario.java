package br.com.contmatic.model.utils.validacao;

import java.time.LocalDate;

import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarDiferencaAnualDatas;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.DATA_FUNCIONARIO_INVALIDA;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.IDADE_MIN_TRABALHISTA;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.IDADE_MAX_TRABALHISTA;

public final class ValidacaoFuncionario {
	
	private ValidacaoFuncionario() {}
	
	public static void validarIdade(LocalDate data) {
		validarCondicoes(data , DATA_FUNCIONARIO_INVALIDA, analise ->
		    validarDiferencaAnualDatas(analise, IDADE_MIN_TRABALHISTA, IDADE_MAX_TRABALHISTA)
		);
	}
	
}
