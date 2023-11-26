package com.example.quiz2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message = "Id cannot be null")
    private String id;
    @NotEmpty(message = "name cannot be null")
    private String name;
    @NotNull(message = "Salary cannot be null")
    private double salary;
}
