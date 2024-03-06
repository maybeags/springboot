package com.study.mvc.repository;

import com.study.mvc.entity.Students;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private List<Students> studentList = List.of(new Students("전주환"), new Students("서창현"), new Students("예홍렬"));

    @Override
    public List<Students> getStudentListAll() {
        return studentList;
    }

    @Override
    public Students findStudentNameByIndex(int index) {
        Students studentName = null;
        for(int i = 0; i < studentList.size(); i++) {
            if(index == i) {
                studentName = studentList.get(i);
            }
        }
        System.out.println("학생이름: " + studentName);
       return studentName;
    }


}
