package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Classroom;
import com.example.educationplatformbackend.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClassroomServiceImp implements ClassroomService{
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> fetchClassroomList() {
        return (List<Classroom>) classroomRepository.findAll();
    }

    @Override
    public Classroom updateClassroom(Classroom classroom, Long id) {
        Classroom newClassroom=classroomRepository.findById(id).get();
        if (Objects.nonNull(classroom.getName())
                && !"".equalsIgnoreCase(
                classroom.getName())) {
            newClassroom.setName(
                    classroom.getName());
        }
        return classroomRepository.save(newClassroom);
    }

    @Override
    public ResponseEntity<Classroom> displayClassroom(Long id) {
        Optional<Classroom > group = classroomRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteClassroomById(Long id) {
        classroomRepository.deleteById(id);
    }
}