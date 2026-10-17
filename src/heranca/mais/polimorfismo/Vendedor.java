package heranca.mais.polimorfismo;

public non-sealed class Vendedor extends Funcionario {

    private double percentualPorVenda;

    public double getPercentualPorVenda() {
        return percentualPorVenda;
    }

    public void setPercentualPorVenda(double percentualPorVenda) {
        this.percentualPorVenda = percentualPorVenda;
    }
}
