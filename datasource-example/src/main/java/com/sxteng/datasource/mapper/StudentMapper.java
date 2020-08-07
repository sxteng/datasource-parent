package com.sxteng.datasource.mapper;


import com.sxteng.datasource.bean.Student;

import java.util.List;

public interface StudentMapper {

    void insert(Student student);

    List<Student> selectByCondition(Student student);

    List<Student> selectStudent();
}
