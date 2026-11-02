package task.manager.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.manager.application.input.CreateTaskInput;
import task.manager.application.output.TaskOutput;
import task.manager.infrastructure.repository.InMemoryTaskRepository;

public class CreateTaskUseCaseTest {

    CreateTaskUseCase useCase;

    @BeforeEach
    void setUp(){
        this.useCase = new CreateTaskUseCase(new InMemoryTaskRepository());
    }

    @Test
    void should_create_task_successfully() {
        // given
        final String title = "Estudar Java";
        final Optional<String> description = Optional.of("Finalizar o módulo de records");
        var input = new CreateTaskInput(title, description);

        // when
        TaskOutput output = useCase.execute(input);

        // then
        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals(title, output.title());
        assertEquals(description, output.description());
    }
}
