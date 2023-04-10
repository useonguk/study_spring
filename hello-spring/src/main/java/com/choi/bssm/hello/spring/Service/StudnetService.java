package com.choi.bssm.hello.spring.Service;

import com.choi.bssm.hello.spring.Repository.IStudentRepository;
import com.choi.bssm.hello.spring.Repository.MemoryStudentRepository;
import com.choi.bssm.hello.spring.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudnetService {
    private final IStudentRepository repository;
    public StudnetService(IStudentRepository repository){
        this.repository = repository;
    }
    public long edit(Student student){
        //1. 같은 학번이 있나?
        //2. 값을 저장
        Long input = repository.save(student);
        return input;
    }
}
