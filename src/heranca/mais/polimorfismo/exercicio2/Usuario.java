package heranca.mais.polimorfismo.exercicio2;

public class Usuario {

    private String nome;
    
    private String email;

    private String senha;

    private boolean ehAdministrador;

    public Usuario(String nome, String email, String senha, boolean ehAdministrador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ehAdministrador = ehAdministrador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isEhAdministrador() {
        return ehAdministrador;
    }

    public void setEhAdministrador(boolean ehAdministrador) {
        this.ehAdministrador = ehAdministrador;
    }
}
