package task.manager.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import task.manager.application.input.CreateTaskInput;
import task.manager.application.output.TaskOutput;
import task.manager.domain.Task;
import task.manager.domain.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class CreateTaskUseCaseTest {
    @Mock
    TaskRepository repository;

    @InjectMocks
    CreateTaskUseCase useCase;

    @Test
    void should_create_task_successfully() {
        // given
        final String title = "Estudar Java";
        final Optional<String> description = Optional.of("Finalizar o módulo de records");
        var input = new CreateTaskInput(title, description);

        // when
        when(repository.save(any(Task.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));
        TaskOutput output = useCase.execute(input);

        // then
        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals(title, output.title());
        assertEquals(description, output.description());
        verify(repository, times(1)).save(any(Task.class));
    }
}
