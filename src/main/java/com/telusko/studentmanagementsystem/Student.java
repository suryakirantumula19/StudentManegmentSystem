
package com.telusko.studentmanagementsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name is required")
    private String name;

    @NotNull(message = "Marks are required")
    @DecimalMin(value = "0.0", message = "Marks cannot be below 0")
    @DecimalMax(value = "100.0", message = "Marks cannot exceed 100")
    private Double marks;

    public Student() {
    }

    public Student(String name, Double marks) {
        this.name = name;
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }
}
