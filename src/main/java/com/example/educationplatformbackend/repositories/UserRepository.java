package com.example.educationplatformbackend.repositories;

import com.example.educationplatformbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  User findByEmail(String email);
}
