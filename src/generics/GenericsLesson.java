package generics;

import generics.dao.GenericDAO;
import generics.dao.UserDAO;
import generics.domain.UserDomain;

public class GenericsLesson {

    private final static GenericDAO<Integer, UserDomain> dao = new UserDAO();
    public static void main(String[] args) {
        var user = new UserDomain(1, "João", 36);
        System.out.println(dao.count());
        System.out.println(dao.save(user));
        System.out.println(dao.findAll());
        System.out.println(dao.find(u -> u.getId().equals(1)));
        System.out.println(dao.find(u -> u.getId().equals(2)));
        System.out.println(dao.count());
        System.out.println(dao.delete(new UserDomain(0, "", -1)));
        user.setAge(12);
        System.out.println(dao.update(user));
        System.out.println(dao.delete(user));
        System.out.println(dao.findAll());
        System.out.println(dao.count());
    }
}
