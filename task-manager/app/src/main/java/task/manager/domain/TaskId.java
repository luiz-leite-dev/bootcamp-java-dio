package task.manager.domain;

import java.util.UUID;

import org.springframework.util.Assert;

public record TaskId(UUID id) {
    public TaskId {
        Assert.notNull(id, "id must not be null");
    }

    public TaskId() {
        this(UUID.randomUUID());
    }

}
