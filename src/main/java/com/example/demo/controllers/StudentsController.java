package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentsController {

    private final StudentsService studentsService;

    @GetMapping
    public List<Student> index() {
        return studentsService.index();
    }

    @PostMapping("/create")
    public Student create(@RequestBody Student student) {
        return studentsService.create(student);
    }

}
