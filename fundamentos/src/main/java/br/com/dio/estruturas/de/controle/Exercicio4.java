package br.com.dio.estruturas.de.controle;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        /* Escreva um código onde o usuário informa um número inicial, 
         * posteriormente irá informar outros N números, 
         * a execução do código irá continuar até que o número informado 
         * dividido pelo primeiro número tenha resto diferente de 0 na divisão, 
         * números menores que o primeiro número devem ser ignorados 
         * */
        var scanner = new Scanner(System.in);
        System.out.println("Digite um número:");
        var numero1 = scanner.nextInt();
        var numero2 = numero1;
        do {
            System.out.printf("Digite um número maior que %s:\n",numero1);
            numero2 = scanner.nextInt();
        } while ((numero2 <= numero1) || (numero2 % numero1) != 0);
        scanner.close();
    }
}
