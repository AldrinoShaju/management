package com.example.student.management.controller;


import com.example.student.management.dto.StudentDto;
import com.example.student.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.student.management.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

//    @Autowired
    private StudentDto studentDto;

    @Autowired
    private StudentService studentService;

//    @GetMapping("/error")
//    public String testing(){
//        return "HELLO WORLD";
//    }

    @GetMapping(path = "/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return studentService.getStudentDetail(id);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentDto data){
        return studentService.addStudent(data.getFirstName(), data.getLastName());
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") int id, @RequestBody StudentDto data){
        return studentService.updateStudent(data.getFirstName(), data.getLastName(), id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        return studentService.deleteStudent(id);
    }
}
