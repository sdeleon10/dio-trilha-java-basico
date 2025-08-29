package com.velhinho.projeto10.repository;

import com.seunome.board.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
