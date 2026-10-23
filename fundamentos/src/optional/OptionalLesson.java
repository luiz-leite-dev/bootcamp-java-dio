package optional;

import java.util.Optional;

public class OptionalLesson {
    public static void main(String[] args) {
        Optional<User> optional = Optional.empty();
        System.out.println(optional);

        optional = Optional.ofNullable(null);
        optional.ifPresent(System.out::println);

        optional = Optional.of(new User("João", 36, SexEnum.MALE));
        System.out.println(optional);

        // orElse = Executa o método mesmo se houver algo a retornar no optional
        System.out.println(optional.orElse(getUserDefault()));
        // orElseGet = Só executa o método se não houver algo a retornar no optional
        System.out.println(optional.orElseGet(OptionalLesson::getUserDefault));
    }

    public static User getUserDefault(){
        System.out.println("Retornando usuário padrão!");
        return new User("Maria",22,SexEnum.FEMALE);
    }
}
