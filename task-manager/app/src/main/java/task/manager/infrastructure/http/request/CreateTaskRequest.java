package task.manager.infrastructure.http.request;

import java.util.Optional;

import task.manager.application.input.CreateTaskInput;

public record CreateTaskRequest(String title, Optional<String> description) {

    public CreateTaskInput toInput() {
        return new CreateTaskInput(title, description);
    }

}
