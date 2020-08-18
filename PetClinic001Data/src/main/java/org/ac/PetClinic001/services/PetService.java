package org.ac.PetClinic001.services;

import java.util.Set;

import org.ac.PetClinic001.model.Pet;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}