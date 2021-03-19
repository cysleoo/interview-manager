package com.study.interviewmanager.service;

import java.util.List;

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
  List<QuestionType> getAllTypes(Integer typeId, Integer parentId,String typeName);

  void putType(QuestionType type);

  void deleteType(Integer typeId);

  /**
   * 通过parentId查找其所有子孙typeId
   * @param parentId
   * @return
   */
  List<Integer> findTypeIdsByParentId(Integer parentId);

}
