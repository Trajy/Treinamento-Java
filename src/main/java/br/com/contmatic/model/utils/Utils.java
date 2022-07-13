package br.com.contmatic.model.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.lang.reflect.Field;

public final class Utils {  
    public static Collection<String> diferencaConjuntos(Object contexto, Collection<String> A) {
        List<Field> fields = Arrays.asList(contexto.getClass().getDeclaredFields());
        fields.removeIf(x -> A.contains(x));
        List<String> B = new ArrayList<>();
        fields.forEach(x -> B.add(x.getName()));
        return B;
    }
}
