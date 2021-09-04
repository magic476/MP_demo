package com.wp.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@TableName("user")
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // 当json转pojo时，若json字段多于pojo，需加该注解，不然会报错
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    @TableField("user_name") // 只能用于MP提供的失去了，自定义sql不能映射到
    private String name;
    private Integer age;
    private String password;
}
