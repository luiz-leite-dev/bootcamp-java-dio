package classes.mais.encapsulamento;

import java.util.Scanner;

import classes.mais.encapsulamento.Carro.Direcao;
import classes.mais.encapsulamento.Carro.Marcha;

public class Exercicio3 {
    public static void main(String[] args) {
        /* Todos os execicios devem ter um menu de interativo para chamar as funções 
         * e ter uma opção de sair para finalizar a execução.
         * Escreva um código onde temos o controle de banho de um petshop, a maquina de banhos dos pets deve ter as seguintes operações:
         * - Dar banho no pet;
         * - Abastecer com água;
         * - Abastecer com shampoo;
         * - verificar nivel de água;
         * - verificar nivel de shampoo;
         * - verificar se tem pet no banho;
         * - colocar pet na maquina;
         * - retirar pet da máquina;
         * - limpar maquina.
         * Siga as seguintes regras para implementação:
         * - A maquina de banho deve permitir somente 1 pet por vez;
         * - Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
         * - A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
         * - Se o pet for retirado da maquina sem estar limpo será necessário limpar a máquina para permitir a entrada de outro pet;
         * - A limpeza da máquina ira consumir 3 litros de água e 1 litro de shampoo;
         * - O abastecimento de água e shampoo deve permitir 2 litros por vez que for acionado;
         */
        MaquinaBanhoPet maquina = new MaquinaBanhoPet();
        var scanner = new Scanner(System.in);        System.out.println("==== MENU ====");
        System.out.println("1 - Dar banho no pet");
        System.out.println("2 - Abastecer com água");
        System.out.println("3 - Abastecer com shampoo");
        System.out.println("4 - Verificar nível de água");
        System.out.println("5 - Verificar nível de shampoo");
        System.out.println("6 - Verificar se tem pet no banho");
        System.out.println("7 - Colocar pet na máquina");
        System.out.println("8 - Retirar pet da máquina");
        System.out.println("9 - Limpar máquina");
        System.out.println("0 - Sair");
        System.out.println("==============");
        while (true) {
            System.out.println("Digite a opção:");
            var opcao = scanner.nextInt();
            if (opcao == 0) break;
            try {
                switch (opcao) {
                    case 1 -> maquina.darBanho();
                    case 2 -> maquina.abastecerAgua();
                    case 3 -> maquina.abastecerShampoo();
                    case 4 -> System.out.printf("Nível de água: %sL\n",maquina.getNivelAguaLitros());
                    case 5 -> System.out.printf("Nível de shampoo: %sL\n",maquina.getNivelShampooLitros());
                    case 6 -> {
                        if (maquina.banhoIniciado()) {
                            System.out.printf("O pet %s está no banho agora!\n",maquina.getNomePet());
                        } else if (maquina.temPet()) {
                            System.out.printf("O pet %s está na máquina agora!\n",maquina.getNomePet());
                        } else {
                            System.out.println("Não há pet na máquina!");
                        }
                    }
                    case 7 -> {
                        System.out.println("Digite o nome do pet:");
                        var nomePet = scanner.next();
                        maquina.setNomePet(nomePet);
                    }
                    case 8 -> maquina.setNomePet(null);
                    case 9 -> maquina.limpar();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
