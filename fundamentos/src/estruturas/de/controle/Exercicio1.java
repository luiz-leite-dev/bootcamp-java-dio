package estruturas.de.controle;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        // Escreva um código onde o usuário entra com um número 
        // e seja gerada a tabuada de 1 até 10 desse número;
        var scanner = new Scanner(System.in);
        System.out.println("Digite um número para saber sua tabuada:");
        var numero = scanner.nextInt();
        for (var i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
        scanner.close();
    }
}
