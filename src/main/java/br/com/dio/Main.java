package br.com.dio;

import java.lang.reflect.InvocationTargetException;

import br.com.dio.model.Person;
import br.com.dio.model.User;
import br.com.dio.processor.SerializerProcessor;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        var processor = new SerializerProcessor();
        System.out.println(processor.serialize(new User(1, "Luiz Leite", 38, 3222.22)));
        System.out.println(processor.serialize(new Person(1, "Luiz", 38)));
        
    }
}
