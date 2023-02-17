package com.example.educationplatformbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedClassrooms")
    private Set<Teacher> teachers=new HashSet<>();
    public Classroom() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
