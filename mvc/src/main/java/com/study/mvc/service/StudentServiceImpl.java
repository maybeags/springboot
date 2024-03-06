package com.study.mvc.service;

import com.study.mvc.entity.Students;
import com.study.mvc.repository.StudentRepository;
import com.study.mvc.repository.StudentRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private Students students;

    @Override
    public List<Students> getStudentList() {
//        밑에 부분은 지금 내가 Students 자료형으로 받아서 안먹힘 -> 현재 중간과정임
//        List<Map<String, String>> studentMapList = new ArrayList<>();
//        List<String> studentsList = studentRepository.getStudentListAll();
//        for(String studentName : studentList) {
//              studentMapList.add(Map.of("name", studentName));
        return studentRepository.getStudentListAll();
    }

    @Override
    public Students getStudent(int index) {
        return studentRepository.findStudentNameByIndex(index);


    }
}
