package ru.b4all.repository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
  Task createTask(Task task);

  Task getTask(UUID id);

  void updateTask(Task task);

  void deleteTask(UUID id);

  List<Task> getTasks();
}
