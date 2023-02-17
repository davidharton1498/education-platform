package com.example.educationplatformbackend.controllers;


import com.example.educationplatformbackend.entities.Classroom;
import com.example.educationplatformbackend.entities.Student;
import com.example.educationplatformbackend.entities.Subject;
import com.example.educationplatformbackend.entities.Teacher;
import com.example.educationplatformbackend.repositories.ClassroomRepository;
import com.example.educationplatformbackend.repositories.TeacherRepository;
import com.example.educationplatformbackend.services.ClassroomService;
import com.example.educationplatformbackend.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    //save operation
    @PostMapping("/create_classroom")
    public Classroom saveClassroom(@RequestBody Classroom classroom){
        return classroomService.saveClassroom(classroom);
    }
    //read operation
    @GetMapping("/display_classrooms")
    public List<Classroom> fetchClassroomlist(){
        return classroomService.fetchClassroomList();
    }
    @GetMapping("/display_classrooms/{id}")
    public ResponseEntity<Classroom> displayClassroomById(@PathVariable Long id){
        return classroomService.displayClassroom(id);
    }
    //update operation
    @PutMapping("/edit_classrooms/{id}")
    public Classroom updateClassroom(@RequestBody Classroom classroom,@PathVariable Long id){
        return classroomService.updateClassroom(classroom,id);
    }
    @PutMapping("/teacherId/{teacherId}/classrooms/{classroomId}")
    Teacher assignClassroomToTeacher(
            @PathVariable Long teacherId,
            @PathVariable Long classroomId
    ){
        Classroom classroom=classroomRepository.findById(classroomId).get();
        Teacher teacher=teacherRepository.findById(teacherId).get();
        teacher.assignedClassroom(classroom);
        return teacherRepository.save(teacher);
    }
    //delete operation
    @DeleteMapping("/delete_classrooms/{id}")
    public String deleteClassroomById(@PathVariable Long id){
        classroomService.deleteClassroomById(id);
        return "The classroom has been deleted successfully";
    }
}
