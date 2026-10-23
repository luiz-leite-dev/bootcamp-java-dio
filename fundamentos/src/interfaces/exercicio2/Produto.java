package interfaces.exercicio2;

public class Produto implements CalculoTributos {

    public enum Tipo {
        ALIMENTACAO(1),
        SAUDE_E_BEM_ESTAR(1.5),
        VESTUARIO(2.5),
        CULTURA(4);

        private double percentualImposto;

        Tipo(double percentualImposto){
            this.percentualImposto = percentualImposto;
        }

        public double getPercentualImposto() {
            return this.percentualImposto;
        }
    }

    private String nome;

    private double preco;

    private Tipo tipo;

    public Produto(String nome, double preco, Tipo tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcularTributos() {
        return this.preco * this.tipo.getPercentualImposto() / 100;
    }
}
