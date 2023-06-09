package com.security.controller;

import com.security.model.Student;
import com.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping(path = "/api/v1/students")
@RequestMapping()
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public String Home() {
        return "Welcome to students page";
    }

    @GetMapping(value = "/students/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PostMapping(value = "/students/save")
//    @PreAuthorize("hasAuthority('ADMIN')") // only 1 authority
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')") // many authorities
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }


}
