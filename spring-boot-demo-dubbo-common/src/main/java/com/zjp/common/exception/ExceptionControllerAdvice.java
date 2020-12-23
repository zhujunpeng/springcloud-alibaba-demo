package com.zjp.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一异常处理
 * @Author: zhujunpeng
 * @Date: 2020/12/23 15:08
 * @version: v1.0
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    private Logger log = LoggerFactory.getLogger(this.toString());

    /**
     * 参数校验失败通用返回
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}", e.getBindingResult().getFieldError().getDefaultMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError)->{
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        List<String> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(a->errors.add(a.getDefaultMessage()));
        return Result.failure(BizCodeEnum.VALID_EXCEPTION.getCode(), StringUtils.collectionToCommaDelimitedString(errors));
    }

    /**
     * 通用异常返回
     * @param throwable
     * @return
     */
    @ExceptionHandler(value=Throwable.class)
    public Result handleException(Throwable throwable) {
        log.error("未知异常{}，异常类型：{}", throwable.getMessage(), throwable.getClass());

        return Result.failure(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
