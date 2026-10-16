package fundamentos;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro nome:");
        var nome1 = scanner.next();
        System.out.printf("Digite a idade de %s:\n",nome1);
        var idade1 = scanner.nextInt();
        System.out.println("Digite o segundo nome:");
        var nome2 = scanner.next();
        System.out.printf("Digite a idade de %s:\n",nome2);
        var idade2 = scanner.nextInt();
        System.out.printf("A diferença de idade entre %s e %s é %s.\n",nome1,nome2,idade1-idade2);
        scanner.close();
    }
}
