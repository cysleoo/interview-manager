package com.study.interviewmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.study.interviewmanager.domain.entity.Question;
import com.study.interviewmanager.repository.QuestionRepository;
import com.study.interviewmanager.service.QuestionService;
import com.study.interviewmanager.service.QuestionTypeService;

/**
 * @author ssliu
 * @date 2021-03-19
 */
@Service
public class QuestionServiceImpl implements QuestionService {

  private final QuestionRepository questionRepository;
  private final QuestionTypeService questionTypeService;

  public QuestionServiceImpl(QuestionRepository questionRepository,
      QuestionTypeService questionTypeService) {
    this.questionRepository = questionRepository;
    this.questionTypeService = questionTypeService;
  }

  @Override
  public Page<Question> getQuestions(Integer questionId, Integer typeId, String content,
      Pageable page) {

    List<Integer> typeList = null;
    if (!ObjectUtils.isEmpty(typeId)) {
      typeList = questionTypeService.findTypeIdsByParentId(typeId);
      typeList.add(typeId);
    }
    return questionRepository.findAllQuestions(questionId, typeList, content, page);
  }

  @Override
  public void putQuestion(Question question) {
    questionRepository.save(question);
  }

  @Override
  public void deleteQuestion(Integer questionId) {
    questionRepository.deleteById(questionId);
  }
}
