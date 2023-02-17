package com.example.educationplatformbackend.controllers;

import com.example.educationplatformbackend.entities.Teacher;
import com.example.educationplatformbackend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    //save operation
    @PostMapping("/register_teacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }
    //read operation
    @GetMapping("/display_teachers")
    public List<Teacher> fetchAdminlist(){
        return teacherService.fetchTeacherList();
    }
    @GetMapping("/display_teachers/{id}")
    public ResponseEntity<Teacher> displayAdminById(@PathVariable Long id){
        return teacherService.displayTeacher(id);
    }
    //update operation
    @PutMapping("/edit_teachers/{id}")
    public Teacher updateStudent(@RequestBody Teacher teacher,@PathVariable Long id){
        return teacherService.updateTeacher(teacher,id);
    }
    //delete operation
    @DeleteMapping("/delete_teachers/{id}")
    public String removeTeacherById(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return "The teacher has been deleted successfully";
    }
}
