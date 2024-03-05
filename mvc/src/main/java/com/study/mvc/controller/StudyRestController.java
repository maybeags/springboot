package com.study.mvc.controller;

import com.study.mvc.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StudyRestController {

    @GetMapping("/hello/test")
    public String hello(HelloDto helloDto) {     //주소창에서는 기본적으로 String이지만 자동으로 형변환해주기 때문에 parseInt하지 않아도 된다.
        System.out.println(helloDto);

        return "Hello";
    }
}
