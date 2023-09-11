package dev.clarke.rest.controller;

import dev.clarke.rest.models.Student;
import dev.clarke.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome!";
    }

    @GetMapping(value = "/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student saved...";
    }

}
