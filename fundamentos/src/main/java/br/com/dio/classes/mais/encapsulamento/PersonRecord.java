package br.com.dio.classes.mais.encapsulamento;

public record PersonRecord(String name, int age) {

    public PersonRecord{
        //Compact Constructor
        //Perfeito para validações dos dados
        if (age <= 0) throw new Error("Idade precisa ser maior que zero.");
    }

    public String getInfo(){
        return "Name: " + name + " - Age: " + age;
    }

}
