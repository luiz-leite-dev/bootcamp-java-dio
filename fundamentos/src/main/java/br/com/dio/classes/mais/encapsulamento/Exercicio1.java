package br.com.dio.classes.mais.encapsulamento;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        /* todos os execicios devem ter um menu de interativo para chamar as funções 
         * e ter uma opção de sair para finalizar a execução.
         * Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
           - Consultar saldo
           - consultar cheque especial
           - Depositar dinheiro;
           - Sacar dinheiro;
           - Pagar um boleto.
           - Verificar se a conta está usando cheque especial.
           - Siga as seguintes regras para implementar:
             - A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
             - O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
             - Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
             - Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
             - Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
         **/
        var novaConta = new ContaBancaria(5000);
        var scanner = new Scanner(System.in);
        System.out.println("==== MENU ====");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Consultar cheque especial");
        System.out.println("3 - Depositar dinheiro");
        System.out.println("4 - Sacar dinheiro");
        System.out.println("5 - Pagar boleto");
        System.out.println("6 - Verificar se está usando cheque especial");
        System.out.println("9 - Sair");
        System.out.println("==============");
        while (true){
            System.out.println("Digite a opção:");
            var opcao = scanner.nextInt();
            if (opcao == 9) break;
            switch (opcao) {
                case 1 -> System.out.println("Saldo: "+novaConta.getSaldo());
                case 2 -> System.out.println("Cheque especial: " + novaConta.getLimiteChequeEspecial());
                case 3 -> {
                    System.out.println("Digite o valor a depositar:");
                    var valor = scanner.nextFloat();
                    try {
                        novaConta.depositarDinheiro(valor);                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Digite o valor a sacar:");
                    var valor = scanner.nextFloat();
                    try {
                        novaConta.sacarDinheiro(valor);                     
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("Digite o valor a pagar:");
                    var valor = scanner.nextFloat();
                    try {
                        novaConta.pagarBoleto(valor);                     
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> System.out.println("Você" + (novaConta.usandoChequeEspecial() ? "" : " não") + " está usando o cheque especial!");
            }
        }
        scanner.close();
    }
}
