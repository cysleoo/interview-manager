package com.study.interviewmanager.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.interviewmanager.common.BaseResult;

/**
 * @author ssliu
 * @date 2021-03-19
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

  @GetMapping("/list")
  BaseResult getQuestionList(Integer questionId,Integer typeId,String content,PageRequest page) {
    return null;
  }


}
