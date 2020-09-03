package org.ac.PetClinic001.repositories;

import org.ac.PetClinic001.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet, Long> {
}
