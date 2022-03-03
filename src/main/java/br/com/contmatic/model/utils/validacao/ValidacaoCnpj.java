package br.com.contmatic.model.utils.validacao;

import static java.lang.Character.getNumericValue;

import static br.com.contmatic.model.utils.validacao.ValidacaoIteracaoCpfCnpj.algoritmoComumCpfCnpj;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.constantes.EmpresaContantes.CNPJ_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.VALIDAR_CHARS_REPETIDOS;

public final class ValidacaoCnpj {

    private static final int DIVISOR_E_MINUENDO = 11;

    private static final int TAMANHO_CNPJ = 14;

    private static final int LIMITE_DA_SEQUENCIA = 9;

    private static final int QTD_DIG_VERIFICADORES = 2;

    private static final int CRITERIO_PARA_O_DIG_VERIFICADOR_CNPJ = 2;

    private static final int DIG_VERIFICADOR_CASO_CRITERIO_VERDADEIRO = 0;

    private static final boolean INVERTER_CHARS = true;

    private ValidacaoCnpj() {
    }

    public static void validarCnpj(String cnpj) {
        validarExpressaoRegularETamanho(cnpj, NUMEROS, TAMANHO_CNPJ, CNPJ_INVALIDO, VALIDAR_CHARS_REPETIDOS);
        iterador(cnpj);
    }

    private static void iterador(String cnpj) {
        for(int index = 0 ; index < QTD_DIG_VERIFICADORES ; index++) {

            int digitoVerificador = algoritmoComumCpfCnpj(cnpj, QTD_DIG_VERIFICADORES - index, LIMITE_DA_SEQUENCIA, INVERTER_CHARS) % DIVISOR_E_MINUENDO;

            digitoVerificador = verificarCriterio(digitoVerificador);

            validarDigVerificadorCnpj(cnpj, index, digitoVerificador);
        }
    }

    private static int verificarCriterio(int digitoVerificador) {
        if (digitoVerificador < CRITERIO_PARA_O_DIG_VERIFICADOR_CNPJ) {
            digitoVerificador = DIG_VERIFICADOR_CASO_CRITERIO_VERDADEIRO;
        } else {
            digitoVerificador = DIVISOR_E_MINUENDO - digitoVerificador;
        }
        return digitoVerificador;
    }

    private static void validarDigVerificadorCnpj(String cnpj, int index, int digitoVerificador) {
        if (getNumericValue(cnpj.charAt(cnpj.length() - QTD_DIG_VERIFICADORES + index)) != digitoVerificador) {
            throw new IllegalStateException(CNPJ_INVALIDO);
        }
    }

}
