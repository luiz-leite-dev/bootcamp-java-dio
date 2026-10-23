package br.com.dio.interfaces.exercicio3;

public record Circulo(double raio) implements FiguraGeometrica {

    @Override
    public double getArea() {
        return Math.PI * Math.pow(raio, 2);
    }
}
