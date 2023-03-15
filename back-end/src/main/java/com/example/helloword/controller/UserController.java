package com.example.helloword.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloword.entity.User;
import com.example.helloword.mapper.UserMapper;
import com.example.helloword.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TreeMap;

@RestController
//跨域默认配置注解（仅限本controller）
//@CrossOrigin
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @ApiOperation("根据用户id获取用户信息")
    @GetMapping("/user/{id}")
    public TreeMap getUserById(@PathVariable int id){
        TreeMap result=new TreeMap<>();
        List<User> list= userMapper.getUserById(id);
        if(list.size()>0){
            result.put("code",201);
            result.put("log","查询成功");
            result.put("list",list);
        }else {
            result.put("code",404);
            result.put("log","无相应数据");
        }
        System.out.println(result);
        return result;
    }
    //与上方同样的查询，但用MyBatisPlus方法
    @GetMapping("/user1/{id}")
    public TreeMap getUserByIdPlus(@PathVariable int id){
        TreeMap result=new TreeMap<>();
        //把条件封装在queryWrapper中(省去了写sql语句)
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        List<User> list= userMapper.selectList(queryWrapper);
        //
        if(list.size()>0){
            result.put("code",201);
            result.put("log","查询成功");
            result.put("list",list);
        }else {
            result.put("code",404);
            result.put("log","无相应数据");
        }
        System.out.println(result);
        return result;
    }
    @ApiOperation("分页查询所有用户信息")
    @GetMapping("/user")
    public IPage query(){
        //TreeMap result=new TreeMap<>();
        //分页起始为0，每页长度为2
        Page<User> page= new Page<>(0,2);
        IPage iPage=userMapper.selectPage(page,null);

        return iPage;
    }
    @ApiOperation("新增新用户")
    @PostMapping("/user")
    public TreeMap userLogon(User user){
        TreeMap result=new TreeMap<>();
        int m=userMapper.getNumByName(user.getUsername());
        if(m>=1){
            result.put("code",400);
            result.put("log","该用户名已存在");
        }else {
            //获取当前时间
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setLogontime(sdf.format(System.currentTimeMillis()));
            int n=userMapper.insertUser(user);
            //System.out.println(sdf.format(System.currentTimeMillis()));
            if(n==1){
                result.put("code",200);
                result.put("log","新增成功");
            }else {
                result.put("code",400);
                result.put("log","新增失败");
            }
        }
        System.out.println(m);
        return result;
    }
    @ApiOperation("更新用户信息")
    @PutMapping("/user")
    public TreeMap update(User user){
        TreeMap result=new TreeMap<>();
        int n=userMapper.updateUser(user);
        if(n==1){
            result.put("code",200);
            result.put("log","更新成功");
        }else {
            result.put("code",400);
            result.put("log","更新失败");
        }
        return result;
    }
    @ApiOperation("根据用户id删除用户信息")
    @DeleteMapping("/user/{id}")
    public TreeMap deleteUserById(@PathVariable int id){
        TreeMap result=new TreeMap<>();
        int n=userMapper.deleteUserById(id);
        if(n==1){
            result.put("code",200);
            result.put("log","删除成功");
        }else {
            result.put("code",400);
            result.put("log","删除失败");
        }
        return result;
    }
    @ApiOperation("查询所有用户及其订单")
    @GetMapping("/user/trade")
    public TreeMap queryUserAndTrade(){
        TreeMap result=new TreeMap<>();
        List<User> list=userMapper.queryUserAndTrade();
        if(list.size()>0){
            result.put("code",200);
            result.put("log","查询成功");
            result.put("list",list);
        }else {
            result.put("code",404);
            result.put("log","无相应数据");
        }
        return result;
    }
    @PostMapping("/login")
    public TreeMap login(@RequestBody User user){
        String password = userMapper.getPasswordByUser(user.getUsername());
        TreeMap result=new TreeMap<>();
        if(password.equals(user.getPassword())){
            String token = JwtUtils.generateToken(user.getUsername());
            result.put("code",200);
            result.put("log","成功");
            result.put("token",token);
        }else{
            result.put("code",400);
            result.put("log","失败");
        }
        return result;
    }
}
