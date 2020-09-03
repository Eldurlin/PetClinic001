package org.ac.PetClinic001.repositories;

import org.ac.PetClinic001.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
