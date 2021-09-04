package com.wp;

import com.wp.Utils.JsonUtil;
import com.wp.Utils.JsonUtils;
import com.wp.mapper.UserMapper;
import com.wp.mapper2.ClubMapper;
import com.wp.pojo.Club;
import com.wp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MPTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ClubMapper clubMapper;

    @Test
    public void test1(){
        User u = new User();
        //u.setUserName("小王");
        u.setName("小王");
        User user = userMapper.selectOne(u);
        System.out.println(user);
    }
    @Test
    public void test2(){
        // 自定义sql
        User user = userMapper.findByName("小王");
        System.out.println(user);
    }
    @Test
    public void test3(){
        User user = new User();
        user.setName("辣哥");
        user.setPassword("123456");
        user.setAge(25);
        Integer insert = userMapper.insert(user);
        System.out.println(user);
    }
    @Test
    public void test4(){
        User user = new User();
        user.setAge(18);
        user.setPassword("123456");
        user.setName("小鹏");
        user.setUserId(1);
        String json = JsonUtil.objectToJson(user);
        System.out.println(json);
        User pojo = JsonUtil.jsonToPojo(json, User.class);
        System.out.println(pojo);
        String s = "{\"userId\":1,\"name\":\"小鹏\",\"age\":18,\"password\":\"123456\",\"pet\":\"dog\"}";
        User user1 = JsonUtil.jsonToPojo(s, User.class);
        System.out.println("user1:"+user1);
        // json字段不能少于pojo，否者会报错；fastjson好像不会
        /*String s2 = "{\"userId\":1,\"name\":\"小鹏\",\"age\":18,\"}";
        User user2 = JsonUtils.toBean(s2,User.class);
        System.out.println("user2:"+user2);*/
    }
    @Test
    public void test5(){
        User user = userMapper.findByName("小王");
        System.out.println(user);
        Club club = clubMapper.findById(1);
        System.out.println(club);
    }
}
