package com.school.project.controllers;


import com.school.project.entities.School;
import com.school.project.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/school/v1")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping("/schools")
    public ResponseEntity<?> getAllSchools(){
        List<School> schoolList = this.schoolService.getSchoolList();
        if(schoolList.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.OK).body(schoolList);
    }

    @GetMapping("/{schoolId}/school-index")
    public ResponseEntity<?> getSchoolById(@PathVariable long schoolId){
        School school = this.schoolService.getSchoolById(schoolId);
        if(school == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return  ResponseEntity.status(HttpStatus.OK).body(school);
    }

    @PostMapping("/create-school")
    public ResponseEntity<?> createSchool(@RequestBody School school){
        this.schoolService.updateSchool(
                new School(null,
                        school.getSchoolName(),
                        school.getSchoolLocation(),
                        school.getSchoolType(),
                        new Date()
                )
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{schoolId}/delete-school")
    public ResponseEntity<?> deleteSchool(@PathVariable long schoolId){
        this.schoolService.deleteSchool(schoolId);
        return ResponseEntity.status(HttpStatus.OK).body("delete successfully");
    }

    @PutMapping("{schoolId}/update-school")
    public ResponseEntity<?> updateSchool(@PathVariable long schoolId, @RequestBody School school){
        School school1 = this.schoolService.getSchoolById(schoolId);
        if(school1 != null){
            school1.setSchoolName(school.getSchoolName());
            school1.setSchoolLocation(school.getSchoolLocation());
            school1.setSchoolType(school.getSchoolType());
            this.schoolService.saveSchool(school1);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
