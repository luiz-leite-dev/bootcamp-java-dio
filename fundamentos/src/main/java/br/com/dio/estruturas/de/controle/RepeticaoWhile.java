package br.com.dio.estruturas.de.controle;
import java.util.Scanner;

public class RepeticaoWhile {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var name = "";
        while (!name.equalsIgnoreCase("exit")) {
            System.out.println("#While - Digite um nome ou 'exit' para sair:");
            name = scanner.next();
        }
        do {
            System.out.println("#DoWhile - Digite um nome ou 'exit' para sair:");
            name = scanner.next();
        } while (!name.equalsIgnoreCase("exit"));
        scanner.close();
    }
}
