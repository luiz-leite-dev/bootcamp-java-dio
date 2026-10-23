package br.com.dio.classes.mais.encapsulamento;

public class Person {

    private final String name;

    private int age;

    public Person(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
