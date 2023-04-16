package com.school.project.services.impl;

import com.school.project.dao.SchoolRepository;
import com.school.project.entities.School;
import com.school.project.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    @Override
    public School saveSchool(School school) {
        return this.schoolRepository.save(school);
    }

    @Override
    public List<School> getSchoolList() {
        return this.schoolRepository.findAll();
    }

    @Override
    public School getSchoolById(Long id) {
        Optional<School> school = this.schoolRepository.findById(id);
        if(school.isPresent())
            return school.get();
        return null;
    }

    @Override
    public void deleteSchool(Long id) {
        School school = this.getSchoolById(id);
        if(school != null)
            this.schoolRepository.delete(school);
    }

    @Override
    public void updateSchool(School school) {
        this.schoolRepository.save(school);
    }

    @Override
    public List<School> findBySchoolName(String schoolName) {
        return null;
    }
}
