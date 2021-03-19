package com.study.interviewmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.interviewmanager.domain.entity.QuestionType;
import com.study.interviewmanager.repository.QuestionTypeRepository;
import com.study.interviewmanager.service.QuestionTypeService;

/**
 * @author ssliu
 * @date 2021-03-19
 */
@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

  private  final QuestionTypeRepository questionTypeRepository;

  public QuestionTypeServiceImpl(
      QuestionTypeRepository questionTypeRepository) {
    this.questionTypeRepository = questionTypeRepository;
  }

  @Override
  public List<QuestionType> getAllTypes(Integer typeId, Integer parentId,
      String typeName) {
    return questionTypeRepository.findAllType(typeId,parentId,typeName);
  }

  @Override
  public void putType(QuestionType type) {
    questionTypeRepository.save(type);
  }

  @Override
  public void deleteType(Integer typeId) {
    questionTypeRepository.deleteById(typeId);
  }
}
