package task.manager.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import task.manager.application.input.CreateTaskInput;
import task.manager.application.output.TaskOutput;

@SpringBootTest
public class CreateTaskUseCaseTest {
    @Autowired
    CreateTaskUseCase useCase;

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
