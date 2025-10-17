package br.com.marcelo_neuro.refl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToJson {

    private final ObjectMapper objectMapper;

    public ObjectToJson() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public String transform(Object object) throws IllegalAccessException, JsonProcessingException {
        Map<String, Object> objectMap = toMap(object);
        return objectMapper.writeValueAsString(objectMap);;
    }

    private Map<String, Object> toMap(Object object) throws IllegalAccessException {
        Map<String, Object> result = new HashMap<>();
        Class<?> targetClass = object.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = field.get(object);
            result.put(fieldName, fieldValue);
        }
        return result;
    }
}
