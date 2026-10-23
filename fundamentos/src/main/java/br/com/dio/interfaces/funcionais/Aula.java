package br.com.dio.interfaces.funcionais;

import java.util.List;
import java.util.function.Function;

public class Aula {
    public static void main(String[] args) {
        List<User> users = List.of(new User("João",21), new User("Maria", 32), new User("Lucas", 16));
        users.forEach(System.out::println);
        printStringValues(User::name, users);
        printStringValues(user -> String.valueOf(user.age()), users);
    }

    public static void printStringValues(Function<User, String> callback, List<User> users) {
        users.forEach(u -> System.out.println(callback.apply(u)));
    }
}
