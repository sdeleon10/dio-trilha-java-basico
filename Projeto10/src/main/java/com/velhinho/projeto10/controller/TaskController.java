package com.velhinho.projeto10.controller;

import com.seunome.board.model.Task;
import com.seunome.board.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) { this.service = service; }

    @PostMapping
    public Task create(@RequestBody Task task) { return service.save(task); }

    @GetMapping
    public List<Task> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return service.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
