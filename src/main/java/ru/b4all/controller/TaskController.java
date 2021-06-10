package ru.b4all.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.b4all.repository.Task;
import ru.b4all.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping(value = "/")
  public ResponseEntity<Task> createTask(Task task) {
    return ResponseEntity.ok(taskService.createTask(task));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Task> getTask(@PathVariable UUID id) {
    return ResponseEntity.ok(taskService.getTask(id));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable UUID id, Task task) {
    taskService.updateTask(id, task);
    return ResponseEntity.ok(null);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
    taskService.deleteTask(id);
    return ResponseEntity.ok(null);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<Task>> getTasks() {
    return ResponseEntity.ok(taskService.getTasks());
  }

}
