package com.school.project.services.impl;

import com.school.project.dao.ClasseRepository;
import com.school.project.entities.Classe;
import com.school.project.services.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;
    @Override
    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }
}
