package br.com.marcelo_neuro.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {

    public <T, U> U transform(T source, Class target) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target;

        U instanceOfTarget = (U) targetClass.getDeclaredConstructor().newInstance();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();

        int sourceFieldI = 0;
        int targetFieldI = 0;
        while (targetFieldI < targetFields.length && sourceFieldI < sourceFields.length) {
            if(targetFields[targetFieldI].getName().equals(sourceFields[sourceFieldI].getName())) {
                targetFields[targetFieldI].setAccessible(true);

                targetFieldI++;
            } else {
                sourceFieldI++;
            }
        }

        return instanceOfTarget;
    }
}
