package task.manager.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.manager.domain.Task;
import task.manager.domain.TaskId;
import task.manager.domain.TaskStatus;

class InMemoryTaskRepositoryTest {

    private InMemoryTaskRepository repository;

    @BeforeEach 
    void setUp() {
        repository = new InMemoryTaskRepository();
    }

    @Test 
    void should_save_and_retrieve_task_by_id() {
        // given
        var task = new Task("Passar na padaria", Optional.empty());

        // when
        var saved = repository.save(task);
        Optional<Task> result = repository.findById(saved.getId());

        // then
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), task.getId());
        assertEquals(result.get().getDescription(), task.getDescription());
        assertEquals(result.get().getStatus(), task.getStatus());
    }

    @Test
    void should_find_all_persisted_tasks() {
        // given
        var task1 = new Task("Arrumar chuveiro", Optional.of("Comprar chuveiro novo"));
        var task2 = new Task("Trocar interruptor", Optional.of("Encontrar chave de fenda"));

        repository.save(task1);
        repository.save(task2);

        // when
        List<Task> tasks = repository.findAll();

        // then
        assertEquals(tasks.size(), 2);
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }

    @Test 
    void should_delete_task_by_id() {
        // given
        var task = repository.save(new Task("Treinar na academia", Optional.empty()));
        var taskId = task.getId();

        // when
        repository.delete(taskId);
        Optional<Task> result = repository.findById(taskId);

        // then
        assertTrue(result.isEmpty());
    }

    @Test 
    void should_return_empty_when_searching_non_existent_task() {
        // given
        var nonExistentId = new TaskId();

        // when
        Optional<Task> result = repository.findById(nonExistentId);

        // then
        assertTrue(result.isEmpty());
    }

    @Test 
    void should_update_task_status_successfully() {
        // given
        var task = repository.save(new Task("Atualizar carteira de habilitação", Optional.empty()));

        task.setDescription(Optional.of("Não expirou ainda"));
        task.setStatus(TaskStatus.IN_PROGRESS);

        // when
        repository.save(task);
        Optional<Task> result = repository.findById(task.getId());

        // then
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), task.getId());
        assertEquals(result.get().getDescription(), Optional.of("Não expirou ainda"));
        assertEquals(result.get().getStatus(), TaskStatus.IN_PROGRESS);        
    }

}
