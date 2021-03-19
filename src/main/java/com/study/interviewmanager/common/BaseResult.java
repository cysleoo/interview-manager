package com.study.interviewmanager.common;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

/**
 * 统一返回结果
 *
 * @author ssliu
 */
@Data
public class BaseResult<T> implements Serializable {

  private String code;
  private String desc;
  private T data;

  public BaseResult() {
    this.setCode(ResultCode.SUCCESS.getCode());
    this.setDesc(ResultCode.SUCCESS.getMsg());
  }

  public BaseResult(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }


  public static <T> BaseResult success(T data) {
    BaseResult baseResult = new BaseResult();
    if (Objects.isNull(data)) {
      String s = "";
      baseResult.setData(s);
    } else {
      baseResult.setData(data);
    }
    return baseResult;
  }

  public static BaseResult error(ResultCode resultCode){
    BaseResult baseResult = new BaseResult();
    baseResult.setCode(resultCode.getCode());
    baseResult.setDesc(resultCode.getMsg());
    return baseResult;
  }
  public static <T> BaseResult error(
      ResultCode resultCode,T data){
    BaseResult baseResult = new BaseResult();
    baseResult.setCode(resultCode.getCode());
    baseResult.setDesc(resultCode.getMsg());
    baseResult.setData(data);
    return baseResult;
  }


}
