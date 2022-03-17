package com.example.demo.configs;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.time.LocalDate;
import static java.time.Month.*;


@Configuration
public class StudentsConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentsRepository repository) {
        return args -> {
            var dob1 = LocalDate.of(2000, JANUARY, 3);
            var dob2 = LocalDate.of(1978, NOVEMBER, 4);

            Student s1 = new Student("Asdas", dob1, "asdas@email.com");
            Student s2 = new Student("Loas", dob2, "loas@email.com");

            var students = List.of(s1, s2);

            repository.saveAll(students);
        };
    }
}
