import java.util.Scanner;

public class Main {

    private final static String WELCOME_MESSAGE = "Qual o seu nome?";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        String name = scanner.next();
        System.out.println("E sua idade?");
        int idade = scanner.nextInt();
        System.out.printf("Olá %s, sua idade é %s.\n",name, idade);
        scanner.close();
    }
}
