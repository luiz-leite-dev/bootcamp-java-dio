package strings;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        /* Escreva um código que cria uma calculadora para as operações de soma e subtração, 
           o usuário deve informar todos os números que serão usados na conta de uma só vez 
           utilizando virgulas para separa-los. */
        Scanner scanner = new Scanner(System.in);
        var opcao = -1;
        while (opcao != 3) {
            System.out.println("Escolha uma operação:");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Sair");
            opcao = scanner.nextInt();
            if (opcao == 3) break;
            if (opcao < 1 || opcao > 3) {
                System.out.println("Opção inválida!");
                continue;
            }
            Operacao operacao = Operacao.values()[opcao-1];
            System.out.println("Digite os valores separados por vírgula:");
            var valores = scanner.next();
            var valoresArray = valores.split(",");
            var numeros = Arrays.stream(valoresArray).map(Long::valueOf).toArray(Long[]::new);
            System.out.printf("Resultado: %s = %s\n\n",valores.replaceAll(",", operacao.getSinal()),operacao.calcular(numeros));
        }
    }
}
