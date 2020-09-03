package org.ac.PetClinic001.services.springdatajpa;

import org.ac.PetClinic001.model.Speciality;
import org.ac.PetClinic001.repositories.SpecialityRepo;
import org.ac.PetClinic001.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitiesServiceJpa implements SpecialitiesService {
    private final SpecialityRepo specialityRepo;

    public SpecialitiesServiceJpa(SpecialityRepo specialityRepo) {
        this.specialityRepo = specialityRepo;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepo.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepo.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepo.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepo.deleteById(aLong);
    }
}
