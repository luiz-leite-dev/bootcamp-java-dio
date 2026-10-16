package fundamentos;

public class OperadoresBitwise {
    public static void main(String[] args) {
        var value1 = 6;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro número da operação %s (representação binária %s)\n",value1, binary1);
    
        var value2 = 5;
        var binary2 = Integer.toBinaryString(value2);
        System.out.printf("Segundo número da operação %s (representação binária %s)\n",value2, binary2);
        var resultOR = value1 | value2;
        var binaryResult = Integer.toBinaryString(resultOR);
        System.out.printf("%s | %s = %s (binário = %s)\n",value1,value2,resultOR,binaryResult);
        var resultAND = value1 & value2;
        var binaryResultAnd = Integer.toBinaryString(resultAND);
        System.out.printf("%s | %s = %s (binário = %s)\n",value1,value2,resultAND,binaryResultAnd);
        var resultXOR = value1 ^ value2;
        var binaryResultXor = Integer.toBinaryString(resultXOR);
        System.out.printf("%s | %s = %s (binário = %s)\n",value1,value2,resultXOR,binaryResultXor);
        var resultComplement = ~value1;
        var binaryComplement = Integer.toBinaryString(resultComplement);
        System.out.printf("~%s = %s (binário = %s)\n",value1,resultComplement,binaryComplement);
        var resultLeftShift = value1 << value2;
        var binaryLeftShift = Integer.toBinaryString(resultLeftShift);
        System.out.printf("%s << %s = %s (binário = %s)\n",value1,value2,resultLeftShift,binaryLeftShift);
        var resultRightShift = value1 >> value2;
        var binaryRightShift = Integer.toBinaryString(resultRightShift);
        System.out.printf("%s >> %s = %s (binário = %s)\n",value1,value2,resultRightShift,binaryRightShift);
        var resultRightShiftUnsign = value1 >>> value2;
        var binaryRightShiftUnsign = Integer.toBinaryString(resultRightShiftUnsign);
        System.out.printf("%s >>> %s = %s (binário = %s)\n",value1,value2,resultRightShiftUnsign,binaryRightShiftUnsign);
    }
}
