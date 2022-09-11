package br.com.contmatic.test.util;

import java.lang.reflect.Field;
import java.util.List;
import static java.util.stream.Stream.of;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.metadata.ConstraintDescriptor;

import static org.apache.commons.collections4.IterableUtils.first;
import static org.apache.commons.lang3.ObjectUtils.notEqual;
import static org.apache.commons.lang3.ObjectUtils.allNotNull;


import com.google.gson.Gson;

public class ValidacaoTesteUtils {
    
    private static final Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
    
    public static <T> void validarAnnotation(T objetoTeste, Class annotationClass, Runnable funcao) {
        final Class<T> classe = (Class<T>) objetoTeste.getClass();
        final T copiaObjetoTeste = copiarObjeto(objetoTeste, classe);
        funcao.run();
        verificaSeAtributoPossuiViolacoes(objetoTeste, annotationClass, qualAtributoAlterado(objetoTeste, copiaObjetoTeste));
    }
    
    public static <T> void validarAnnotation(T objetoTeste, Class annotationClass, String nomeAtributo) {
        verificaSeObjetoPossuiAtributo(objetoTeste, nomeAtributo);
        verificaSeAtributoPossuiViolacoes(objetoTeste, annotationClass, nomeAtributo);       
    }
    
    private static <T> T copiarObjeto(T objeto, Class<T> classe) {
        Gson mapper = new Gson();
        System.out.println(objeto + "To aqui");
        System.out.println(mapper.toJson(objeto) + "sou a copia");
        return mapper.fromJson(mapper.toJson(objeto), classe);
    }
    
    private static <T> String qualAtributoAlterado(T objetoTeste, T copiaObjetoTeste) {
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
        if(atributosComValorDiferente.size() > 1) {
            throw new AssertionError("Mais de um atributo foi alterado, neste caso altere apenas um atributo ou informe qual atributo deseja verificar como argumento");
        }
        return first(atributosComValorDiferente).getName();   
    }
    
    private static void verificaSeObjetoPossuiAtributo(Object objetoTeste, String nomeAtributo) {
        if(of(objetoTeste.getClass().getDeclaredFields()).anyMatch((atributo) -> atributo.getName().equals(nomeAtributo))) {
            return;
        }
        StringBuilder mensagem = new StringBuilder()
                .append("A classe ").append(objetoTeste.getClass())
                .append(" nao possui o atributo '").append(nomeAtributo).append("'\n\n");
        throw new AssertionError(mensagem.toString());
    }
    
    private static void verificaSeAtributoPossuiViolacoes(Object objetoTeste, Class annotationClass, String nomeAtributo) {
        for(ConstraintViolation<?> validacao :  validador.validate(objetoTeste).stream().toList()) {
            ConstraintDescriptor<?> erroMetadata = validacao.getConstraintDescriptor();
            if(validacao.getPropertyPath().toString().equals(nomeAtributo)) {
                if(erroMetadata.getAnnotation().annotationType().equals(annotationClass)) {
                    return;
                }
                StringBuilder mensagem = new StringBuilder()
                        .append("A seguinte validacao falhou\n")
                        .append(erroMetadata.getAnnotation()).append("\n")
                        .append("atributo: ").append(validacao.getPropertyPath()).append("\n")
                        .append("valor: ").append(validacao.getInvalidValue()).append("\n");
                throw new AssertionError(mensagem.toString());
            }
        }  
    }
    
}
