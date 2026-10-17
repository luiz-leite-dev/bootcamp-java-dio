package heranca.mais.polimorfismo;

public class Ingresso {

    private Filme filme;

    private double valor;

    public Ingresso (Filme filme, double valor) {
        this.filme = filme;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    
}
