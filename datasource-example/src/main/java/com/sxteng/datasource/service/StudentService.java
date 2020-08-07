package com.sxteng.datasource.service;

import com.sxteng.datasource.bean.Student;
import com.sxteng.datasource.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> selectStudent() {

        return studentMapper.selectStudent();

    }
}
