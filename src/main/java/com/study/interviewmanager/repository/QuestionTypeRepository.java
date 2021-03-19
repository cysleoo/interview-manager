package com.study.interviewmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study.interviewmanager.domain.entity.QuestionType;

/**
 * @author ssliu
 * @date 2021-03-19
 */
@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType,Integer> {

  /**
   * 获取所有type
   * @param typeId
   * @param parentId
   * @param typeName
   * @return
   */
  @Query("select a from QuestionType a where (?1 is null or a.typeId = ?1) and (?2 is null or a.parentId = ?2) and (?3 is null or a.typeName like %?3%)")
  List<QuestionType> findAllType(int typeId,int parentId,String typeName);

}
