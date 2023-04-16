package com.school.project.dao;

import com.school.project.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
