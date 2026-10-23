package br.com.dio.exceptions;

import java.time.OffsetDateTime;

import br.com.dio.exceptions.dao.UserDAO;
import br.com.dio.exceptions.exception.ValidatorException;
import br.com.dio.exceptions.model.UserModel;
import br.com.dio.exceptions.validator.UserValidator;

public class DaoExceptionsLesson {

    private final static UserDAO dao = new UserDAO();
    public static void main(String[] args) {
        UserModel user = new UserModel(0, "Luiz", "luiz@empresa.com", OffsetDateTime.now());
        UserModel user2 = new UserModel(0, "Ana", "ana@", OffsetDateTime.now());
        try {            
            UserValidator.verifyModel(user2);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        user = dao.save(user);
        user.setName("Luiz Leite");
        user = dao.update(user);
        user = dao.findById(1);
        System.out.println(user);
        dao.delete(1);
        user = dao.findById(1);
        System.out.println("Não vai imprimir essa mensagem!");
    }
}
