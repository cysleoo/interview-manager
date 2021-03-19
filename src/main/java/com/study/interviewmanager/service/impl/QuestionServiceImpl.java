package com.study.interviewmanager.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.study.interviewmanager.domain.entity.Question;
import com.study.interviewmanager.repository.QuestionRepository;
import com.study.interviewmanager.service.QuestionService;

/**
 * @author ssliu
 * @date 2021-03-19
 */
@Service
public class QuestionServiceImpl implements QuestionService {

  private final QuestionRepository questionRepository;

  public QuestionServiceImpl(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  @Override
  public Page<Question> getQuestions(Integer questionId, Integer typeId, String content,
      PageRequest page) {
     return questionRepository.findAllQuestions(questionId, typeId, content, page);
  }

  @Override
  public void putQuestion(Question question) {
    questionRepository.save(question);
  }
}
