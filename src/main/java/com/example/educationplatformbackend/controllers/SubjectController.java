package com.example.educationplatformbackend.controllers;


import com.example.educationplatformbackend.entities.Subject;
import com.example.educationplatformbackend.repositories.SubjectRepository;
import com.example.educationplatformbackend.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    //save operation
    @PostMapping("/create_subject")
    public Subject saveSubject(@RequestBody Subject subject){
        return subjectService.saveSubject(subject);
    }
    //read operation
    @GetMapping("/display_subjects")
    public List<Subject> fetchSubjectlist(){
        return subjectService.fetchSubjectList();
    }
    @GetMapping("/display_subjects/{id}")
    public ResponseEntity<Subject> displaySubjectById(@PathVariable Long id){
        return subjectService.displaySubject(id);
    }
    //update operation
    @PutMapping("/edit_subjects/{id}")
    public Subject updateStudent(@RequestBody Subject subject,@PathVariable Long id){
        return subjectService.updateSubject(subject,id);
    }
    //delete operation
    @DeleteMapping("/delete_subjects/{id}")
    public String deleteSubjectById(@PathVariable Long id){
        subjectService.deleteSubjectById(id);
        return "The subject has been deleted successfully";
    }
}
