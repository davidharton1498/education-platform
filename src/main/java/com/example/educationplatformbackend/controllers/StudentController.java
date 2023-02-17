package com.example.educationplatformbackend.controllers;

import com.example.educationplatformbackend.entities.Student;
import com.example.educationplatformbackend.entities.Subject;
import com.example.educationplatformbackend.entities.Teacher;
import com.example.educationplatformbackend.repositories.StudentRepository;
import com.example.educationplatformbackend.repositories.SubjectRepository;
import com.example.educationplatformbackend.repositories.TeacherRepository;
import com.example.educationplatformbackend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    //save operation
    @PostMapping("/create_student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    //read operation
    @GetMapping("/display_students")
    public List<Student> fetchAdminlist(){
        return studentService.fetchStudentList();
    }
    @GetMapping("/display_admins/{id}")
    public ResponseEntity<Student> displayAdminById(@PathVariable Long id){
        return studentService.displayStudent(id);
    }
    //update operation
    @PutMapping("/edit_student/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable Long id){
        return studentService.updateStudent(student,id);
    }
    //assign student to teacher
    @PutMapping("/teacherId/{teacherId}/students/{studentId}")
    Teacher enrollStudentToTeacher(
            @PathVariable Long teacherId,
            @PathVariable Long studentId
    ){
        Student student=studentRepository.findById(studentId).get();
        Teacher teacher=teacherRepository.findById(teacherId).get();
        teacher.enrolledStudent(student);
        return teacherRepository.save(teacher);
    }
    //assign student to subject
    @PutMapping("/subjectId/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ){
        Student student=studentRepository.findById(studentId).get();
        Subject subject=subjectRepository.findById(subjectId).get();
        subject.enrolledStudent(student);
        return subjectRepository.save(subject);
    }
    //delete operation
    @DeleteMapping("/delete_student/{id}")
    public String removeStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "The student has been deleted successfully";
    }
}
