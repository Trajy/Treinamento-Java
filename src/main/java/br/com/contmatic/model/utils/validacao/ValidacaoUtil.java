package br.com.contmatic.model.utils.validacao;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import static java.util.stream.IntStream.range;
import static java.lang.Math.abs;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.*;

final class ValidacaoUtil {

    private ValidacaoUtil() {
    }

    protected static boolean validarQuantidadeCaracteres(Object analise, int tamanho) {
        return analise.toString().length() != tamanho;
    }

    protected static boolean validarMaxCaracteres(Object analise, int tamanho) {
        return analise.toString().length() > tamanho;
    }

    protected static boolean validarMinCaracteres(Object analise, int tamanho) {
        return analise.toString().length() < tamanho;
    }

    protected static boolean validarQuantidadeCaracteres(Object analise, int min, int max) {
        return validarMinCaracteres(analise, min) || validarMaxCaracteres(analise, max);
    }

    protected static boolean validarCaracteresRepetidos(Object analise, Boolean validar) {
        if(validar) {
            return !range(0, analise.toString().length() - 1).anyMatch(i -> 
                analise.toString().charAt(i) != analise.toString().charAt(i + 1)
            );
        }
        return false;
    }

    protected static boolean validarArroba(Object analise) {
        return (!analise.toString().contains("@") || analise.toString().startsWith("@"));
    }
    
    protected static boolean validarMinNum(Object analise, Object limite) {
        return Float.parseFloat(analise.toString()) < Float.parseFloat(limite.toString());
    }

    protected static boolean validarMaxNum(Object analise, Object limite) {
        return Float.parseFloat(analise.toString()) > Float.parseFloat(limite.toString());
    }
    
    
    protected static boolean validarExpressaoRegular(Object analise, String expressaoRegular) {
        return !analise.toString().matches(expressaoRegular);
    }

    protected static boolean validarDataDepois(Object analise) {
        LocalDate data = (LocalDate) analise;
        return data.isAfter(LocalDate.now());
    }
    
    protected static boolean validarDataDepois(Object analise, Object analiseComparada) {
        LocalDate data = (LocalDate) analise;
        LocalDate dataComparada = (LocalDate) analiseComparada;
        return data.isAfter(dataComparada);
    }
    
    protected static boolean validarDataIgualHoje(Object analise) {
        LocalDate data = (LocalDate) analise;
        return !(data == LocalDate.now());
    }
    
    protected static boolean validarDiferencaAnualDatas(Object analise, Integer diferencaAceita) {
        LocalDate data = (LocalDate) analise;
        return abs(data.getYear() - LocalDate.now().getYear()) >= diferencaAceita ;
    }
    
    protected static boolean validarDiferencaAnualDatas(Object analise, Object analiseComparada, Integer diferencaAceita) {
        LocalDate data = (LocalDate) analise;
        LocalDate dataComparada = (LocalDate) analiseComparada;
        return (data.getYear() - dataComparada.getYear()) >= diferencaAceita ;
    }
    
    protected static boolean validarDiferencaAnualDatas(Object analise, Integer diferencaMinAceita, Integer diferencaMaxAceita) {
        LocalDate data = (LocalDate) analise;
        Integer diferenca = abs(LocalDate.now().getYear() - data.getYear());
        return ((diferenca <= diferencaMinAceita) && (diferenca >= diferencaMaxAceita));
    }

    public static void validarNulo(Object analise) {
        if (analise == null) {
            throw new IllegalArgumentException(NULO);
        }
    }

    protected static void validarVazioOuEspacos(Object analise) {
        if (analise.toString().isEmpty() || analise.toString().isBlank()) {
            throw new IllegalStateException(SOMENTE_ESPACOS);
        }
    }

    protected static void validarListaNula(List<?> lista) {
        if (lista == null) {
            throw new IllegalArgumentException(LISTA_NULA);
        }
    }

    protected static void validarLimiteMaxLista(List<?> lista, int tamanhoMaxLista, String aviso) {
        if (lista.size() > tamanhoMaxLista) {
            throw new IllegalStateException(aviso);
        }
    }

    protected static void validarListaVazia(List<?> lista , String aviso) {
        if (lista.isEmpty()) {
            throw new IllegalStateException(aviso);
        }
    }

    protected static void validarCondicoes(Object analise, String aviso, Predicate<Object> condicao) {
        validarNulo(analise);
        validarVazioOuEspacos(analise);
        if (condicao.test(analise)) {
            throw new IllegalStateException(aviso);
        }
    }
}
