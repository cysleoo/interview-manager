package com.study.interviewmanager.service;

import java.util.List;

import com.study.interviewmanager.domain.entity.Question;
import com.study.interviewmanager.domain.entity.QuestionType;

/**
 * @author ssliu
 * @date 2021-03-19
 */
public interface QuestionTypeService {

  /**
   * 搜索type
   * @param typeId
   * @param parentId
   * @param typeName
   * @return
   */
  List<QuestionType> getAllTypes(int typeId,int parentId,String typeName);

  void putType(QuestionType type);


}
