package com.maomao.layui;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class LayuiApplication {

    public static void main(String[] args) {

        SpringApplication.run(LayuiApplication.class, args);
    }



    @RequestMapping("/add")
    public String add(){
        return "a";
    }


    @RequestMapping("/add1")
    public String add1(){
        return "layui";
    }

    @RequestMapping("/img")
    public @ResponseBody Map<String,Object> upload(MultipartFile file) throws IOException {
        Map<String,Object> map=new HashMap<String,Object>();
        String fileName= file.getOriginalFilename();
        String path="D:\\img"+fileName;
        File newFile =new File(path);
        file.transferTo(newFile);
        map.put("code",0);
        map.put("msg","");
        Map<String,Object> map2=new HashMap<>();
        map2.put("src",path);
        map.put("data",map2);
        return map;
    }

    @RequestMapping("/op")
    public String j(){
        return "ab";
    }
}
