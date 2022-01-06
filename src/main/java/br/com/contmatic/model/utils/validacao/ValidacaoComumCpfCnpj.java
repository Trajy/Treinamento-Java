package br.com.contmatic.model.utils.validacao;

import java.util.stream.IntStream;

final class ValidacaoComumCpfCnpj {

	private static final int INICIO_SEQUENCIA_ITERACAO = 2;

	private ValidacaoComumCpfCnpj() {}

    protected static int algoritmoComumCpfCnpj(String numRegistro, int qtdDigVerificadores, int limiteSequencia, boolean inverterCaracteres) {

		int digitoVerificador = 0;
		int pularChars = 0;
		
		// clocar em um metodo
		if (inverterCaracteres) { 
			numRegistro = inverter(numRegistro);
			
			pularChars = indiceInicalPosDigitos(qtdDigVerificadores);
		}
		
		int[] valoresComputados = new int[numRegistro.length() - qtdDigVerificadores];
		
		iterador(numRegistro, qtdDigVerificadores, limiteSequencia, pularChars, valoresComputados);

		digitoVerificador = (IntStream.of(valoresComputados).sum());

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

	private static void iterador(String numRegistro, int steps, int limiteSequencia, int passosSoma,
			int[] valoresComputados) {
		
		int valorSequencia = INICIO_SEQUENCIA_ITERACAO;
				
		for (int index = 0; index < (numRegistro.length() - steps); index++, valorSequencia++) {
			if (valorSequencia > limiteSequencia) {
				valorSequencia = INICIO_SEQUENCIA_ITERACAO;
			}
			valoresComputados[index] = Character.getNumericValue(numRegistro.charAt(index + passosSoma)) * valorSequencia;
		}
	}
    
}