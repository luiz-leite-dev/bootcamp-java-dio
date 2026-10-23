package br.com.dio.interfaces.exercicio3;

public record Quadrado(double lado) implements FiguraGeometrica {

    @Override
    public double getArea() {
        return lado * lado;
    }

}
