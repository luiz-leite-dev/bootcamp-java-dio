package exceptions.validator;

import exceptions.exception.ValidatorException;
import exceptions.model.UserModel;

public class UserValidator {

    public UserValidator() {
    }

    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getName())) 
            throw new ValidatorException("Informe um nome válido.");
        if (model.getName().length() <= 1)
            throw new ValidatorException("O nome precisa ter mais de um caractere.");
        if (stringIsBlank(model.getEmail()) || !model.getEmail().contains("@") || !model.getEmail().contains("."))
            throw new ValidatorException("Informe um e-mail válido.");
    }

    private static boolean stringIsBlank(final String value) {
        return value == null || value.isBlank();
    }

}
