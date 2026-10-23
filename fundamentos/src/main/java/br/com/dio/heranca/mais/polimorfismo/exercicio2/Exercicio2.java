package br.com.dio.heranca.mais.polimorfismo.exercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio2 {

    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado = null;
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
        scanner.useDelimiter("\n");
        Gerente gerente = new Gerente("João", "joao@empresa.com", "123456");
        Vendedor vendedor = new Vendedor("Lucas", "lucas@empresa.com", "123321", 0);
        gerente.setVendedores(Arrays.asList(vendedor));
        Atendente atendente = new Atendente("Ana", "ana@empresa.com", "1234321", 0);

        while (true) {
          while (usuarioLogado == null) {
            System.out.println("===Tela de login===");
            System.out.println("Usuário (e-mail ou ENTER para Sair):");
            var email = scanner.next();
            if (email.isBlank()) System.exit(0);
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
          }
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
            case 1 -> fazerLogoff();
            case 2 -> alterarDados();
            case 3 -> alterarSenha();
            case 4 -> consultarVendas();
            case 5 -> gerarRelatorioFinaceiro();
            case 6 -> realizarVenda();
            case 7 -> receberPagamento();
            case 8 -> fecharCaixa();
          }
        }
    }

    private static void fecharCaixa() {
      if (usuarioLogado instanceof Atendente atendente) {
        atendente.fecharCaixa();
        System.out.println("Fechado caixa do atendente!");
      }
    }

    private static void receberPagamento() {
      if (usuarioLogado instanceof Atendente atendente) {
        System.out.println("Digite o valor a receber:");
        var valor = scanner.nextDouble();
        atendente.receberValor(valor);
        System.out.println("Valor recebido com sucesso!");
      }
    }

    private static void realizarVenda() {
      if (usuarioLogado instanceof Vendedor vendedor) {
        System.out.println("Digite o valor da venda:");
        var valor = scanner.nextDouble();
        vendedor.realizarVenda(valor);
        System.out.println("Venda realizada com sucesso!");
      }
    }

    private static void gerarRelatorioFinaceiro() {
      if (usuarioLogado instanceof Gerente gerente) {
          System.out.println("====Relatório Financeiro====");
          gerente.getVendedores().stream().forEach(vendedor -> {
            System.out.println("Vendedor: "+vendedor.getNome());
            System.out.println("Vendas: R$ "+vendedor.getTotalVendas());
          });
          System.out.println("----------------------------");
          System.out.println("Vendas Total: R$ "+gerente.getTotalVendas());
          System.out.println("============================");
      }
    }

    private static void consultarVendas() {
      if (usuarioLogado instanceof Gerente gerente) {
        System.out.println("O total de vendas dos vendedores é R$ "+gerente.getTotalVendas());
      } else if (usuarioLogado instanceof Vendedor vendedor) {
        System.out.println("Seu total de vendas é R$ "+vendedor.getTotalVendas());
      }
    }

    private static void fazerLogoff() {
      usuarioLogado = null;      
      System.out.println("Sistema encerrado!");
    }

    private static void alterarDados() {
      System.out.println("Digite o nome:");
      var nome = scanner.next();
      System.out.println("Digite o e-mail:");
      var email = scanner.next();
      usuarioLogado.setNome(nome);
      usuarioLogado.setEmail(email);
      System.out.println("Usuário alterado com sucesso!");
    }

    private static void alterarSenha() {
      boolean senhaCorreta = false;
      do {
        System.out.println("Digite a senha atual (ou ENTER para sair):");
        var senhaAtual = scanner.next();
        if (senhaAtual.isBlank()) return;
        senhaCorreta = usuarioLogado.getSenha().equals(senhaAtual);
        if (!senhaCorreta) System.out.println("Senha incorreta!");
      } while (!senhaCorreta);
      System.out.println("Digite a nova senha:");
      var novaSenha = scanner.next();
      usuarioLogado.setSenha(novaSenha);
      System.out.println("Usuário alterado com sucesso!");
    }
}
