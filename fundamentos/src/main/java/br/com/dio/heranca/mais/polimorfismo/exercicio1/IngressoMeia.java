package br.com.dio.heranca.mais.polimorfismo.exercicio1;

public class IngressoMeia extends Ingresso {

    public IngressoMeia(Filme filme, double valor) {
        super(filme, valor / 2);
    }

}
