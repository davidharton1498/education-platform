package com.example.educationplatformbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "admin",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @ManyToMany
    @JoinTable(name="student_created_for_admin",
               joinColumns = @JoinColumn(name="admin_id"),
               inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private Set<Student>enrolledStudents=new HashSet<>();

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Admin() {

    }

    public Admin(long id, String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id && Objects.equals(firstName, admin.firstName) && Objects.equals(lastName, admin.lastName) && Objects.equals(email, admin.email) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password);
    }

    public void enrolledStudent(Student student) {
        enrolledStudents.add(student);
    }
}
