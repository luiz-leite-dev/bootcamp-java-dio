package interfaces.exercicio3;

public record Retangulo(double base, double altura) implements FiguraGeometrica {

    @Override
    public double getArea() {
        return base * altura;
    }

}
