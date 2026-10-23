package fundamentos;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho de um lado do quadrado:");
        var ladoQuadrado = scanner.nextInt();
        var area = ladoQuadrado * ladoQuadrado;
        System.out.printf("Área do quadrado = %s\n",area);
        scanner.close();
    }
}
