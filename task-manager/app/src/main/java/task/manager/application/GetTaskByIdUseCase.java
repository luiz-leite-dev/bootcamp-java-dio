package task.manager.application;

import org.springframework.stereotype.Service;

import task.manager.application.output.TaskOutput;
import task.manager.domain.TaskId;
import task.manager.domain.TaskNotFoundException;
import task.manager.domain.TaskRepository;

@Service
public class GetTaskByIdUseCase {

    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoundException(id));
    }

}
