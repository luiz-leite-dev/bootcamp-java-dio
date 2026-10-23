package br.com.dio.estruturas.de.controle;
import java.util.Scanner;

public class RepeticaoFor {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        for (;;){
            System.out.println("Digite um nome:");
            var nome = scanner.next();

            if (nome.equalsIgnoreCase("exit")) break;

            System.out.println(nome);
        }
        scanner.close();
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}