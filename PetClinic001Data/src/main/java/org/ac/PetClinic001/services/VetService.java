package org.ac.PetClinic001.services;

import java.util.Set;

import org.ac.PetClinic001.model.Vet;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}