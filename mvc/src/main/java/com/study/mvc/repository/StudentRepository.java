package com.study.mvc.repository;

import com.study.mvc.entity.Students;

import java.util.List;

public interface StudentRepository {
    public List<Students> getStudentListAll();
    public Students findStudentNameByIndex(int index);
}
