package br.com.dio.heranca.mais.polimorfismo;

public sealed abstract class Funcionario permits Gerente, Vendedor {

    private String codigo;

    private String nome;

    private String endereco;

    private int idade;

    private double salario;

    public Funcionario(String codigo, String nome, String endereco, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.salario = salario;
    }

    public Funcionario() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }    

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract double getSalarioTotal();
}
