package task.manager.infrastructure.http;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import task.manager.application.CreateTaskUseCase;
import task.manager.application.DeleteTaskUseCase;
import task.manager.application.GetTaskByIdUseCase;
import task.manager.application.GetTaskUseCase;
import task.manager.domain.TaskId;
import task.manager.infrastructure.http.request.CreateTaskRequest;
import task.manager.infrastructure.http.response.TaskResponse;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetTaskUseCase getTaskUseCase, GetTaskByIdUseCase getTaskByIdUseCase, DeleteTaskUseCase deleteTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskUseCase = getTaskUseCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    @PostMapping
    TaskResponse create(@RequestBody CreateTaskRequest request) {
        var output = createTaskUseCase.execute(request.toInput());
        return TaskResponse.from(output);
    }

    @GetMapping 
    List<TaskResponse> list(){
        return getTaskUseCase.execute().stream().map(TaskResponse::from).toList();
    }

    @GetMapping("/{id}")
    TaskResponse getById(@PathVariable("id") UUID id) {
        return TaskResponse.from(getTaskByIdUseCase.execute(new TaskId(id)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID id) {
        deleteTaskUseCase.execute(new TaskId(id));
    }

}
