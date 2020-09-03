package org.ac.PetClinic001.services.springdatajpa;

import org.ac.PetClinic001.model.Owner;
import org.ac.PetClinic001.repositories.OwnerRepo;
import org.ac.PetClinic001.repositories.PetRepo;
import org.ac.PetClinic001.repositories.PetTypeRepo;
import org.ac.PetClinic001.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerServiceJpa implements OwnerService {
    private final OwnerRepo ownerRepo;
    private final PetRepo petRepo;
    private final PetTypeRepo petTypeRepo;

    public OwnerServiceJpa(OwnerRepo ownerRepo,
                           PetRepo petRepo,
                           PetTypeRepo petTypeRepo) {
        this.ownerRepo = ownerRepo;
        this.petRepo = petRepo;
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepo.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepo.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepo.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepo.deleteById(aLong);
    }
}
