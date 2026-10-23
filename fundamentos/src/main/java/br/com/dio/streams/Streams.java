package br.com.dio.streams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        var values1 = Stream.generate(() -> new Random().nextInt()).limit(5).toArray(Integer[]::new);
        for (var v : values1) {
            System.out.println(v);
        }
        System.out.println("==============");
        var values2 = IntStream.generate(() -> new Random().nextInt()).limit(5).toArray();
        for (var v : values2) {
            System.out.println(v);
        }
        System.out.println("==============");
        var values3 = Stream.of("Maria","João","José","Lucas", "Ana")
            .filter(name -> name.endsWith("a"))
            .toList();
        System.out.println(values3);
        System.out.println("==============");
        List<Integer> values4 = List.of(3, 6, 9, 12);
        List<Integer> values5 = List.of(1,2,3,4,5,6,7,8,9,10,11,12);
        var newValues = values5.stream()
            .parallel()
            .filter(values4::contains)
            .peek(n -> System.out.printf("Filter %s\n",n))
            .map(n -> values4.stream().reduce(n, (n1, n2) -> n1 - n2))
            .peek(n -> System.out.printf("Map %s\n", n))
            .collect(Collectors.toList());
        System.out.println(newValues);
    }
}
