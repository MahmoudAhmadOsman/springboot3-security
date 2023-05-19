package com.security.peso.controller;

import com.security.peso.model.Student;
import com.security.peso.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/students")
//@RequestMapping()
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public String Home() {
        return "Welcome to students page";
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }


}
