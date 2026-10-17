package interfaces.exercicio3;

public class Exercicio3 {
    public static void main(String[] args) {
        /* Escreva um código onde seja possível calcular a área de uma figura geométrica, 
           todas devem ter um método que retorne esse valor, as formas geométricas disponiveis 
           devem ser as seguintes:
           - Quadrado: possui o valor dos seus lados;
           - Retângulo: possui os valores de base e altura;
           - Circulo: possui o atributo raio. */
        FiguraGeometrica quadrado = new Quadrado(12);
        FiguraGeometrica triangulo = new Triangulo(12,12);
        FiguraGeometrica circulo = new Circulo(12);
        imprimirFigura(quadrado);
        imprimirFigura(triangulo);
        imprimirFigura(circulo);
    }

    private static void imprimirFigura(FiguraGeometrica figura) {
        System.out.printf("\n===Figura: %s===\n", figura.getClass().getSimpleName());
        System.out.println("Área: "+figura.calcularArea());
    }
}
