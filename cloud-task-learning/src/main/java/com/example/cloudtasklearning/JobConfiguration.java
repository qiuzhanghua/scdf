package com.example.cloudtasklearning;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {
  private static final Log logger = LogFactory.getLog(JobConfiguration.class);

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job job1() {
    return jobBuilderFactory.get("job1")
        .start(stepBuilderFactory.get("job1step1")
            .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
              logger.info("Job1 was run");
              return RepeatStatus.FINISHED;
            })
            .build())
        .build();
  }

  @Bean
  public Job job2() {
    return jobBuilderFactory.get("job2")
        .start(stepBuilderFactory.get("job2step1")
            .tasklet((contribution, chunkContext) -> {
              logger.info("Job2 was run");
              return RepeatStatus.FINISHED;
            })
            .build())
        .build();
  }
}
