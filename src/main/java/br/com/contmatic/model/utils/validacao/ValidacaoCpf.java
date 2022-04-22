package br.com.contmatic.model.utils.validacao;

import static java.lang.Character.getNumericValue;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoIteracaoCpfCnpj.algoritmoComumCpfCnpj;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.CPF_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS;


public final class ValidacaoCpf {
	
    private static final int DIVISOR_E_MINUENDO = 11;

    private static final int TAMANHO_CPF = 11;

    private static final int LIMITE_DA_SEQUENCIA = 11;

    private static final int STEPS = 2;

    private static final int MULTIPLICADOR = 10;

    private static final int CRITERIO_PARA_O_DIG_VERIFICADOR_CPF = 10;

    private static final int DIG_VERIFICADOR_CASO_CRITERIO_VERDADEIRO = 0;

    private ValidacaoCpf() {
    }

    public static void validarCpf(String cpf) {
        validarExpressaoRegularETamanho(cpf, NUMEROS, TAMANHO_CPF, CPF_INVALIDO, VALIDAR_CHARS_REPETIDOS);		
        itarador(cpf);
    }

    private static void itarador(String cpf) {
        for(int index = 0 ; index < STEPS ; index++) {
            int digitoVerificador = (algoritmoComumCpfCnpj(cpf, STEPS - index, LIMITE_DA_SEQUENCIA) * MULTIPLICADOR) % DIVISOR_E_MINUENDO;
            digitoVerificador = verificarCriterio(digitoVerificador);
            validarDigVerificadorCpf(cpf, index, digitoVerificador);
        }
    }

    private static int verificarCriterio(int digitoVerificador) {
        if (digitoVerificador == CRITERIO_PARA_O_DIG_VERIFICADOR_CPF) {
            digitoVerificador = DIG_VERIFICADOR_CASO_CRITERIO_VERDADEIRO;
        }   
        return digitoVerificador;
    }

    private static void validarDigVerificadorCpf(String cpf, int index, int digitoVerificador) {
        if (getNumericValue(cpf.charAt(cpf.length() - STEPS + index)) != digitoVerificador) {
            throw new IllegalStateException(CPF_INVALIDO);
        }
    }
    
}
