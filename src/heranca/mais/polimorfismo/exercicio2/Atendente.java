package heranca.mais.polimorfismo.exercicio2;

public class Atendente extends Usuario {

    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha, double valorEmCaixa) {
        super(nome, email, senha, false);
        this.valorEmCaixa = valorEmCaixa;
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void setValorEmCaixa(double valorEmCaixa) {
        this.valorEmCaixa = valorEmCaixa;
    }
}
