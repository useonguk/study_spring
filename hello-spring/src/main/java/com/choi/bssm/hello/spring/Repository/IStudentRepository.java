package com.choi.bssm.hello.spring.Repository;

import com.choi.bssm.hello.spring.domain.Student;

import java.util.List;

public interface IStudentRepository {

    Long save(Student student);
    Student findById(Long id);


    List<Student> findAll();
}
