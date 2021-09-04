package com.wp.mapper2;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wp.pojo.Club;
import com.wp.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClubMapper extends BaseMapper<Club> {
    @Select("select * from club where id = #{id}")
   /* @Results({@Result(id = true, column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "name")})*/
    Club findById(Integer id);
}
