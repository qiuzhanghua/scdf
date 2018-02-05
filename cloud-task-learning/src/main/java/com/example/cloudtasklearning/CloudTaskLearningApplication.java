package com.example.cloudtasklearning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableTask
public class CloudTaskLearningApplication {

  @Bean
  public CommandLineRunner commandLineRunner() {
    return strings ->
        System.out.println("Executed at :" +
            new SimpleDateFormat().format(new Date()));
  }

  public static void main(String[] args) {
    SpringApplication.run(CloudTaskLearningApplication.class, args);
  }
}
