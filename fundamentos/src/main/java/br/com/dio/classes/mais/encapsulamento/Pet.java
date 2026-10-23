package br.com.dio.classes.mais.encapsulamento;

public class Pet {

    private final String nome;

    private boolean limpo;

    public Pet(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    public boolean getLimpo() {
        return this.limpo;
    }

}
