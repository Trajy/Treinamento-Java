package br.com.contmatic.model.utils.validacao;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import static br.com.contmatic.model.utils.constants.Warning.*;
import static br.com.contmatic.model.utils.constants.ValidacaoLimite.*;

final class ValidacaoUtil {

	private ValidacaoUtil() {}
	
	protected static boolean validarQuantidadeCaracteres(Object analise, int tamanho) {
		return analise.toString().length() != tamanho;
	}
	
	protected static boolean validarMaxCaracteres(Object analise, int tamanho){
		return analise.toString().length() > tamanho;
	}

	protected static boolean validarMinCaracteres(Object analise, int tamanho){
		return analise.toString().length() < tamanho;
	}

	protected static boolean validarQuantidadeDeCaracteresEntre(Object analise, int min, int max) {
		return validarMinCaracteres(analise, min) || validarMaxCaracteres(analise, max);
	}
	
	protected static boolean validarCaracteresRepetidos(Object analise) {
		 return !IntStream.range(
				 0, analise.toString().length() - 1).anyMatch(
						 i -> analise.toString().charAt(i) != analise.toString().charAt(i + 1));
	}

	protected static boolean validarArroba(Object analise){
		return (!analise.toString().contains("@") || analise.toString().startsWith("@"));
	}
	
	protected static boolean validarNumNegativo(Object analise){
		return Float.parseFloat(analise.toString()) < 0;
	}
	
	protected static boolean validarLimiteNum(Object analise, Object limite) {
		return Float.parseFloat(analise.toString()) > Float.parseFloat(analise.toString()); 
	}
	
	protected static boolean validarSomenteNumeros(Object analise) {
		return !analise.toString().matches("^\\d+$");
	}
	
	protected static boolean validarNumerosComPonto(Object analise) {
		return !analise.toString().matches("([0-9.]*)");
	}

	protected static boolean validarSomenteLetras(Object analise) {
		return !analise.toString().matches("([A-Za-zá-úÁ-Ú., ]*)");
	}

	protected static boolean validarSomenteAlfanumerico(Object analise) {
		return !analise.toString().matches("([A-Za-zá-úÁ-Ú0-9., ]*)");
	}
	
	protected static boolean validarDiaFuturo(Object analise) {
		LocalDate data = (LocalDate) analise;
		return data.getDayOfMonth() > LocalDate.now().getDayOfMonth();
	}
	
	protected static boolean validarMesFuturo(Object analise) {
		LocalDate data = (LocalDate) analise;
		return data.getDayOfYear() > LocalDate.now().getMonthValue();
	}
	
	protected static boolean validarAnoFuturo(Object analise) {
		LocalDate data = (LocalDate) analise;
		return data.getYear() > LocalDate.now().getYear();
	}
	
	protected static boolean validarDataFuturo(Object analise) {
		LocalDate data = (LocalDate) analise;
		return data.isAfter(LocalDate.now());
	}
	
	protected static boolean validarMaiorIdade(Object analise) {
		LocalDate data = (LocalDate) analise;
		return MAIORIDADE >= (LocalDate.now().getYear() - data.getYear()) &&
				!validarMesFuturo(data) && !validarDiaFuturo(data);
	}
	
	public static void validarNull (Object analise) {
		if(analise == null) {
			throw new IllegalArgumentException(NULO);	
		}
	}	
	protected static void validarVazioOuEspacos(Object analise) {
		if (analise.toString().isEmpty() || analise.toString().isBlank()) {
			throw new IllegalStateException(SOMENTE_ESPACOS);
		}
	}
	
	protected static void validarListaNula(List<?> lista){
		if(lista == null) {
			throw new IllegalArgumentException(LISTA_NULA);
		}
	}

	protected static void validarLimiteMaxLista(List<?> lista, int tamanhoMaxLista) {
		if(lista.size() > tamanhoMaxLista) {
			throw new IllegalStateException(LISTA_LIMITE);
		}
	}

	protected static void validarListaVazia(List<?> lista){
		if(lista.isEmpty()) {
			throw new IllegalStateException(LISTA_VAZIA);
		}
	}

	protected static void validarCondicoes(Object analise, String warning, Predicate<Object> condicao){
		validarNull(analise);
		validarVazioOuEspacos(analise);
		if(condicao.test(analise)) {
			throw new IllegalStateException(warning);
		}
	}
}