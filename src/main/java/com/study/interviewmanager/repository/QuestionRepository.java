package com.study.interviewmanager.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.interviewmanager.domain.entity.Question;

/**
 * @author ssliu
 * @date 2021-03-19
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

  /**
   * 查找所有问题
   * @param questionId
   * @param typeIds
   * @param content
   * @param page
   * @return
   */
  @Query("select a from Question a where (:questionId is null or a.questionId = :questionId) and (coalesce(:typeIds, null) is null or a.typeId in :typeIds) and (:content is null or a.content like %:content%)")
  Page<Question> findAllQuestions(Integer questionId, @Param("typeIds") List<Integer> typeIds, String content, Pageable page);

}
