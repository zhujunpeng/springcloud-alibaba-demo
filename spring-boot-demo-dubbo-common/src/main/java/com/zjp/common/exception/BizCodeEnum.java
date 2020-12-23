package com.zjp.common.exception;

/**
 * 错误枚举值
 * @Author: zhujunpeng
 * @Date: 2020/12/23 15:11
 * @version: v1.0
 */
public enum  BizCodeEnum {
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    OK(200, "正常"),
    VALID_EXCEPTION(10001, "参数格式校验失败");

    private int code;
    private String msg;
    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
