package task.manager.infrastructure.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import task.manager.application.output.TaskOutput;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record TaskResponse(String taskId, String title, String description, String status) {

    public static TaskResponse from(TaskOutput output) {
        return new TaskResponse(output.id(), output.title(), output.description().orElse(null), output.status());
    }
}
