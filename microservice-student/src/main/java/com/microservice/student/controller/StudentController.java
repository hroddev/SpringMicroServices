package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudenService istudenService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        istudenService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStuden(){
        return  ResponseEntity.ok(istudenService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(Long id){
        return  ResponseEntity.ok(istudenService.findById(id));
    }


}
