package task.manager.infrastructure.repository;

import task.manager.domain.TaskRepository;
import task.manager.domain.TaskRepositoryTest;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {

    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }

}
