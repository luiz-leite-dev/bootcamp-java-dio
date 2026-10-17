package heranca.mais.polimorfismo.exercicio2;

import java.util.Scanner;

public class Exercicio2 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Crie uma hierarquia de classes que definam os tipos de usuários de um sistema, 
           use os seguintes requisitos:
           - Classe Gerente que terá os atributos: Nome, Email, Senha 
             e um atributo que informa se ele é administrador, esse último deve ser sempre verdadeiro;
           - Classe Vendedor que terá os seguintes atributos: Nome, Email, Senha, 
             Quantidade de vendas e um atributo que informa se ele é administrador, 
             esse útimo deve ser sempre falso;
           - Classe Atendente que terá os seguintes atributos: Nome, Email, Senha, 
             Valor em caixa e um atributo que informa se ele é administrador, 
             esse ultimo deve ser sempre falso.
           
           Cada classe deve ter seus respectivos getters e setters ( para atributos que façam sentido ter) 
           e as classes devem ter os seguintes métodos:
           - A classe Gerente deve ter os métodos Gerar relatório financeiro, Consultar vendas, 
             Realizar login, Realizar logff, alterar dados, alterar senha;
           - A classe Vendedor deve ter os métodos Realizar venda ( incrementar o número de vendas 
             quando acionado), Consultar vendas, Realizar login, Realizar logoff, alterar dados, 
             alterar senha;
           - A classe Atendente deve ter os métodos Receber pagamentos (onde o método recebe um valor 
             que deve ser incrementado no valor em caixa), Fechar o caixa, Realizar Login, Realizar logoff, 
             alterar dados e alterar senha; */
        Gerente gerente = new Gerente("João", "joao@empresa.com", "123456");
        Vendedor vendedor = new Vendedor("Lucas", "lucas@empresa.com", "123321", 0);
        Atendente atendente = new Atendente("Ana", "ana@empresa.com", "1234321", 0);
        Usuario usuarioLogado = null;
        do {
          System.out.println("===Tela de login===");
          System.out.println("Usuário (e-mail):");
          var email = scanner.next();
          System.out.println("Senha:");
          var senha = scanner.next();
          if (gerente.getEmail().equals(email)) {
              if (gerente.getSenha().equals(senha)) {
                usuarioLogado = gerente;
              } else {
                System.out.println("Senha incorreta!");
              }
          } else if (vendedor.getEmail().equals(email)) {
              if (vendedor.getSenha().equals(senha)) {
                usuarioLogado = vendedor;
              } else {
                System.out.println("Senha incorreta!");
              }
          } else if (atendente.getEmail().equals(email)) {
              if (atendente.getSenha().equals(senha)) {
                usuarioLogado = atendente;
              } else {
                System.out.println("Senha incorreta!");
              }
          } else {
            System.out.println("E-mail incorreto!");
          }
        } while (usuarioLogado == null);

        while (true) {
          System.out.println("====Menu====");
          System.out.println("1 - Fazer logoff");
          System.out.println("2 - Alterar dados");
          System.out.println("3 - Alterar senha");

          if (usuarioLogado instanceof Gerente) {
            System.out.println("4 - Consultar vendas");
            System.out.println("5 - Gerar relatório financeiro");
          } else if (usuarioLogado instanceof Vendedor) {
            System.out.println("4 - Consultar vendas");
            System.out.println("6 - Realizar venda");
          } else if (usuarioLogado instanceof Atendente) {
            System.out.println("7 - Receber pagamentos");
            System.out.println("8 - Fechar o caixa");
          }
          var opcao = scanner.nextInt();
          switch (opcao) {
            case 1 -> fazerLogoff(usuarioLogado);
            case 2 -> alterarDados(usuarioLogado);
            case 3 -> alterarSenha(usuarioLogado);
            case 4 -> consultarVendas(usuarioLogado);
            case 5 -> gerarRelatorioFinaceiro(usuarioLogado);
            case 6 -> realizarVenda(usuarioLogado);
            case 7 -> receberPagamento(usuarioLogado);
            case 8 -> fecharCaixa(usuarioLogado);
          }
        }
        scanner.close();
    }

    private static void fecharCaixa(Usuario usuario) {
      if (usuario instanceof Atendente atendente) {
        // TODO fechar o caixa do atendente
      }
    }

    private static void receberPagamento(Usuario usuario) {
      if (usuario instanceof Atendente atendente) {
        // TODO receber pagamento do atendente
      }
    }

    private static void realizarVenda(Usuario usuario) {
      if (usuario instanceof Vendedor vendedor) {
        System.out.println("Digite o valor da venda:");
        var valor = scanner.nextDouble();
        vendedor.realizarVenda(valor);
        System.out.println("Venda realizada com sucesso!");
      }
    }

    private static void gerarRelatorioFinaceiro(Usuario usuario) {
      if (usuario instanceof Gerente gerente) {
          // TODO gerar relatório financeiro do gerente
      }
    }

    private static void consultarVendas(Usuario usuario) {
      if (usuario instanceof Gerente gerente) {
        //TODO consultar vendas de todos os vendedores
      } else if (usuario instanceof Vendedor vendedor) {
        //TODO consultar venda deste vendedor
      }
    }

    private static void fazerLogoff(Usuario usuario) {
      usuario.setLogado(false);
      System.out.println("Sistema encerrado!");
      scanner.close();
      System.exit(0);
    }

    private static void alterarDados(Usuario usuario) {
      System.out.println("Digite o nome:");
      var nome = scanner.next();
      System.out.println("Digite o e-mail:");
      var email = scanner.next();
      usuario.setNome(nome);
      usuario.setEmail(email);
      System.out.println("Usuário alterado com sucesso!");
    }

    private static void alterarSenha(Usuario usuario) {
      boolean senhaCorreta = false;
      do {
        System.out.println("Digite a senha atual (ou ENTER para sair):");
        var senhaAtual = scanner.next();
        if (senhaAtual.isBlank()) return;
        senhaCorreta = usuario.getSenha().equals(senhaAtual);
        if (!senhaCorreta) System.out.println("Senha incorreta!");
      } while (!senhaCorreta);
      System.out.println("Digite a nova senha:");
      var novaSenha = scanner.next();
      usuario.setSenha(novaSenha);
      System.out.println("Usuário alterado com sucesso!");
    }
}
