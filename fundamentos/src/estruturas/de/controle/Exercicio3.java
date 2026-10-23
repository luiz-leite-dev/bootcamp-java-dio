package estruturas.de.controle;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        /* Escreva um código que o usuário entre com um primeiro número, 
         * um segundo número maior que o primeiro e escolhe entre a opção par e impar, 
         * com isso o código deve informar todos os números pares ou ímpares 
         * (de acordo com a seleção inicial) no intervalo de números informados, 
         * incluindo os números informados e em ordem decrescente;
         */
        var scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número:");
        var numero1 = scanner.nextInt();
        var numero2 = numero1;
        while (numero2 <= numero1) {
            System.out.printf("Digite um número maior que %s:",numero1);
            numero2 = scanner.nextInt();
        }
        var numerosPares = "";
        var numerosImpares = "";
        for (var i = numero2;i >= numero1;i--){
            if (i % 2 == 0) numerosPares += i + ", ";
            else numerosImpares += i + ", ";
        }
        System.out.printf("Pares: %s\n",numerosPares);
        System.out.printf("Ímpares: %s\n",numerosImpares);
        scanner.close();
    }
}
