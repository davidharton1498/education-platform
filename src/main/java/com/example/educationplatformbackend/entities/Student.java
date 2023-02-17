package com.example.educationplatformbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Admin>admins=new HashSet<>();

    public Student(Set<Admin> admins, Set<Teacher> teachers) {
        this.admins = admins;
        this.teachers = teachers;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    private Admin admin;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Teacher>teachers=new HashSet<>();


    @ManyToOne(fetch=FetchType.LAZY)
    private Teacher teacher;
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Subject>subjects=new HashSet<>();


    @ManyToOne(fetch=FetchType.LAZY)
    private Subject subject;
    public Student() {
    }

    public Student(long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

