package br.com.contmatic.model.utils.validacao;

import java.util.stream.IntStream;
import static java.lang.Character.getNumericValue;

final class ValidacaoIteracaoCpfCnpj {

    private static final int INICIO_SEQUENCIA_ITERACAO = 2;

    private ValidacaoIteracaoCpfCnpj() {
    }

    protected static int algoritmoComumCpfCnpj(String numRegistro, int qtdDigVerificadores, int limiteSequencia) {

        int digitoVerificador = 0;
        int pularChars = indiceInicalPosDigitos(qtdDigVerificadores);
        numRegistro = inverter(numRegistro);

        int[] valoresComputados = new int[numRegistro.length() - qtdDigVerificadores];

        iterador(numRegistro, qtdDigVerificadores, limiteSequencia, pularChars, valoresComputados);

        digitoVerificador = IntStream.of(valoresComputados).sum();

        return digitoVerificador;
    }

    private static int indiceInicalPosDigitos(int qtdDigitos) {
        int passosSoma;
        passosSoma = qtdDigitos;
        return passosSoma;
    }

    private static String inverter(String numRegistro) {
        numRegistro = new StringBuilder(numRegistro).reverse().toString();
        return numRegistro;
    }

    private static void iterador(String numRegistro, int passos, int limiteSequencia, int passosSoma, int[] valoresComputados) {

        int valorSequencia = INICIO_SEQUENCIA_ITERACAO;

        for(int index = 0 ; index < (numRegistro.length() - passos) ; index++, valorSequencia++) {
            if (valorSequencia > limiteSequencia) {
                valorSequencia = INICIO_SEQUENCIA_ITERACAO;
            }
            valoresComputados[index] = getNumericValue(numRegistro.charAt(index + passosSoma)) * valorSequencia;
        }
    }

}
