package com.study.interviewmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
   * @param typeId
   * @param content
   * @param page
   * @return
   */
  @Query("select a from Question a where (?1 is null or a.questionId = ?1) and (?2 is null or a.typeId = ?2) and (?3 is null or a.content like %?3%)")
  Page<Question> findAllQuestions(int questionId, int typeId, String content, Pageable page);

}
