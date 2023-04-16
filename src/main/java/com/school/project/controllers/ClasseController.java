package com.school.project.controllers;

import com.school.project.dao.SchoolRepository;
import com.school.project.entities.Classe;
import com.school.project.services.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classe/v1/")
public class ClasseController {

    private final ClasseService classeService;
    private final SchoolRepository schoolRepository;

    @PostMapping("{schoolId}/class-create")
    public ResponseEntity<?> createClasse(@PathVariable long schoolId, @RequestBody Classe _classe){
        Classe classe = this.schoolRepository.findById(schoolId).map(school1 -> {
            _classe.setSchool(school1);
            return classeService.saveClasse(_classe);
        }).orElseThrow(()-> new RuntimeException("Error occur"));
        return  ResponseEntity.status(HttpStatus.CREATED).body(classe);
    }
}
