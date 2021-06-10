package ru.b4all.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import ru.b4all.repository.InMemoryTaskRepository;
import ru.b4all.repository.Task;

public class TaskServiceTest {

  private static TaskService taskService = new TaskService(new InMemoryTaskRepository());

  @Test
  public void testCreateTask() {
    Task task = new Task();
    task.name = "task";
    task.description = "description";
    Task storedTask = taskService.createTask(task);
    assertNotNull(storedTask.id);
    assertEquals(task.name, storedTask.name);
    assertEquals(task.description, storedTask.description);
    assertNotNull(storedTask.lastModificationDate);
  }

  @Test
  public void testGetTask() {
    Task task = new Task();
    task.name = "task";
    task.description = "description";
    taskService.createTask(task);
    Task storedTask = taskService.getTask(task.id);
    assertNotNull(storedTask.id);
    assertEquals(task.name, storedTask.name);
    assertEquals(task.description, storedTask.description);
    assertNotNull(storedTask.lastModificationDate);
  }

  @Test
  public void testUpdateTask() {
    Task task = new Task();
    task.name = "task";
    task.description = "description";
    Task storedTask = taskService.createTask(task);

    Task updatedTask = new Task();
    updatedTask.id = storedTask.id;
    updatedTask.name = "task updated";
    updatedTask.description = "description updated";
    taskService.updateTask(updatedTask.id, updatedTask);
    storedTask = taskService.getTask(storedTask.id);

    assertEquals(storedTask.id, updatedTask.id);
    assertEquals(updatedTask.name, storedTask.name);
    assertEquals(updatedTask.description, storedTask.description);
    assertNotNull(storedTask.lastModificationDate);
  }

  @Test
  public void testDeleteTask() {
    Task task = new Task();
    task.name = "task";
    task.description = "description";
    taskService.createTask(task);
    Task storedTask = taskService.getTask(task.id);
    assertNotNull(storedTask.id);
    assertEquals(task.name, storedTask.name);
    assertEquals(task.description, storedTask.description);
    assertNotNull(storedTask.lastModificationDate);

    taskService.deleteTask(storedTask.id);
    assertNull(taskService.getTask(storedTask.id));
  }

  @Test
  public void testGetTasks() {
    Task task1 = new Task();
    task1.name = "task 1";
    task1.description = "description 1";
    taskService.createTask(task1);

    Task task2 = new Task();
    task2.name = "task 2";
    task2.description = "description 2";
    taskService.createTask(task2);

    assertEquals(2, taskService.getTasks().size());
  }
}
