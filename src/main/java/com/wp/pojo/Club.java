package com.wp.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@TableName("user")
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // 当json转pojo时，若json字段多于pojo，需加该注解，不然会报错
public class Club {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String clubname;
    private Date c_date;
    private String logo;
    private String introduction;
    private String type;
}
