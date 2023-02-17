package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Student;
import com.example.educationplatformbackend.entities.Subject;
import com.example.educationplatformbackend.repositories.StudentRepository;
import com.example.educationplatformbackend.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubjectServiceImp implements SubjectService{
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> fetchSubjectList() {
        return (List<Subject>)subjectRepository.findAll();
    }

    @Override
    public Subject updateSubject(Subject subject, Long id) {
        Subject newSubject=subjectRepository.findById(id).get();
        if (Objects.nonNull(subject.getName())
                && !"".equalsIgnoreCase(
                subject.getName())) {
            newSubject.setName(
                    subject.getName());
        }
        return subjectRepository.save(newSubject);
    }

    @Override
    public ResponseEntity<Subject> displaySubject(Long id) {
        Optional<Subject > group = subjectRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }
}
