package task.manager.domain;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(TaskId taskId) {
        super("Task with id " + taskId.id() + " not found.");
    }
}
