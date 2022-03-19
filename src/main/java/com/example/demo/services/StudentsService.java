package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentsService {

    private final StudentsRepository repository;

    public List<Student> index() {
        return repository.findAll();
    }

    public Student create(Student student) {
        Optional<Student> fetchedStudent = repository.findByEmail(student.getEmail());

        if (fetchedStudent.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }

        return repository.save(student);
    }

}
