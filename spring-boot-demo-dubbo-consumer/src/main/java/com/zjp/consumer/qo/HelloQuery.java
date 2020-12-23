package com.zjp.consumer.qo;

import lombok.Data;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 查询类
 * @Author: zhujunpeng
 * @Date: 2020/12/23 15:23
 * @version: v1.0
 */
@Data
public class HelloQuery implements Serializable {

    @NotBlank(message="用户名不能为空")
    private String hello;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确")
    private String age;

    @AssertFalse(message = "必须为false")
    private Boolean isFalse;
    /**
     * 如果是空，则不校验，如果不为空，则校验
     */
    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    private String birthday;
}
