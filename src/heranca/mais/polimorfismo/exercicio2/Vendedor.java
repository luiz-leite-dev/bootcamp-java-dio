package heranca.mais.polimorfismo.exercicio2;

public class Vendedor extends Usuario {

    private double vendasTotal;

    public Vendedor(String nome, String email, String senha, double vendasTotal) {
        super(nome, email, senha, false);
        this.vendasTotal = vendasTotal;
    }

    public double getVendasTotal() {
        return vendasTotal;
    }

    public void realizarVenda(double valor) {
        this.vendasTotal += valor;
    }
}
