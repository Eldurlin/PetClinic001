package org.ac.PetClinic001.services.springdatajpa;

import org.ac.PetClinic001.model.Vet;
import org.ac.PetClinic001.repositories.VetRepo;
import org.ac.PetClinic001.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetServiceJpa implements VetService {
    private final VetRepo vetRepo;

    public VetServiceJpa(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepo.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepo.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepo.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepo.deleteById(aLong);
    }
}
