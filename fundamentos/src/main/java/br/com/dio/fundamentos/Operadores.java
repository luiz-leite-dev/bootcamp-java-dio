package br.com.dio.fundamentos;
import java.util.Scanner;

public class Operadores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quanto é 2 + 2?");
        int result = scanner.nextInt();
        var isWrong = result != 4;
        System.out.printf("O resultado esperado é 4. Você acertou? (%s).\n",!isWrong);

        System.out.println("Qual a sua idade?");
        var age = scanner.nextInt();
        System.out.println("Você é emancipado?");
        var isEmancipated = scanner.nextBoolean();
        var legalAge = 18;
        var canDrive = (age >= legalAge) || (age >= 16 && isEmancipated);
        if (canDrive) {
            System.out.println("Você pode dirigir!");
        } else {
            System.out.println("Você não pode dirigir!");
        }
        scanner.close();
    }
}
