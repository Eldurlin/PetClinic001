package org.ac.PetClinic001.services.springdatajpa;

import org.ac.PetClinic001.model.Owner;
import org.ac.PetClinic001.repositories.OwnerRepo;
import org.ac.PetClinic001.repositories.PetRepo;
import org.ac.PetClinic001.repositories.PetTypeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    public static final String LAST_NAME = "Cross";
    @Mock
    OwnerRepo ownerRepo;

    @Mock
    PetRepo petRepo;

    @Mock
    PetTypeRepo petTypeRepo;

    @InjectMocks
    OwnerServiceJpa serviceJpa;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepo.findByLastName(any())).thenReturn(returnOwner);

        Owner cross = serviceJpa.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, cross.getLastName());

        verify(ownerRepo).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add((Owner.builder().id(1L).build()));
        returnOwnerSet.add((Owner.builder().id(2L).build()));

        when(ownerRepo.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = serviceJpa.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepo.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = serviceJpa.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepo.save(any())).thenReturn(returnOwner);

        Owner savedOwner = serviceJpa.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        serviceJpa.delete(returnOwner);

        verify(ownerRepo).delete(any());
    }

    @Test
    void deleteById() {
        serviceJpa.deleteById(1L);

        verify(ownerRepo).deleteById(anyLong());
    }
}