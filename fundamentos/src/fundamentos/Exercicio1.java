package fundamentos;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("# Exercício 1");
        System.out.println("Digite seu nome:");
        var nome = scanner.next();
        System.out.println("Digite seu ano de nascimento:");
        var ano = scanner.nextInt();
        var anoAtual = 2026;
        System.out.printf("Olá %s, você completa %s anos em 2026.\n",nome,anoAtual - ano);
        scanner.close();
    }
}
