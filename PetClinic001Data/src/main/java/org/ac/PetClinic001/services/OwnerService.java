package org.ac.PetClinic001.services;

import java.util.Set;

import org.ac.PetClinic001.model.Owner;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}