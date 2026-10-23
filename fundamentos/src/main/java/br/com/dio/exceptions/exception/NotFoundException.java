package br.com.dio.exceptions.exception;

public class NotFoundException extends RuntimeException {

    public <T> NotFoundException(Class<T> clazz, Object id) {
        super("%s ID %s not found."
                .formatted(clazz.getSimpleName(), id).replace("Model", ""));
    }

}
