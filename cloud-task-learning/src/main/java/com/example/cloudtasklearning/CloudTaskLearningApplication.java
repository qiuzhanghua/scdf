package com.example.cloudtasklearning;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.batch.configuration.TaskBatchExecutionListenerBeanPostProcessor;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@EnableTask
@EnableBatchProcessing
public class CloudTaskLearningApplication {

  @Bean
  public CommandLineRunner commandLineRunner() {
    return strings -> {
      System.out.println("Executed at : " +
          new SimpleDateFormat().format(new Date()));
//      Files.lines(Paths.get("/qqq/mmm")).count();
    };
  }

//  @Bean
  public ApplicationRunner applicationRunner() {
    return args -> {
      System.out.println("Hello, Spring Cloud Task!");
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(CloudTaskLearningApplication.class, args);
  }

  @Bean
  public ExitCodeExceptionMapper exitCodeExceptionMapper() {
    return (Throwable exception) -> {
      Throwable t = exception.getCause();
      if (t instanceof IOException) return 3;
      return -1;
    };

  }

  @Bean
  public TaskBatchExecutionListenerBeanPostProcessor batchTaskExecutionListenerBeanPostProcessor() {
    TaskBatchExecutionListenerBeanPostProcessor postProcessor =
        new TaskBatchExecutionListenerBeanPostProcessor();

    postProcessor.setJobNames(Arrays.asList(new String[] {"job1", "job2"}));

    return postProcessor;
  }
}
