package com.example.helloword.controller;

import com.example.helloword.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
    @GetMapping ("/hello")
    public String hello(String username){
        return "你好！"+username;
    }
    @GetMapping("/hello1")
    public String hello1(@RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return user.getUsername()+" "+user.getPassword();
    }
}
