package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapObjects {
    public static void main(String[] args) {
        System.out.println("===HashMap===");
        Map<String, User> users = new HashMap<>();
        users.put("joao@empresa.com", new User(1, "João"));
        users.put("maria@empresa.com", new User(2, "Maria"));
        users.put("jose@empresa.com", new User(3, "José"));
        users.put("ana@empresa.com", new User(4, "Ana"));
        System.out.println(users);
        System.out.println("==================");
        users.keySet().forEach(System.out::println);
        System.out.println("==================");
        users.values().forEach(System.out::println);


        System.out.println("===TreeMap===");
        Map<String, User> users2 = new TreeMap<>();
        users2.put("joao@empresa.com", new User(1, "João"));
        users2.put("maria@empresa.com", new User(2, "Maria"));
        users2.put("jose@empresa.com", new User(3, "José"));
        users2.put("ana@empresa.com", new User(4, "Ana"));
        System.out.println(users2);
        System.out.println("==================");
        users2.keySet().forEach(System.out::println);
        System.out.println("==================");
        users2.values().forEach(System.out::println);


        System.out.println("===LinkedHashMap===");
        Map<String, User> users3 = new LinkedHashMap<>();
        users3.put("joao@empresa.com", new User(1, "João"));
        users3.put("maria@empresa.com", new User(2, "Maria"));
        users3.put("jose@empresa.com", new User(3, "José"));
        users3.put("ana@empresa.com", new User(4, "Ana"));
        System.out.println(users3);
        System.out.println("==================");
        users3.keySet().forEach(System.out::println);
        System.out.println("==================");
        users3.values().forEach(System.out::println);
    }
}
