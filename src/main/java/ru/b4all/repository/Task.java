package ru.b4all.repository;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Task {
  public UUID id;
  public String name;
  public String description;
  public LocalDate lastModificationDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Task task = (Task) o;
    return Objects.equals(id, task.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
