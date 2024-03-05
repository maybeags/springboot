package com.study.mvc.controller;

import com.study.mvc.model.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/*
*  Controller명: StudentController
*
* 메서드명: getStudentInfo()
* 요청 메서드: Get
* 요청 URL: /student
* 요청 Params: name, age, phone, address
* 응답데이터: JSON(name, age, phone, address)
* */
@Controller
public class StudyController {  //@Controller 작성하면, Servlet 만드는 것과 비슷하다

    // MVC
    @GetMapping("/hello")
    public String helloPage(Model model) {
        HelloModel helloModel = HelloModel.builder()
                .name1("김준일")
                .name2("김준이")
                .name3("김준삼")
                .build();

        model.addAttribute("h", helloModel);
        return "hello";
//        Map<String, Object> model = new HashMap<>();
//        model.put("name1", "김준일");
//        model.put("name2", "김준이");
//        model.put("name3", "김준삼");
//        model.addAttribute("name1", "김준일");
//        model.addAttribute("name2", "김준이");
//        model.addAttribute("name3", "김준삼");
//      return new ModelAndView("hello", model);
    }


    // REST
    @GetMapping("test")
    @ResponseBody           //Body가 나오면 Data라고 생각하세요.
    public Map<String, Object> testPage() {
//        model.addAttribute("age", 32);
        Map<String, Object> testObj = new HashMap<>();
        testObj.put("age", 32);
        return testObj;
    }
}
