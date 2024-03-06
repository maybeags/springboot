package com.study.mvc.service;

import com.study.mvc.entity.Students;

import java.util.List;

public interface StudentService {
    public List<Students> getStudentList();
    public Students getStudent(int index);
}
