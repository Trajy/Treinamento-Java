package br.com.contmatic.model.utils.validacao;

import java.time.LocalDate;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarDataFuturo;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarMaiorIdade;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarNumNegativo;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarLimiteNum;
import static br.com.contmatic.model.utils.constants.CamposLimites.*;
import static br.com.contmatic.model.utils.constants.Avisos.*;

public final class ValidacaoFuncionario {
	
	private ValidacaoFuncionario() {}
	
	public static void validarIdade(LocalDate data) {
		validarCondicoes(data , DATA_INVALIDA, analise ->
		    // TODO - limite de idade 100 anos
			validarDataFuturo(analise) ||
			validarMaiorIdade(analise)
		);
	}
	
	public static void validarSalario(Float salario) {
		validarCondicoes(salario, SALARIO_INVALIDO, analise ->
		    // TODO - salario minimo estipulado
			validarNumNegativo(analise) ||
			validarLimiteNum(analise, SALARIO_MAX)
		);
	}	
}
