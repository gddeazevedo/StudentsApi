package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public record StudentsController(StudentsService studentsService) {

    @GetMapping
    public List<Student> index(
            @RequestParam(
                required = false,
                name = "orderBy"
            ) Integer orderBy
    ) {
        System.out.println("orderBy: " + orderBy);
        return studentsService.index();
    }

    @GetMapping("/{id}")
    public Student show(@PathVariable("id") Long id) {
        return studentsService.show(id);
    }

    @PostMapping("/create")
    public Student create(@RequestBody Student student) {
        return studentsService.create(student);
    }

    @PutMapping("/{id}/update")
    public Student update(
            @PathVariable("id") Long id,
            @RequestBody Student student
    ) {
        return studentsService.update(id, student);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        studentsService.delete(id);
    }

}
