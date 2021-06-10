package ru.b4all.repository;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

  private final Map<UUID, Task> idToTask;

  public InMemoryTaskRepository() {
    this.idToTask = new ConcurrentHashMap<>();
  }

  public Task createTask(Task task) {
    task.id = UUID.randomUUID();
    idToTask.put(task.id, task);
    return task;
  }

  public Task getTask(UUID id) {
    return idToTask.get(id);
  }

  @Override
  public void updateTask(Task task) {
    idToTask.put(task.id, task);
  }

  @Override
  public void deleteTask(UUID id) {
    idToTask.remove(id);
  }

  @Override
  public List<Task> getTasks() {
    return idToTask.values().stream()
        .sorted(comparing(o -> o.lastModificationDate))
        .collect(toList());
  }
}
