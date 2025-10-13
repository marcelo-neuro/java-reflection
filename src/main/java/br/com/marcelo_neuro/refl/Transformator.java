package br.com.marcelo_neuro.refl;

import java.lang.reflect.InvocationTargetException;

public class Transformator {

    public <T, U> U transform(T source, Class target) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target;

        U instanceOfTarget = (U) targetClass.getDeclaredConstructor().newInstance();

        return null;
    }
}
