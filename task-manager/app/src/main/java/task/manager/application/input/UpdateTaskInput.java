package task.manager.application.input;

import java.util.Optional;

import task.manager.domain.TaskStatus;

public record UpdateTaskInput(Optional<String> title, Optional<String> description, Optional<TaskStatus> status) {

}
