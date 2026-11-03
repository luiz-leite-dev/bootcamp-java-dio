package task.manager.application;

import org.springframework.stereotype.Service;

import task.manager.application.input.UpdateTaskInput;
import task.manager.application.output.TaskOutput;
import task.manager.domain.TaskId;
import task.manager.domain.TaskNotFoundException;
import task.manager.domain.TaskRepository;

@Service
public class UpdateTaskUseCase {

    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId taskId, UpdateTaskInput input) {
        var task = repository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }

}
