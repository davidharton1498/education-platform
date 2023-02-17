package com.example.educationplatformbackend.services;

import com.example.educationplatformbackend.entities.Admin;
import com.example.educationplatformbackend.repositories.AdminRepository;
import com.example.educationplatformbackend.repositories.RoleRepository;
import com.example.educationplatformbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
   // private PasswordEncoder passwordEncoder;

    public AdminServiceImp() {
    }

    //save operation
    @Override
    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    //read operation
    @Override
    public List<Admin>fetchAdminList(){
        return (List<Admin>)adminRepository.findAll();
    }
    //update operation
    @Override
    public Admin updateAdmin(Admin admin, Long id){
        Admin newAdmin=adminRepository.findById(id).get();
        if (Objects.nonNull(admin.getFirstName())
                && !"".equalsIgnoreCase(
                admin.getFirstName())) {
            newAdmin.setFirstName(
                    admin.getFirstName());
        }
        if (Objects.nonNull(admin.getLastName())
                && !"".equalsIgnoreCase(
                admin.getLastName())) {
            newAdmin.setLastName(
                    admin.getLastName());
        }
        if (Objects.nonNull(admin.getPassword())
                && !"".equalsIgnoreCase(
                admin.getPassword())) {
            newAdmin.setPassword(
                    admin.getPassword());
        }
        if (Objects.nonNull(admin.getEmail())
                && !"".equalsIgnoreCase(
                admin.getEmail())) {
            newAdmin.setEmail(
                    admin.getEmail());
        }
        return adminRepository.save(newAdmin);
    }

    @Override
    public ResponseEntity<Admin> displayAdmin(Long id) {
        Optional<Admin > group = adminRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //delete operation
    @Override
    public void deleteAdminById(Long id){
        adminRepository.deleteById(id);
    }

}
