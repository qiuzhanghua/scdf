package com.example.cloudtasklearning;


import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

@Component
public class TaskExecutionListener {
  @BeforeTask
  public void onTaskStartup(TaskExecution taskExecution) {
    System.out.println("before task " + taskExecution.getExecutionId() );
  }

  @AfterTask
  public void onTaskEnd(TaskExecution taskExecution) {
    System.out.println("after task " + taskExecution.getExecutionId() );
  }

  @FailedTask
  public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
    System.out.println("task failed " + taskExecution.getExecutionId() );
  }
}
