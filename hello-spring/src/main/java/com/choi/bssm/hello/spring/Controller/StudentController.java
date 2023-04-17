package com.choi.bssm.hello.spring.Controller;

import com.choi.bssm.hello.spring.Service.StudnetService;
import com.choi.bssm.hello.spring.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudnetService studnetService;

    @GetMapping("/students/new")
    public String create(){
        return "students/CreateStudentForm";
    }

    @PostMapping("/students/new")
    public String create(StudentForm form){
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());
        studnetService.edit(student);
        return "redirect:/";
    }

    @GetMapping("/students")
    public String studentList(Model model){
        model.addAttribute("students", studnetService.findStudents());
        return"students/studentList";
    }

    @GetMapping("/students/{id}/input")
    public String updateStudent(@PathVariable("id") Long id,
                                Model model){
        Student student = studnetService.findOne(id);
        StudentForm form = new StudentForm();
        form.setId(student.getId());
        form.setName(student.getName());
        form.setScore(student.getScore());
        model.addAttribute("form",form);

        return "students/updateStudentsForm";
    }

    @PostMapping("/students/{id}/input")
    public String updateScore(@PathVariable("id") Long id,
                             @ModelAttribute StudentForm form){
        Student student = new Student();
        student.setId(id);
        student.setScore(form.getScore());

        studnetService.updateScore(student);
        return "redirect:/students";
    }
}
