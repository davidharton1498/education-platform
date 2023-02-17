package com.example.educationplatformbackend.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;
    @ManyToMany
    @JoinTable(name="student_created_for_subject",
            joinColumns = @JoinColumn(name="subject_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private Set<Student> enrolledStudents=new HashSet<>();
    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    public Subject() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enrolledStudent(Student student) {
        enrolledStudents.add(student);
    }
}
