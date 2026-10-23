package br.com.dio.heranca.mais.polimorfismo;

public non-sealed class Gerente extends Funcionario {

    private String login;

    private String senha;

    private double comissao;

    public Gerente(String codigo, String nome, String endereco, int idade, double salario, String login, String senha, double comissao) {
        super(codigo, nome, endereco, idade, salario);
        this.login = login;
        this.senha = senha;
        this.comissao = comissao;
    }

    public Gerente() {

    }

    @Override 
    public String getCodigo() {
        return "GER-" + super.getCodigo();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double getSalarioTotal() {
        return this.getSalario() + (this.getSalario() * this.getComissao() / 100);
    }
}
