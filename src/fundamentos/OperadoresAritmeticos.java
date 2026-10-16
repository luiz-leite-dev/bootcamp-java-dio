package fundamentos;
import java.util.Scanner;

public class OperadoresAritmeticos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro número: ");
        var value1 = scanner.nextFloat();
        System.out.println("Informe o segundo número: ");
        var value2 = scanner.nextFloat();
        System.out.println(value1 + " + " + value2 + " = " + (value1 + value2));
        System.out.println(value1 + " - " + value2 + " = " + (value1 - value2));
        System.out.println(value1 + " * " + value2 + " = " + (value1 * value2));
        System.out.println(value1 + " / " + value2 + " = " + (value1 / value2));
        System.out.println(value1 + " % " + value2 + " = " + (value1 % value2));
        System.out.println("Raiz quadrada de " + value1 + " = " + Math.sqrt(value1));
        System.out.println("Raiz quadrada de " + value2 + " = " + Math.sqrt(value2));
        System.out.printf("++primeiro = %s\n",++value1);
        System.out.printf("segundo-- = %s\n",value2--);
        System.out.printf("primeiro = %s\n",value1);
        System.out.printf("segundo = %s\n",value2);
        scanner.close();
    }
}