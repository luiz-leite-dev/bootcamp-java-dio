package exceptions;

import java.time.OffsetDateTime;

import exceptions.dao.UserDAO;
import exceptions.exception.ValidatorException;
import exceptions.model.UserModel;
import exceptions.validator.UserValidator;

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
