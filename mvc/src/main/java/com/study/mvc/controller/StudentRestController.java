package com.study.mvc.controller;

import com.study.mvc.entity.Students;
import com.study.mvc.repository.StudentRepositoryImpl;
import com.study.mvc.service.StudentService;
import com.study.mvc.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentRestController {
    private final StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    @Autowired
    @Qualifier("studentServiceImpl")
    private final StudentService studentService = new StudentServiceImpl();


    @GetMapping("/ex/students")
    public ResponseEntity<?> getStudentList() {
        System.out.println(studentService.getStudentList());
        return ResponseEntity.ok().body(studentService.getStudentList());
    }

//    @GetMapping("/ex/student/{index}")
//    public Students getStudent(@PathVariable int index) {
//        return studentService.getStudent(index);
//    }

    @GetMapping("/ex/student/{index}")
    public Students students (@PathVariable int index) {
//        return ResponseEntity.ok("학생 단건 조회 : " + index);
        return studentService.getStudent(index);

    }
}
