package task.manager.application.input;

import java.util.Optional;

//DTO - Data Transfer Object
public record CreateTaskInput(String title, Optional<String> description) {

}
