package dev.clarke.rest.controller;

import dev.clarke.rest.models.Student;
import dev.clarke.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/update/{id}")
    public String updateStudent(@PathVariable long id, @RequestBody Student student) {
        Student updatedStudent = studentRepository.findById(id).get();
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName((student.getLastName()));
        updatedStudent.setAge(student.getAge());
        updatedStudent.setMajor(student.getMajor());
        studentRepository.save(updatedStudent);
        return "Updated student...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        Student deletedStudent = studentRepository.findById(id).get();
        studentRepository.delete(deletedStudent);
        return "Deleted user with id: " + id;
    }

}
