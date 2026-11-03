package task.manager.infrastructure.http;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import task.manager.application.CreateTaskUseCase;
import task.manager.infrastructure.http.request.CreateTaskRequest;
import task.manager.infrastructure.http.response.TaskResponse;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping
    TaskResponse create(@RequestBody CreateTaskRequest request) {
        var output = createTaskUseCase.execute(request.toInput());
        return TaskResponse.from(output);
    }

}
