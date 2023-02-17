package com.example.educationplatformbackend.controllers;

import com.example.educationplatformbackend.entities.Admin;
import com.example.educationplatformbackend.entities.Student;
import com.example.educationplatformbackend.repositories.AdminRepository;
import com.example.educationplatformbackend.repositories.StudentRepository;
import com.example.educationplatformbackend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminRepository adminRepository;
    //save operation
    @PostMapping("/create_admin")
    public Admin saveAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }
    //read operation
    @GetMapping("/display_admins")
    public List<Admin> fetchAdminlist(){
        return adminService.fetchAdminList();
    }
    @GetMapping("/display_admins/{id}")
    public ResponseEntity<Admin> displayAdminById(@PathVariable Long id){
        return adminService.displayAdmin(id);
    }
    //update operation
    @PutMapping("/edit_admin/{id}")
    public Admin updateAdmin(@RequestBody Admin admin,@PathVariable Long id){
        return adminService.updateAdmin(admin,id);
    }
    @PutMapping("/adminId/{adminId}/students/{studentId}")
    Admin enrollStudentToAdmin(
            @PathVariable Long adminId,
            @PathVariable Long studentId
    ){
        Student student=studentRepository.findById(studentId).get();
        Admin admin=adminRepository.findById(adminId).get();
        admin.enrolledStudent(student);
        return adminRepository.save(admin);
    }
    //delete operation
    @DeleteMapping("/delete_admin/{id}")
    public String removeAdminById(@PathVariable Long id){
        adminService.deleteAdminById(id);
        return "The admin has been deleted successfully";
    }

}
