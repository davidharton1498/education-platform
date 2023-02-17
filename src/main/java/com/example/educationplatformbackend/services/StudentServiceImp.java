package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Admin;
import com.example.educationplatformbackend.entities.Student;
import com.example.educationplatformbackend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return (List<Student>)studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student newAdmin=studentRepository.findById(id).get();
        if (Objects.nonNull(student.getFirstName())
                && !"".equalsIgnoreCase(
                student.getFirstName())) {
            newAdmin.setFirstName(
                    student.getFirstName());
        }
        if (Objects.nonNull(student.getLastName())
                && !"".equalsIgnoreCase(
                student.getLastName())) {
            newAdmin.setLastName(
                    student.getLastName());
        }
        if (Objects.nonNull(student.getPassword())
                && !"".equalsIgnoreCase(
                student.getPassword())) {
            newAdmin.setPassword(
                    student.getPassword());
        }
        if (Objects.nonNull(student.getEmail())
                && !"".equalsIgnoreCase(
                student.getEmail())) {
            newAdmin.setEmail(
                    student.getEmail());
        }
        return studentRepository.save(newAdmin);
    }

    @Override
    public ResponseEntity<Student> displayStudent(Long id) {
        Optional<Student > group = studentRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
