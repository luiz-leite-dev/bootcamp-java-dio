package task.manager.application;

import org.springframework.stereotype.Service;

import task.manager.application.input.CreateTaskInput;
import task.manager.application.output.TaskOutput;
import task.manager.domain.Task;
import task.manager.domain.TaskRepository;

/* Princípio de Responsabilidade Única = Use Case */
@Service
public class CreateTaskUseCase {

    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }
}
