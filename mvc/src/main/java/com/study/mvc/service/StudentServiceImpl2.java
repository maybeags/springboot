package com.study.mvc.service;

import com.study.mvc.dto.StudentExDto;
import com.study.mvc.entity.Students;
import com.study.mvc.repository.StudentRepository;
import com.study.mvc.repository.StudentRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl2 implements StudentService{
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private Students students;

    @Override
    public List<Students> getStudentList() {
//        얘도 지금 Dto만든 버전인데 entity를 만드는 바람에 그대로 두면 터짐
//        List<StudentExDto> studentDtoList = new ArrayList<>();
//        List<String> studentList = studentRepository.getStudentListAll();
//
//        for(String studentName : studentList) {
//            studentDtoList.add(new StudentExDto(studentName));
//        }
        return studentRepository.getStudentListAll();
    }

    @Override
    public Students getStudent(int index) {
        return students;

    }
}
