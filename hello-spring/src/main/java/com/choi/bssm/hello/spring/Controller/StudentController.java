package com.choi.bssm.hello.spring.Controller;

import com.choi.bssm.hello.spring.Service.StudnetService;
import com.choi.bssm.hello.spring.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/students/new")
    public String create(){
        return "students/CreateStudentForm";
    }

    @GetMapping("/students/new")
    public String create(StudentForm form){
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());
        StudnetService studentService = null;
        studentService.edit(student);
        return "redirect/";
    }
}
