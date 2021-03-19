package com.study.interviewmanager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ssliu
 * @date 2021-03-15
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_question")
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer questionId;
  private Integer typeId;
  @Column(length = 2000)
  private String content;
  @Column(length = 2000)
  private String answer;

  @Column(length = 500)
  private String referenceUrl;

  private Integer score;



}

