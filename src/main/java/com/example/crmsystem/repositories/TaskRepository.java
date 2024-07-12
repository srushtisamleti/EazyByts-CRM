package com.example.crmsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crmsystem.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
