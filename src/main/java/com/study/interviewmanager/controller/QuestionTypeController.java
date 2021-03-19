package com.study.interviewmanager.controller;

import java.util.List;
import java.util.stream.BaseStream;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.interviewmanager.common.BaseResult;
import com.study.interviewmanager.domain.entity.QuestionType;
import com.study.interviewmanager.service.QuestionTypeService;

/**
 * @author ssliu
 * @date 2021-03-19
 */
@RestController
public class QuestionTypeController {

  private final QuestionTypeService questionTypeService;

  public QuestionTypeController(
      QuestionTypeService questionTypeService) {
    this.questionTypeService = questionTypeService;
  }

  @GetMapping("/types")
  public BaseResult getAllTypes(Integer typeId, Integer parentId,String typeName) {
    List<QuestionType> allTypes =
        questionTypeService.getAllTypes(typeId, parentId, typeName);
    return BaseResult.success(allTypes);
  }

  @PostMapping("/types")
  public BaseResult addType(QuestionType type) {
    questionTypeService.putType(type);
    return BaseResult.success("");
  }

  @DeleteMapping("/types/{typeId}")
  public BaseResult deleteType(@PathVariable Integer typeId) {
    questionTypeService.deleteType(typeId);
    return BaseResult.success("");
  }


}
