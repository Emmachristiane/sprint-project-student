package com.school.project;

import com.school.project.dao.SchoolRepository;
import com.school.project.entities.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Date;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SchoolApplication implements CommandLineRunner {

    @Autowired
    public SchoolRepository schoolRepository;

    public void run(String... args) throws Exception {
        School s = new School(null, "ESTIA", "Paris", "Ecole", new Date());
        this.schoolRepository.save(s);
    }

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

}
