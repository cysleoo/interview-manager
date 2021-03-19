package com.study.interviewmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InterviewManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(InterviewManagerApplication.class, args);
  }

}
