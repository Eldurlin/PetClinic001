package org.ac.PetClinic001.services.springdatajpa;

import org.ac.PetClinic001.model.Visit;
import org.ac.PetClinic001.repositories.VisitRepo;
import org.ac.PetClinic001.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitServiceJpa implements VisitService {
    private final VisitRepo visitRepo;

    public VisitServiceJpa(VisitRepo visitRepo) {
        this.visitRepo = visitRepo;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepo.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepo.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepo.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepo.delete(visit);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepo.deleteById(aLong);
    }
}
