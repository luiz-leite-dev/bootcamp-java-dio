package heranca.mais.polimorfismo;

import heranca.mais.polimorfismo.Filme.Tipo;

public class Exercicio1 {

    public static double VALOR_INTEIRA = 10;
    public static void main(String[] args) {
        /* Crie uma hierarquia de classes para tratar os tipos de ingresso 
         * que podem ser comercializados em um cinema. 
         * O ingresso deve ter um valor, nome do filme e informar se é dublado ou legendado. 
         * A partir desse ingresso devem ser criados os tipos Meia entrada e ingresso família. 
         * Cada ingresso deve ter um método que retorna o seu valor real 
         * ( baseado no valor informado na criação do ingresso) 
         * para os de meia entrada o seu valor deve ser de metade do valor, 
         * para os ingressos família deve-se retornar o valor multiplicado pelo número de pessoas 
         * e fornecer um desconto de 5% quando o número de pessoas for maior que 3. */
        Filme filme = new Filme("Harry Potter", Tipo.DUBLADO);
        Ingresso ingressoInteira = new Ingresso(filme, VALOR_INTEIRA);
        Ingresso ingressoMeia = new IngressoMeia(filme, VALOR_INTEIRA);
        IngressoFamilia ingressoFamilia = new IngressoFamilia(filme, VALOR_INTEIRA, 4);

        System.err.println("Ingresso Inteira custa R$ "+ingressoInteira.getValor());
        System.err.println("Ingresso Meia custa R$ "+ingressoMeia.getValor());
        System.err.println("Ingresso Família para "+ingressoFamilia.getNumeroDePessoas()+" pessoas custa R$ "+ingressoFamilia.getValor());
    }
}
