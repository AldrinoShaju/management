package com.example.student.management.service;

import com.example.student.management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.management.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentDetail(int id){
        return studentRepository.findById(id).get();
    }

    public String addStudent(String firstName, String lastName){
        studentRepository.save(new Student(firstName, lastName));
        return "Student Details Added";
    }

    public String updateStudent(String firstName, String lastName, int id){
        Student updateStudent = studentRepository.findById(id).get();
        if(firstName!=null){
            updateStudent.setFirstName(firstName);
        }
        if(lastName!=null){
            updateStudent.setLastName(lastName);
        }
        studentRepository.save(updateStudent);
        return "Student Details Updated";
    }

    public String deleteStudent(int id){
        studentRepository.deleteById(id);
        return "Student Deleted";
    }
}
