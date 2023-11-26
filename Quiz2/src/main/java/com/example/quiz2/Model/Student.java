package com.example.quiz2.Model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "id must not  be empty")
    private String id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "age cannot be null")
    private int age;
    @NotEmpty(message = "major cannot be empty")
    private  String major;
}
