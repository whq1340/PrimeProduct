package com.example.helloword.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloword.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    String USER_TABLE="user";
    //查询所有用户
    @Select("select * from "+USER_TABLE+"")
    public List<User> find();
    //根据id查询列表
    @Select("select * from "+USER_TABLE+" where id=#{id}")
    List<User> getUserById(int id);
    //根据username查是否存在，等于1则存在
    @Select("select count(*) from "+USER_TABLE+" where username=#{username}")
    int getNumByName(String username);
    //更新用户信息
    @Update("update "+USER_TABLE+" set password=#{password},birthday=#{birthday},phone=#{phone} where username=#{username}")
    int updateUser(User user);
    //注册新用户
    @Insert("insert into "+USER_TABLE+" (username,password,birthday,logontime,phone) " +
            "value (#{username},#{password},#{birthday},#{logontime},#{phone})")
    int insertUser(User user);
    //根据id删除用户
    @Delete("delete from "+USER_TABLE+" where id=#{id}")
    int deleteUserById(int id);


    //查询用户及订单（联表查询）
    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "id",property = "trades",javaType = List.class,
            many = @Many(select = "com.example.helloword.mapper.TradeMapper.queryTradeByUid"))
    })
    List<User> queryUserAndTrade();

    //根据用户名查询密码
    @Select("select password from "+ USER_TABLE + " where username=#{username}")
    String getPasswordByUser(String username);
}
