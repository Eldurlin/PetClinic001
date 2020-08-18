package org.ac.PetClinic001.services;

import org.ac.PetClinic001.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}