package streams.complex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexStreams {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(generateUsers());
        users.sort(Comparator.comparing(User::name, Comparator.reverseOrder()));
        users.forEach(System.out::println);

        System.out.println("=========");
        var users2 = users.stream().filter(u -> u.contacts().size() >=2).toList();
        users2.forEach(System.out::println);
        

        System.out.println("=========");
        var contacts = users.stream().flatMap(u -> u.contacts().stream());
        contacts.forEach(System.out::println);
        

        System.out.println("=========");
        var females = users.stream()
            .filter(u -> u.sex() == SexEnum.FEMALE)
            .collect(Collectors.toMap(User::name, user -> user));
        females.forEach((key, value) -> System.out.printf("key: %s | value: %s \n", key, value));
    }

    private static List<User> generateUsers() {
        var contacts1 = List.of(
            new Contact("(11)99999-99999", ContactType.EMAIL),
            new Contact("joao@gmail.com", ContactType.PHONE)
        );
        var contacts2 = List.of(
            new Contact("(21)9876-1234", ContactType.PHONE)
        );
        var contacts3 = List.of(
            new Contact("lucas@hotmail.com", ContactType.EMAIL)
        );
        var contacts4 = List.of(
            new Contact("ana@gmail.com", ContactType.EMAIL),
            new Contact("ana@hotmail.com", ContactType.EMAIL)
        );
        var contacts5 = List.of(
            new Contact("(31)1234-4312", ContactType.PHONE),
            new Contact("(31)1234-5433", ContactType.PHONE)
        );

        var user1 = new User("João", 25, SexEnum.MALE, contacts1);
        var user2 = new User("Maria", 33, SexEnum.FEMALE, contacts2);
        var user3 = new User("Lucas", 20, SexEnum.MALE, contacts3);
        var user4 = new User("Ana", 27, SexEnum.FEMALE, contacts4);
        var user5 = new User("Flavio", 16, SexEnum.MALE, contacts5);
        var user6 = new User("Rodrigo", 36, SexEnum.MALE, new ArrayList<>());
        return List.of(user1, user2, user3, user4, user5, user6);
    }
}
