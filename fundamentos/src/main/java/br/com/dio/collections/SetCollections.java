package br.com.dio.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCollections {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User(1, "João"));
        users.add(new User(2, "Maria"));
        users.add(new User(3, "José"));
        System.out.println(users.contains(new User(1, "João")));

        imprimirLista(users);

        Set<User> users2 = new LinkedHashSet<>();
        users2.add(new User(1, "João"));
        users2.add(new User(2, "Maria"));
        users2.add(new User(3, "José"));
        System.out.println(users2.contains(new User(1, "João")));

        imprimirLista(users2);

        Set<User> users3 = new TreeSet<>(Comparator.comparingInt(User::getCode).reversed());
        users3.add(new User(1, "João"));
        users3.add(new User(2, "Maria"));
        users3.add(new User(3, "José"));
        System.out.println(users3.contains(new User(1, "João")));

        imprimirLista(users3);
    }

    public static void imprimirLista(Set<User> users) {
        var iterator = users.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
