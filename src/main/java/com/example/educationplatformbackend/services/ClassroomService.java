package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Classroom;
import com.example.educationplatformbackend.entities.Subject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClassroomService {
    Classroom saveClassroom(Classroom classroom);

    //read operation
    List<Classroom> fetchClassroomList();

    //update operation
    Classroom updateClassroom(Classroom classroom, Long id);
    ResponseEntity<Classroom> displayClassroom(Long id);
    //delete operation
    void deleteClassroomById(Long id);
}
