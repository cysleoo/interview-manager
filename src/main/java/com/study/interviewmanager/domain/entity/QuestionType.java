package com.study.interviewmanager.domain.entity;

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
 * @date 2021-03-19
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_question_type")
public class QuestionType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer typeId;
  private String typeName;
  /**
   * 类型的等级：
   * 0：领域：后端、ComputerScience、前端
   * 1：大类：Java、JavaScript、Go、网络、SpringCloud...
   * 2. 细分：Spring、等
   * 3. 更细：aop、ioc等等
   */
  private Integer level;
  private Integer parentId;

}
