package br.com.contmatic.model.utils.validacao;

import static java.lang.Character.getNumericValue;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCondicoes;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarCaracteresRepetidos;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarSomenteNumeros;
import static br.com.contmatic.model.utils.validacao.ValidacaoUtil.validarQuantidadeCaracteres;
import static br.com.contmatic.model.utils.validacao.ValidacaoIteracaoCpfCnpj.algoritmoComumCpfCnpj;
import static br.com.contmatic.model.utils.constants.Avisos.*;

public final class ValidacaoCpf {
	
	private static final int DIVISOR_E_MINUENDO = 11;
	private static final int TAMANHO_CPF = 11;
	private static final int LIMITE_DA_SEQUENCIA = 11;
	private static final int STEPS = 2;
	private static final int MULTIPLICADOR = 10;
	private static final int CRITERIO_PARA_O_DIG_VERIFICADOR_CPF = 10;
	private static final int DIG_VERIFICADOR_CASO_CRITERIO_VERDADEIRO = 0;

	private ValidacaoCpf() {}
	
	public static void validarCpf(String cpf) {
		
		validarCondicoes(cpf, CPF_INVALIDO, analise ->
			validarCaracteresRepetidos(analise) ||
			validarSomenteNumeros(analise) || 
			validarQuantidadeCaracteres(analise, TAMANHO_CPF)
		);	
			
		itarador(cpf);	
	}

	private static void itarador(String cpf) {
		for (int index = 0; index < STEPS; index++)  {
			int digitoVerificador = (algoritmoComumCpfCnpj(cpf, STEPS - index, LIMITE_DA_SEQUENCIA, true) * MULTIPLICADOR) % DIVISOR_E_MINUENDO;
			digitoVerificador = verificarCriterio(digitoVerificador);
			validarDigVerificadorCpf(cpf, index, digitoVerificador);
		}
	}

	private static int verificarCriterio(int digitoVerificador) {
		if (digitoVerificador == CRITERIO_PARA_O_DIG_VERIFICADOR_CPF) digitoVerificador = DIG_VERIFICADOR_CASO_CRITERIO_VERDADEIRO;
		return digitoVerificador;
	}

	private static void validarDigVerificadorCpf(String cpf, int index, int digitoVerificador) {
		if (getNumericValue(cpf.charAt(cpf.length() - STEPS + index)) != digitoVerificador) {
			throw new IllegalStateException(CPF_INVALIDO);
		}
	}
}
