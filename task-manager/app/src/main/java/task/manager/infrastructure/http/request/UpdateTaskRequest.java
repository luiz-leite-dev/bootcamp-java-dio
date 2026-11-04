package task.manager.infrastructure.http.request;

import java.util.Optional;

import task.manager.application.input.UpdateTaskInput;
import task.manager.domain.TaskStatus;

public record UpdateTaskRequest(Optional<String> title, Optional<String> description, Optional<String> status) {

    public UpdateTaskInput toInput() {
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }

}
