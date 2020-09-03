package org.ac.PetClinic001.repositories;

import org.ac.PetClinic001.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit, Long> {
}
