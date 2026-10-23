package strings;

import java.util.Arrays;

public enum Operacao {

    SOMA("+", (values) -> Arrays.stream(values).mapToLong(Long::longValue).sum()), 
    SUBTRACAO("-", (values) -> Arrays.stream(values).mapToLong(Long::longValue).reduce((a, b) -> a - b).orElse(0L));

    private String sinal;
    private Calc<Long> calculationCallback;

    Operacao(String sinal, Calc<Long> calculationCallback) {
        this.sinal = sinal;
        this.calculationCallback = calculationCallback;
    }

    public Long calcular(Long[] valores) {
        return this.calculationCallback.calculate(valores);
    }

    public String getSinal() {
        return this.sinal;
    }

}
