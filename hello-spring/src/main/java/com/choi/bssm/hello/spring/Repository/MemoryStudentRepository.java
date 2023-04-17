package com.choi.bssm.hello.spring.Repository;

import com.choi.bssm.hello.spring.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryStudentRepository implements IStudentRepository{
    private static Map<Long, Student> store = new HashMap<>();

    @Override
    public Long save(Student student){
        store.put(student.getId(), student);
        return student.getId();
    }

    @Override
    public Student findById(Long id) {
        return store.get(id);
    }

    public List<Student> findAll(){
        ArrayList<Student> student = new ArrayList<>(store.values());
        return student;
    }

}
