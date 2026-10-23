package heranca.mais.polimorfismo;

public class Aula {
    public static void main(String[] args) {
        imprimir(new Gerente());
        imprimir(new Vendedor());
    }

    public static void imprimir(Funcionario funcionario) {
        System.out.printf("=======%s=======\n",funcionario.getClass().getName());
        switch (funcionario) {
            case Gerente gerente -> {
                gerente.setCodigo("123");
                gerente.setNome("João");
                gerente.setLogin("joao");
                gerente.setSenha("123456");
                gerente.setSalario(5000);
                gerente.setComissao(12);

                System.out.println(gerente.getCodigo());
                System.out.println(gerente.getNome());
                System.out.println(gerente.getLogin());
                System.out.println(gerente.getSenha());
                System.out.println(gerente.getSalario());
                System.out.println(gerente.getSalarioTotal());
            }
            case Vendedor vendedor -> {
                vendedor.setCodigo("456");
                vendedor.setNome("Lucas");
                vendedor.setPercentualPorVenda(10);
                vendedor.setSalario(1200);
                vendedor.setTotalVendido(10000);

                System.out.println(vendedor.getCodigo());
                System.out.println(vendedor.getNome());
                System.out.println(vendedor.getPercentualPorVenda());
                System.out.println(vendedor.getSalario());
                System.out.println(vendedor.getSalarioTotal(99));
            }
        }
        System.out.println("=====================");
    }
}
