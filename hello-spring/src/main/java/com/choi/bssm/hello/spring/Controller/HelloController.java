package com.choi.bssm.hello.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hell() {
        return "hello";
    }

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/hi/data")
    public String hiData(Model model){
        model.addAttribute("data", "mrchoi");
        return "hiData";
    }

    @GetMapping("/hi/parm")
    public String hiParam(@RequestParam("data") String data, Model model){
        model.addAttribute("data", data);
        return "hiData";
    }

    @GetMapping("/hello/param")
    @ResponseBody
    public String helloParam(@RequestParam("data")String data){
        return "hello " + data;
    }

    @GetMapping("/hello/api")
    @ResponseBody
    public String helloApi(@RequestParam("data")String data){
        Student1 student = new Student1(123L, data);
        return "hello " + student;
    }
    static class Student1{
        private long id;
        private String name;
        public Student1(long id, String name){
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}