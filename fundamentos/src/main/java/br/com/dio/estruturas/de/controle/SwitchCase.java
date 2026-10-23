package br.com.dio.estruturas.de.controle;
import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe um número de 1 a 7:");
        var numero = scanner.nextInt();
        System.out.println("Switch Case Forma #1");
        switch (numero) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sábado");
                break;
        
            default:
                System.out.println("Opção inválida!");
                break;
        }

        System.out.println("Switch Case Forma #2");
        var resultado = switch (numero) {
            case 1, 7 -> {
                var dia = numero == 1 ? "domingo" : "sábado";
                yield String.format("Hoje é %s, fim de semana uhuuu \\o/",dia);
            }
            case 2 -> "Segunda";
            case 3 -> "Terça";
            case 4 -> "Quarta";
            case 5 -> "Quinta";
            case 6 -> "Sexta";
            default -> "Opção inválida!";
        };
        System.out.println(resultado);
        scanner.close();
    }
}
