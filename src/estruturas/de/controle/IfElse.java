package estruturas.de.controle;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o seu nome?");
        var nome = scanner.next();
        System.out.println("Qual a sua idade?");
        var idade = scanner.nextInt();
        System.out.println("Você é emancipado? (Sim, Não)");
        var emancipado = scanner.next();
        var canDrivePlus18 = idade >= 18;
        var canDrivePlus16 = idade >= 16 && emancipado.equals("Sim");
        if (canDrivePlus18) {
            System.out.printf("#1 - %s, você tem +18 anos e já pode dirigir!\n",nome);
        } else if (canDrivePlus16) {
            System.out.printf("#1 - %s, você tem +16 anos e já pode dirigir!\n",nome);
        } else {
            System.out.printf("#1 - %s, você não pode dirigir!\n",nome);
        }
        //Outra forma mais simplificadao seria:
        var resultado = "#2 - %s, você" + (canDrivePlus18 || canDrivePlus16 ? "": " não")+ " pode dirigir!";
        System.out.printf(resultado,nome);
        scanner.close();
    }
}
