package com.zjp.common.exception;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 通用的返回值参数
 * @author zhujunpeng
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private int code;

    private String msg;

    private String errorMsg;

    private T data;

    public static <T> Result success(int code, String msg, T obj) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(BizCodeEnum.OK.getCode());
        result.setMsg(BizCodeEnum.OK.getMsg());
        if (obj != null) {
            result.setData(obj);
        }
        return result;
    }

    /**
     * 不要删
     * @param code
     * @param msg
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Result successData(int code, String msg, T obj) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMsg(BizCodeEnum.OK.getMsg());
        if(msg!=null){
            result.setMsg(msg);
        }
        if (obj != null) {
            result.setData(obj);
        }
        return result;
    }
    public static <T> Result success(int code, String msg, T obj,Boolean success) {
        Result result = new Result();
        result.setSuccess(success);
        result.setCode(BizCodeEnum.OK.getCode());
        result.setMsg(msg);
        if (obj != null) {
            result.setData(obj);
        }
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static Result success() {
        return Result.success(null);
    }

    public static Result failure(int code, String msg) {
        return Result.failure(code, msg, msg);
    }


    public static Result failure(int code, String msg, String errorMsg) {
        return failure(null, code, msg, errorMsg);
    }

    public static <T> Result failure(T obj, int code, String msg) {
        return failure(obj, code, msg, null);
    }

    public static <T> Result success(T obj) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(BizCodeEnum.OK.getCode());
        result.setMsg(BizCodeEnum.OK.getMsg());
        if (obj == null) {
            // 若返回数据为null 统一返回给前端{}
            result.setData(new HashMap<>(1));
        } else {
            result.setData(obj);
        }
        return result;
    }



    public static <T> Result failure(T obj, int code, String msg, String errorMsg) {
        Result result = new Result();
        result.setData(obj);
        result.setCode(code);
        result.setSuccess(false);
        result.setMsg(msg);
        result.setErrorMsg(errorMsg);
        return result;
    }


}
