package com.example.demo.repository;

import com.example.demo.domain.Department;
import com.example.demo.domain.Gender;
import com.example.demo.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

    @SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void 저장됨(){
        Department department = Department.builder()
                .name("SW")
                .personnel(32L)
                .build();
        departmentRepository.save(department);

        Student student = Student.builder()
                        .id(1101L)
                        .name("홍길동")
                        .gender(Gender.MALE)
                        .build();
                studentRepository.save(student);
                assertEquals(
                studentRepository.findAll().get(0).getId(),1101L);
    }


}