package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Student;
import com.example.educationplatformbackend.entities.Teacher;
import com.example.educationplatformbackend.repositories.StudentRepository;
import com.example.educationplatformbackend.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> fetchTeacherList() {
        return (List<Teacher>)teacherRepository.findAll();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, Long id) {
        Teacher newAdmin=teacherRepository.findById(id).get();
        if (Objects.nonNull(teacher.getFirstName())
                && !"".equalsIgnoreCase(
                teacher.getFirstName())) {
            newAdmin.setFirstName(
                    teacher.getFirstName());
        }
        if (Objects.nonNull(teacher.getLastName())
                && !"".equalsIgnoreCase(
                teacher.getLastName())) {
            newAdmin.setLastName(
                    teacher.getLastName());
        }
        if (Objects.nonNull(teacher.getPassword())
                && !"".equalsIgnoreCase(
                teacher.getPassword())) {
            newAdmin.setPassword(
                    teacher.getPassword());
        }
        if (Objects.nonNull(teacher.getEmail())
                && !"".equalsIgnoreCase(
                teacher.getEmail())) {
            newAdmin.setEmail(
                    teacher.getEmail());
        }
        return teacherRepository.save(newAdmin);
    }

    @Override
    public ResponseEntity<Teacher> displayTeacher(Long id) {
        Optional<Teacher > group = teacherRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }
}
