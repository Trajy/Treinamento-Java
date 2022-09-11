package br.com.contmatic.test.util;

import static java.util.Objects.nonNull;
import static java.util.stream.Stream.of;
import static org.apache.commons.collections4.IterableUtils.first;
import static org.apache.commons.collections4.IterableUtils.find;
import static org.apache.commons.lang3.ObjectUtils.allNotNull;
import static org.apache.commons.lang3.ObjectUtils.notEqual;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

import java.lang.reflect.Field;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.google.gson.Gson;

public class ValidacaoTesteUtils {
    
    private static final Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
    
    public static <T> void validarAnnotation(T objetoTeste, Class annotationClass, Runnable funcao) {
        final Class<T> classe = (Class<T>) objetoTeste.getClass();
        final T copiaObjetoTeste = copiarObjeto(objetoTeste, classe);
        funcao.run();
        encontrarAtributoAlterado(objetoTeste, copiaObjetoTeste, annotationClass);
    }
    
    private static <T> T copiarObjeto(T objeto, Class<T> classe) {
        Gson mapper = new Gson();
        System.out.println(objeto + "To aqui");
        System.out.println(mapper.toJson(objeto) + "sou a copia");
        return mapper.fromJson(mapper.toJson(objeto), classe);
    }
    
    private static <T> void encontrarAtributoAlterado(T objetoTeste, T copiaObjetoTeste, Class annotationClass) {
        System.out.println(of(objetoTeste.getClass().getDeclaredFields()).toList() + "original");
        System.out.println(of(copiaObjetoTeste.getClass().getDeclaredFields()).toList() + "copiado papai");
        List<Field> atributosComValorDiferente = of(objetoTeste.getClass().getDeclaredFields())
                .filter((atributo) -> of(copiaObjetoTeste.getClass().getDeclaredFields()).toList().contains(atributo))
                .filter(atributo -> {
                    try {
                        atributo.setAccessible(true);
                        if(allNotNull(atributo.get(objetoTeste), atributo.get(copiaObjetoTeste))) {
                            return notEqual(atributo.get(objetoTeste), atributo.get(copiaObjetoTeste));
                        }
                        else {
                            return atributo.get(objetoTeste) != atributo.get(copiaObjetoTeste);
                        }
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        throw new AssertionError("erro ao obter valor dos objetos\n" + e.getMessage());
                    }
                }).toList();
        System.out.println(atributosComValorDiferente + "olha nois");
        validarAlteracaoUnicoAtributo(atributosComValorDiferente);
        verificarViolacao(objetoTeste, annotationClass, first(atributosComValorDiferente).getName());
        System.out.println(first(atributosComValorDiferente).getName() + "aki ooo");
        retornarValorInicial(objetoTeste, copiaObjetoTeste, first(atributosComValorDiferente));
    }
    
    private static void validarAlteracaoUnicoAtributo(List<Field> atributosComValorDiferente) {
        if(atributosComValorDiferente.size() > INTEGER_ONE) {
            throw new AssertionError("Mais de um atributo foi alterado altere apenas um atributo");
        }
    }
    
    private static <T> void verificarViolacao(T objetoTeste, Class annotationClass, String nomeAtributo) {
        List<ConstraintViolation<T>> todasViolacoes = validador.validate(objetoTeste).stream().toList();
        verificarSeExisteViolacao(todasViolacoes);
        ConstraintViolation<T> violacaoAtributoAlterado = find(  
            todasViolacoes.stream()
                .filter((violacao) -> violacao.getPropertyPath().toString().equals(nomeAtributo))
                .toList(),
                (violacao) -> violacao.getConstraintDescriptor().getAnnotation().annotationType().equals(annotationClass)    
        );
        System.out.println(violacaoAtributoAlterado);
        System.out.println(annotationClass);
        if(nonNull(violacaoAtributoAlterado)) {
            return;
        }
        StringBuilder mensagem = new StringBuilder()
                .append("A seguinte validacao era esperada: ").append(annotationClass).append("\n")
                .append("entretando as seguintes validacoes foram obtidas\n");
                for(ConstraintViolation<T> violacao : todasViolacoes) {
                    mensagem.append(violacao.getConstraintDescriptor().getAnnotation()).append("\n");
                }
                mensagem.append("atributo: ").append(first(todasViolacoes).getPropertyPath()).append("\n")
                .append("valor: ").append(first(todasViolacoes).getInvalidValue()).append("\n");
        throw new AssertionError(mensagem.toString());
    }
    
    private static <T> void verificarSeExisteViolacao(List<ConstraintViolation<T>> violacoes) {
        if(violacoes.size() == INTEGER_ZERO) {
            throw new AssertionError("Nenhuma validacao obtida");
        }
    }
    
    private static <T> void retornarValorInicial(T objetoTeste, T copiaObjetoTeste, Field atributoAlterado) {
        try {
            atributoAlterado.set(objetoTeste, atributoAlterado.get(copiaObjetoTeste));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new AssertionError("Erro ao retornar valor inicial do atributo");
        }
    }
    
}
