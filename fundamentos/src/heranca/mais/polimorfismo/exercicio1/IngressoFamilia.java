package heranca.mais.polimorfismo.exercicio1;

public class IngressoFamilia extends Ingresso {

    private int numeroDePessoas;

    public IngressoFamilia(Filme filme, double valor, int numeroDePessoas) {
        super(filme, valor * numeroDePessoas * (1 - (numeroDePessoas > 3 ? 0.05 : 0)));
        this.numeroDePessoas = numeroDePessoas;
    }

    public int getNumeroDePessoas() {
        return numeroDePessoas;
    }

    public void setNumeroDePessoas(int numeroDePessoas) {
        this.numeroDePessoas = numeroDePessoas;
    }
}
