package com.example.helloword.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    //HttpServletRequest指的是前端发过来的请求
    public String upload(String username, MultipartFile fi, HttpServletRequest request)throws IOException {
        System.out.println(username);
        //获取文件的原始名称
        System.out.println(fi.getOriginalFilename());
        //获取文件的类型
        System.out.println(fi.getContentType());
        //通过获取web服务器上下文来得到路径
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(fi,path);
        return "上传成功";
    }
    public void saveFile(MultipartFile file,String path) throws IOException {
        //判断存储的目录是否存在，如果不存在则创建
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        File files = new File(path+file.getOriginalFilename());
        file.transferTo(files);
    }
}
