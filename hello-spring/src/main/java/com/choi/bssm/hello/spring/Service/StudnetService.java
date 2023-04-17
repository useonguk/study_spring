package com.choi.bssm.hello.spring.Service;

import com.choi.bssm.hello.spring.Repository.IStudentRepository;
import com.choi.bssm.hello.spring.Repository.MemoryStudentRepository;
import com.choi.bssm.hello.spring.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudnetService {
    private final IStudentRepository repository;
    @Autowired
    public StudnetService(IStudentRepository repository){
        this.repository = repository;
    }
    public long edit(Student student){
        //1. 같은 학번이 있나?
        validatebuplicateStudent(student);
        //2. 값을 저장
        Long input = repository.save(student);
        return input;
    }

    private void validatebuplicateStudent(Student student){
        //중복확인;;;
        if ( repository.findById(student.getId()) != null ){
            throw new IllegalStateException("이미 등록");
        }
    }

    public List<Student> findStudents(){
        return repository.findAll();
    }

    public Long updateScore(Student student) {
        Student update = repository.findById(student.getId());
        update.setScore(student.getScore());
        return update.getId();
    }

    public Student findOne(Long id) {
        return repository.findById(id);
    }
}
