package task.manager.application;

import java.util.List;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import task.manager.application.output.TaskOutput;
import task.manager.domain.TaskRepository;

@Service
public class GetTaskUseCase {

    private final TaskRepository repository;

    public GetTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }
    
    public List<TaskOutput> execute() {
        return repository.findAll().stream().map(TaskOutput::from).toList();
    }

}
