package com.technique.repo;

import com.technique.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Task,Integer> {
}
