package heranca.mais.polimorfismo;

public class IngressoMeia extends Ingresso {

    public IngressoMeia(Filme filme, double valor) {
        super(filme, valor / 2);
    }

}
