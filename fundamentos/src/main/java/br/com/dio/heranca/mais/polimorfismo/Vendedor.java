package br.com.dio.heranca.mais.polimorfismo;

public non-sealed class Vendedor extends Funcionario {

    private double percentualPorVenda;

    private double totalVendido;

    public Vendedor(String codigo, String nome, String endereco, int idade, double salario, double percentualPorVenda, double totalVendido) {
        super(codigo, nome, endereco, idade, salario);
        this.percentualPorVenda = percentualPorVenda;
        this.totalVendido = totalVendido;
    }

    public Vendedor() {

    }

    @Override 
    public String getCodigo() {
        return "VEN-" + super.getCodigo();
    }

    public double getPercentualPorVenda() {
        return percentualPorVenda;
    }

    public void setPercentualPorVenda(double percentualPorVenda) {
        this.percentualPorVenda = percentualPorVenda;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    @Override
    public double getSalarioTotal() {
        return this.getSalario() + (this.totalVendido * this.percentualPorVenda / 100); 
    }

    public double getSalarioTotal(double extra) {
        return getSalarioTotal() + extra;
    }
}
