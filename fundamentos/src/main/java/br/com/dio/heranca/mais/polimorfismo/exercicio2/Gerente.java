package br.com.dio.heranca.mais.polimorfismo.exercicio2;

import java.util.List;

public class Gerente extends Usuario {

    private List<Vendedor> vendedores;

    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true);
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public double getTotalVendas() {
        return getVendedores().stream().mapToDouble(Vendedor::getTotalVendas).sum();
    }
}
