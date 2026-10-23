package enums;

import java.util.function.BiFunction;

public enum OperationEnum {

    SUM('+',(v1, v2) -> v1 + v2), 
    SUBTRACTION('-',(v1, v2) -> v1 - v2), 
    MULTIPLY('x',(v1, v2) -> v1 * v2), 
    DIVISION('/',(v1, v2) -> v1 / v2);

    private final char operation;
    private final BiFunction<Integer, Integer, Integer> calculate;

    OperationEnum(char operation, BiFunction<Integer, Integer, Integer> funcao) {
        this.operation = operation;
        this.calculate = funcao;
    }

    public BiFunction<Integer, Integer, Integer> getCalculate(){
        return this.calculate;
    }

    public char getOperation(){
        return this.operation;
    }

}
