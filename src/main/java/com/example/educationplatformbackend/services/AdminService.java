package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Admin;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    //save operation
    Admin saveAdmin(Admin admin);

    //read operation
    List<Admin>fetchAdminList();

    //update operation
    Admin updateAdmin(Admin admin, Long id);
    ResponseEntity<Admin> displayAdmin(Long id);
    //delete operation
    void deleteAdminById(Long id);

}
