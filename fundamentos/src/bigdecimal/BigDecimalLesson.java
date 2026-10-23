package bigdecimal;

import java.math.BigDecimal;

public class BigDecimalLesson {
    public static void main(String[] args) {
        System.out.println("====double====");
        var value1 = 0.1;
        var value2 = 0.2;
        System.out.println(value1 + value2);
        System.out.println(2.00 - 1.1);
        System.out.println(2.00 - 1.2);
        System.out.println(2.00 - 1.3);
        System.out.println(2.00 - 1.4);
        System.out.println(2.00 - 1.5);
        System.out.println(2.00 - 1.6);
        System.out.println("====float====");
        var value3 = 0.1f;
        var value4 = 0.2f;
        System.out.println(value3 + value4);
        System.out.println(2.00f - 1.1f);
        System.out.println(2.00f - 1.2f);
        System.out.println(2.00f - 1.3f);
        System.out.println(2.00f - 1.4f);
        System.out.println(2.00f - 1.5f);
        System.out.println(2.00f - 1.6f);
        System.out.println("====Double====");
        Double value5 = 0.1;
        Double value6 = 0.2;
        System.out.println(value5 + value6);
        System.out.println(Double.valueOf(2.00) - Double.valueOf(1.1));
        System.out.println(Double.valueOf(2.00) - Double.valueOf(1.2));
        System.out.println(Double.valueOf(2.00) - Double.valueOf(1.3));
        System.out.println(Double.valueOf(2.00) - Double.valueOf(1.4));
        System.out.println(Double.valueOf(2.00) - Double.valueOf(1.5));
        System.out.println(Double.valueOf(2.00) - Double.valueOf(1.6));
        System.out.println("====Float====");
        Float value7 = 0.1f;
        Float value8 = 0.2f;
        System.out.println(value7 + value8);
        System.out.println(Float.valueOf(2.00f) - Float.valueOf(1.1f));
        System.out.println(Float.valueOf(2.00f) - Float.valueOf(1.2f));
        System.out.println(Float.valueOf(2.00f) - Float.valueOf(1.3f));
        System.out.println(Float.valueOf(2.00f) - Float.valueOf(1.4f));
        System.out.println(Float.valueOf(2.00f) - Float.valueOf(1.5f));
        System.out.println(Float.valueOf(2.00f) - Float.valueOf(1.6f));
        System.out.println("====BigDecimal====");
        BigDecimal value9 = new BigDecimal("0.1");
        BigDecimal value10 = new BigDecimal("0.2");
        System.out.println(value9.add(value10));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.1)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.2)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.3)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.4)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.5)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.6)));
    }
}
