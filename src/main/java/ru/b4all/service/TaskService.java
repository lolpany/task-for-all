package ru.b4all.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ru.b4all.repository.Task;
import ru.b4all.repository.TaskRepository;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public Task createTask(Task task) {
      task.lastModificationDate = LocalDate.now();
      return taskRepository.createTask(task);
  }

  public Task getTask(UUID id) {
    return taskRepository.getTask(id);
  }

  public void updateTask(UUID id, Task task) {
    Optional.of(taskRepository.getTask(id))
        .ifPresent(
            t -> {
              t.name = task.name;
              t.description = task.description;
              t.lastModificationDate = LocalDate.now();
              taskRepository.updateTask(task);
            });
  }

  public void deleteTask(UUID id) {
    taskRepository.deleteTask(id);
  }

  public List<Task> getTasks() {
    return taskRepository.getTasks();
  }
}
