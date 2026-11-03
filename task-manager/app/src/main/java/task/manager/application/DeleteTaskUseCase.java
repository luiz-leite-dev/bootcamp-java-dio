package task.manager.application;

import org.springframework.stereotype.Service;

import task.manager.domain.TaskId;
import task.manager.domain.TaskNotFoundException;
import task.manager.domain.TaskRepository;

@Service
public class DeleteTaskUseCase {

    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId taskId) {
        if (repository.findById(taskId).isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }
        repository.delete(taskId);
    }

}
