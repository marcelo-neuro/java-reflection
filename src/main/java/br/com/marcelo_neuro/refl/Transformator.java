package br.com.marcelo_neuro.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {

    public <T, U> U transform(T input, Class target) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> sourceClass = input.getClass();
        Class<?> targetClass = target;

        U instanceOfTarget = (U) targetClass.getDeclaredConstructor().newInstance();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();

        int sourceFieldI = 0;
        int targetFieldI = 0;
        while (targetFieldI < targetFields.length && sourceFieldI < sourceFields.length) {
            if(validateFields(sourceFields[sourceFieldI], targetFields[targetFieldI])) {
                targetFields[targetFieldI].set(instanceOfTarget,
                        sourceFields[sourceFieldI].get(input));
                targetFieldI++;
            } else {
                sourceFieldI++;
            }
        }

        return instanceOfTarget;
    }

    private boolean validateFields(Field sourceField, Field targetField) {
        if(targetField.getName().equals(sourceField.getName())
            && targetField.getType().equals(sourceField.getType())) {
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            return true;
        }
        return false;
    }
}
