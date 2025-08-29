package com.velhinho.projeto10.service;

import com.seunome.board.model.Task;
import com.seunome.board.repository.TaskRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskServiceTest {

    @Test
    void testSave() {
        TaskRepository repo = mock(TaskRepository.class);
        TaskService service = new TaskService(repo);

        Task task = new Task();
        task.setTitle("Aprender Spring");
        when(repo.save(task)).thenReturn(task);

        Task result = service.save(task);
        assertEquals("Aprender Spring", result.getTitle());
        verify(repo, times(1)).save(task);
    }
}
