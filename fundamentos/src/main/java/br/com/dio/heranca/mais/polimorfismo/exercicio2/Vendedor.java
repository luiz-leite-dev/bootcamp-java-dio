package br.com.dio.heranca.mais.polimorfismo.exercicio2;

public class Vendedor extends Usuario {

    private double totalVendas;

    public Vendedor(String nome, String email, String senha, double vendasTotal) {
        super(nome, email, senha, false);
        this.totalVendas = vendasTotal;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void realizarVenda(double valor) {
        this.totalVendas += valor;
    }
}
