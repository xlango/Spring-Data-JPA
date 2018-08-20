package com.example.springjpatest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/chat");
        return modelAndView;
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println("测试输出");
    }

}
