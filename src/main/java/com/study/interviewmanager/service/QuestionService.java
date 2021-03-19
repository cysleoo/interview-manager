package com.study.interviewmanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.study.interviewmanager.domain.entity.Question;

/**
 * @author ssliu
 * @date 2021-03-19
 */
public interface QuestionService {

  /**
   * 获取问题列表
   * @param questionId
   * @param typeId
   * @param content
   * @param page
   * @return
   */
  Page<Question> getQuestions(Integer questionId,Integer typeId,String content, PageRequest page);

  /**
   * 新增问题
   * @param question
   */
  void putQuestion(Question question);


}
