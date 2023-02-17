package com.example.educationplatformbackend.repositories;

import com.example.educationplatformbackend.entities.Classroom;
import com.example.educationplatformbackend.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
