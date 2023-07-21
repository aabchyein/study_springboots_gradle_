package com.yojulab.study_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yojulab.study_springboot.utils.Commons;

@Controller
public class MainController {
    @Autowired
    Commons commons;

    @GetMapping({"/", "/home", "/main"})
    public ModelAndView main(ModelAndView modelAndView){
        String userId = commons.getUserID();
        modelAndView.addObject("name", "Yojulab!");
        modelAndView.setViewName("/WEB-INF/views/main.jsp");
        return modelAndView;
    }
    @GetMapping({"/admin"})     // 관리자 접속하는 곳
    public ModelAndView admin(ModelAndView modelAndView){
        String viewName = "/WEB-INF/views/admin.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
    @GetMapping({"/manager/read"})     // 관리자 접속하는 곳
    public ModelAndView manager(ModelAndView modelAndView){
        String viewName = "/WEB-INF/views/manager/read.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
