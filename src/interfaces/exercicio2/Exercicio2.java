package interfaces.exercicio2;

import heranca.mais.polimorfismo.exercicio1.Filme.Tipo;

public class Exercicio2 {
    public static void main(String[] args) {
        /* Escreva um código que calcule o valor de tributos de produtos, 
           os produtos disponíveis devem ser dos seguintes tipos: 
              Alimentação, Saude e bem estar, Vestuário e Cultura. 
           Todos os produtos devem ter um método para retornar o seu valor de imposto, 
           de acordo com seu tipo:
           - Alimentação 1%;
           - Saude e bem estar 1.5%;
           - Vestuário 2.5%;
           - Cultura 4%. */
        Produto batata = new Produto("Batata", 1.2, Produto.Tipo.ALIMENTACAO);
        Produto cenoura = new Produto("Cenoura", 0.9, Produto.Tipo.ALIMENTACAO);
        Produto livro = new Produto("Livro", 35, Produto.Tipo.CULTURA);
        Produto escova = new Produto("Escova", 9.99, Produto.Tipo.SAUDE_E_BEM_ESTAR);
        Produto jaqueta = new Produto("Jaqueta", 125.99, Produto.Tipo.VESTUARIO);
        imprimirProduto(batata);
        imprimirProduto(cenoura);
        imprimirProduto(livro);
        imprimirProduto(escova);
        imprimirProduto(jaqueta);
    }

    private static void imprimirProduto(Produto batata) {
        System.out.printf("\n===Produto: %s===\n",batata.getNome());
        System.out.printf("Preço: %s\n",batata.getPreco());
        System.out.printf("Imposto: %s\n",batata.calcularTributos());
    }
}
