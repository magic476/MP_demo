package com.wp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wp.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user_name = #{name}")
    @Results({@Result(id = true, column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "name")})
    User findByName(String name);
}
