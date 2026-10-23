package br.com.dio.generics;

import br.com.dio.generics.dao.ClientDAO;
import br.com.dio.generics.dao.GenericDAO;
import br.com.dio.generics.dao.UserDAO;
import br.com.dio.generics.domain.ClientDomain;
import br.com.dio.generics.domain.UserDomain;

public class GenericsLesson {

    private final static GenericDAO<Integer, UserDomain> userDAO = new UserDAO();
    private final static GenericDAO<String, ClientDomain> clientDAO = new ClientDAO();
    public static void main(String[] args) {
        System.out.println("====UserDAO====");
        var user = new UserDomain(1, "João", 36);
        System.out.println(userDAO.count());
        System.out.println(userDAO.save(1, user));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.find(u -> u.getId().equals(1)));
        System.out.println(userDAO.find(u -> u.getId().equals(2)));
        System.out.println(userDAO.count());
        System.out.println(userDAO.delete(new UserDomain(0, "", -1)));
        user.setAge(12);
        System.out.println(userDAO.update(user));
        System.out.println(userDAO.delete(user));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.count());

        System.out.println("====ClientDAO====");
        var client = new ClientDomain("1", "João", 36);
        System.out.println(clientDAO.count());
        System.out.println(clientDAO.save(1, client));
        System.out.println(clientDAO.findAll());
        System.out.println(clientDAO.find(c -> c.getId().equals("1")));
        System.out.println(clientDAO.find(c -> c.getId().equals("2")));
        System.out.println(clientDAO.count());
        System.out.println(clientDAO.delete(new ClientDomain("0", "", -1)));
        client.setAge(12);
        System.out.println(clientDAO.update(client));
        System.out.println(clientDAO.delete(client));
        System.out.println(clientDAO.findAll());
        System.out.println(clientDAO.count());
    }
}
