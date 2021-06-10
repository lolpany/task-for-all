package ru.b4all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "ru.b4all.")
@SpringBootApplication
public class B4allTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(B4allTaskApplication.class, args);
  }
}
