package br.com.dio.classes.mais.encapsulamento;

import java.util.Scanner;

import br.com.dio.classes.mais.encapsulamento.Carro.Direcao;
import br.com.dio.classes.mais.encapsulamento.Carro.Marcha;

public class Exercicio2 {
    public static void main(String[] args) {
        /* todos os execicios devem ter um menu de interativo para chamar as funções 
         * e ter uma opção de sair para finalizar a execução
         * Escreva um código onde controlamos as funções de um carro, ele deve ter as seguintes funções:
         * - Ligar o carro;
         * - Desligar o carro;
         * - Acelerar;
         * - diminuir velocidade;
         * - virar para esquerda/direita
         * - verificar velocidade;
         * - trocar a marcha
         * - Siga as seguintes regras na implementação:
         *   - Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade em 0
         *   - O carro desligado não pode realizar nenhuma função;
         *   - Quando o carro for acelerado ele deve incrementar 1km em sua velocidade (pode chegar no máximo a 120km);
         *   - Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade (pode chegar no minimo a 0km);
         *   - o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
         *   - A velocidade do carro deve respeitar os seguintes limites para cada velocidade
         *   - se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar
         *   - se estiver na 1ª marcha sua velocidade pode estar entre 0km e 20km
         *   - se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km
         *   - se estiver na 3ª marcha sua velocidade pode estar entre 41km e 60km
         *   - se estiver na 4ª marcha sua velocidade pode estar entre 61km e 80km
         *   - se estiver na 5ª marcha sua velocidade pode estar entre 81km e 100km
         *   - se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km
         *   - O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em 0 km
         *   - O carro só pode virar para esquerda/direita se sua velocidade for de no mínimi 1km e no máximo 40km;
         */
        var carro = new Carro();
        var scanner = new Scanner(System.in);

        System.out.println("==== MENU ====");
        System.out.println("1 - Ligar carro");
        System.out.println("2 - Desligar carro");
        System.out.println("3 - Acelerar");
        System.out.println("4 - Diminuir velocidade");
        System.out.println("5 - Virar para esquerda/direita");
        System.out.println("6 - Verificar velocidade");
        System.out.println("7 - Trocar a marcha");
        System.out.println("9 - Sair");
        System.out.println("==============");
        while (true) {
            System.out.println("Digite a opção:");
            var opcao = scanner.nextInt();
            if (opcao == 9) break;
            try {
                switch (opcao) {
                    case 1 -> carro.ligar();
                    case 2 -> carro.desligar();
                    case 3 -> carro.acelerar();
                    case 4 -> carro.desacelerar();
                    case 5 -> {
                        System.out.println("Digite uma das opções: 0 - Ir em frente, 1 - Virar à esquerda, 2 - Virar à direita");
                        Direcao direcao = Direcao.values()[scanner.nextInt()];
                        switch (direcao) {
                            case EM_FRENTE -> carro.irEmFrente();
                            case ESQUERDA -> carro.virarAEsquerda();
                            case DIREITA -> carro.virarADireita();
                        }
                    }
                    case 6 -> System.out.println("Velocidade atual: "+carro.getVelocidade());
                    case 7 -> {
                        System.out.println("Digite a marcha para a qual quer trocar:");
                        Marcha marcha = Marcha.values()[scanner.nextInt()];
                        carro.trocarMarcha(marcha);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
