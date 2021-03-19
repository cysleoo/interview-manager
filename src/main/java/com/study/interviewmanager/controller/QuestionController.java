package com.study.interviewmanager.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.interviewmanager.common.BaseResult;
import com.study.interviewmanager.domain.entity.Question;
import com.study.interviewmanager.service.QuestionService;

/**
 * @author ssliu
 * @date 2021-03-19
 */
@RestController
public class QuestionController {

  private final QuestionService questionService;

  public QuestionController(
      QuestionService questionService) {
    this.questionService = questionService;
  }

  @GetMapping("/questions")
  BaseResult getQuestionList(Integer questionId,Integer typeId,String content, Pageable page) {
    Page<Question> questions = questionService.getQuestions(questionId, typeId, content, page);
    return BaseResult.success(questions);
  }


  @PostMapping("/questions")
  public BaseResult addType(Question question) {
    questionService.putQuestion(question);
    return BaseResult.success("");
  }

  @DeleteMapping("/questions/{questionId}")
  public BaseResult deleteType(@PathVariable Integer questionId) {
    questionService.deleteQuestion(questionId);
    return BaseResult.success("");
  }

}
