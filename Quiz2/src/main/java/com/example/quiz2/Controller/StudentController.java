package com.example.quiz2.Controller;

import com.example.quiz2.Model.Student;
import com.example.quiz2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudents(@Valid @RequestBody Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        service.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id,@Valid @RequestBody Student student,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated = service.updateStudent(id,student);
        if (isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("student is updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id or student doesn't exist");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){
        boolean isDeleted = service.deleteStudent(id);
        if (isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Student is deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id or student doesn't exist");
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity getStudentName(@PathVariable String name){
        if (service.getStudentName(name) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid name or student doesn't exits");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.getStudentName(name));
    }

}
