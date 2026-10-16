package classes.mais.encapsulamento;

public class PrimeiraClasse {
    public static void main(String[] args) {
        var person = new Person("João");
        person.setAge(12);
        System.out.printf("%s tem %s anos.\n",person.getName(), person.getAge());
        var person2 = new Person("Maria");
        person2.setAge(26);
        System.out.printf("%s tem %s anos.\n",person2.getName(), person2.getAge());
    }
}
