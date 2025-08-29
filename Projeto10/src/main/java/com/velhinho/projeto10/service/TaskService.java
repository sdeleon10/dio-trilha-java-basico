package com.velhinho.projeto10.service;

import com.seunome.board.model.Task;
import com.seunome.board.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;
    public TaskService(TaskRepository repository) { this.repository = repository; }

    public Task save(Task task) { return repository.save(task); }
    public List<Task> findAll() { return repository.findAll(); }
    public Optional<Task> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
