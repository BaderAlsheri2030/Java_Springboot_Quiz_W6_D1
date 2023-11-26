package com.example.quiz2.Controller;

import com.example.quiz2.Model.Teacher;
import com.example.quiz2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        service.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher is added");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){
        boolean isDeleted =service.deleteTeacher(id);
        if (isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Teacher is deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id or teacher doesn't exist");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id,@Valid @RequestBody Teacher teacher,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated = service.updateTeacher(id,teacher);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("Teahcer is updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id or Teacher doesn't exist");
    }

    @GetMapping("/get/one/{id}")
    public ResponseEntity getOneTeacher(@PathVariable String id){
        if (service.getOneTeacher(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id or teacher doesn't exist");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.getOneTeacher(id));
    }
}
