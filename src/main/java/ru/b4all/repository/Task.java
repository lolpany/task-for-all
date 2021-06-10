package ru.b4all.repository;

import java.time.LocalDate;
import java.util.UUID;

public class Task {
  public UUID id;
  public String name;
  public String description;
  public LocalDate lastModificationDate;
}
