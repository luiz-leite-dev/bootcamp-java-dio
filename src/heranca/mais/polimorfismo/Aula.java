package heranca.mais.polimorfismo;

public class Aula {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();

        gerente.setNome("João");
        gerente.setLogin("joao");
        gerente.setSenha("123456");

        System.out.println(gerente.getNome());
        System.out.println(gerente.getLogin());
        System.out.println(gerente.getSenha());
    }
}
