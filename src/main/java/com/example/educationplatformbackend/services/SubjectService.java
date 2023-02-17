package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Subject;
import com.example.educationplatformbackend.entities.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectService {
    Subject saveSubject(Subject subject);

    //read operation
    List<Subject> fetchSubjectList();

    //update operation
    Subject updateSubject(Subject subject, Long id);
    ResponseEntity<Subject> displaySubject(Long id);
    //delete operation
    void deleteSubjectById(Long id);
}
