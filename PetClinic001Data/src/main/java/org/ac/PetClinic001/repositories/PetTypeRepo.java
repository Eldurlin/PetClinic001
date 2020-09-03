package org.ac.PetClinic001.repositories;

import org.ac.PetClinic001.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
