package br.com.dio.collections;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListCollections {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "João"));
        users.add(new User(2, "Maria"));
        users.add(new User(3, "José"));
        System.out.println(users);
        System.out.println(users.getFirst().equals(new User(1, "João")));

        var arrayStart = OffsetDateTime.now();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            array.add(i);
        }
        System.out.println(Duration.between(arrayStart, OffsetDateTime.now()).toMillis());

        var vectorStart = OffsetDateTime.now();
        List<Integer> vector = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            vector.add(i);
        }
        System.out.println(Duration.between(vectorStart, OffsetDateTime.now()).toMillis());

        var linkedStart = OffsetDateTime.now();
        List<Integer> linked = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            linked.add(i);
        }
        System.out.println(Duration.between(linkedStart, OffsetDateTime.now()).toMillis());
    }
}
