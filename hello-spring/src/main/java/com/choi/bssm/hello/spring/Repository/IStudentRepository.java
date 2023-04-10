package com.choi.bssm.hello.spring.Repository;

import com.choi.bssm.hello.spring.domain.Student;

public interface IStudentRepository {

    Long save(Student student);
}
