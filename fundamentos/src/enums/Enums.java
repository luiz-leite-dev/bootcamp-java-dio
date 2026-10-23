package enums;

import java.util.Scanner;

public class Enums {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var option = -1;
        while (option != 5) {
            System.out.println("Escolha a operação:");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Sair");
            option = scanner.nextInt();
            if (option == 5) break;
            if (option > 5 || option < 0) {
                System.out.println("Opção inválida!");
                continue;
            }

            var selectedOption = OperationEnum.values()[option - 1];
            System.out.println(selectedOption);
            System.out.println("Digite o primeiro valor inteiro:");
            var v1 = scanner.nextInt();
            System.out.println("Digite o segundo valor inteiro:");
            var v2 = scanner.nextInt();
            var result = selectedOption.getCalculate().apply(v1, v2);
            System.out.printf("%s %s %s = %s\n\n",v1,selectedOption.getOperation(),v2,result);
        }
    }
}
