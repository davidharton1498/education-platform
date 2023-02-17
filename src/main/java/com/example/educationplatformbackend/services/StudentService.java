package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    //read operation
    List<Student> fetchStudentList();

    //update operation
    Student updateStudent(Student student, Long id);
    ResponseEntity<Student> displayStudent(Long id);
    //delete operation
    void deleteStudentById(Long id);
}
