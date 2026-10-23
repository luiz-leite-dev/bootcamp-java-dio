package heranca.mais.polimorfismo.exercicio1;

public class Filme {

    public enum Tipo {
        DUBLADO,
        LEGENDADO
    }

    private String nome;

    private Tipo tipo;

    public Filme(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    

}
