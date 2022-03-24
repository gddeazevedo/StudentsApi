package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentsRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public record StudentsService(StudentsRepository repository) {

    public List<Student> index() {
        return repository.findAll();
    }

    public Student show(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Student create(Student student) {
        Optional<Student> fetchedStudent = repository.findByEmail(student.getEmail());

        if (fetchedStudent.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }

        return repository.save(student);
    }

    @Transactional
    public Student update(Long id, Student student) {
        Optional<Student> fetchedStudent = repository.findById(id);

        if (fetchedStudent.isEmpty()) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }

        Student updatedStudent = fetchedStudent.get();

        updatedStudent.setName(student.getName());
        updatedStudent.setDob(student.getDob());
        updatedStudent.setEmail(student.getEmail());

        return updatedStudent;
    }

    public void delete(Long id) {
        boolean studentExists = repository.existsById(id);

        if (!studentExists) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }

        repository.deleteById(id);
    }

}
