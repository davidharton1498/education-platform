package com.example.educationplatformbackend.repositories;

import com.example.educationplatformbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<User,Long> {

}
