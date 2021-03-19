package com.study.interviewmanager.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.study.interviewmanager.domain.entity.QuestionType;
import com.study.interviewmanager.repository.QuestionTypeRepository;
import com.study.interviewmanager.service.QuestionTypeService;

import antlr.CommonHiddenStreamToken;

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

  @Override
  public List<Integer> findTypeIdsByParentId(Integer parentId) {
    List<QuestionType> allType = questionTypeRepository.findAll();
    List<Integer> resultTypeIds = new ArrayList<>(allType.size());
    Set<Integer> parentIds = Set.of(parentId);
    while (true) {
      Set<Integer> childTypeIds = new HashSet<>(allType.size());
      for (QuestionType type : allType) {
        if (parentIds.contains(type.getParentId())) {
          childTypeIds.add(type.getTypeId());
        }
      }
      if (ObjectUtils.isEmpty(childTypeIds)) {
        break;
      }
      resultTypeIds.addAll(childTypeIds);
      parentIds = childTypeIds;
    }

    return resultTypeIds;
  }
}
