package main.java.br.com.dio.model;

import main.java.br.com.dio.annotation.SerializerType;

@SerializerType
public record User(long id, String fullName, int age, double salary) {

}
