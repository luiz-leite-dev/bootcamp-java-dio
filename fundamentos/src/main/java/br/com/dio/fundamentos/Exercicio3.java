package br.com.dio.fundamentos;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a base do retângulo:");
        var base = scanner.nextInt();
        System.out.println("Digite a altura do retângulo:");
        var altura = scanner.nextInt();
        System.out.printf("A área do retângulo é: %s\n",base * altura);
        scanner.close();
    }
}
