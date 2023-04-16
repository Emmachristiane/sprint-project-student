package com.school.project.services;

import com.school.project.entities.School;

import java.util.List;

public interface SchoolService {
     School saveSchool(School school);
     List<School> getSchoolList();
     School getSchoolById(Long id);
     void deleteSchool(Long id);
     void updateSchool(School school);
     List<School> findBySchoolName(String schoolName);
}
