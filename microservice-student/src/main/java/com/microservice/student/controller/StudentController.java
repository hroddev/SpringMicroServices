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
    public ResponseEntity<?> findAllStudent(){
        return  ResponseEntity.ok(istudenService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return  ResponseEntity.ok(istudenService.findById(id));
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(istudenService.findByIdCourse(idCourse));
    }


}
