package com.study.interviewmanager.common;


/**
 * 返回code
 *
 * @author ssliu
 */

public enum ResultCode {
    // 成功
    SUCCESS("0000", "success"),



    SYSTEM_BUSY("9999","system busy");

    private String code;
    private String msg;

    ResultCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
