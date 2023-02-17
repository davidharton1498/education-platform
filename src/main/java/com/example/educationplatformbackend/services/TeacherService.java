package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);

    //read operation
    List<Teacher> fetchTeacherList();

    //update operation
    Teacher updateTeacher(Teacher teacher, Long id);
    ResponseEntity<Teacher> displayTeacher(Long id);
    //delete operation
    void deleteTeacherById(Long id);
}
