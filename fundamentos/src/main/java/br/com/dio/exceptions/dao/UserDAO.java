package br.com.dio.exceptions.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.dio.exceptions.exception.NotFoundException;
import br.com.dio.exceptions.exception.UserNotFoundException;
import br.com.dio.exceptions.model.UserModel;

public class UserDAO {

    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model) {
        UserModel toUpdate = findById(model.getId());
        toUpdate.updateFrom(model);
        return toUpdate;
    }

    public void delete(final long id) {
        UserModel toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(final long id) {
        return models.stream()
            .filter(m -> m.getId() == id)
            .findFirst()
            .orElseThrow(() -> new NotFoundException(UserModel.class, id));
    }

    public List<UserModel> findAll() {
        return List.copyOf(models);
    }

}
