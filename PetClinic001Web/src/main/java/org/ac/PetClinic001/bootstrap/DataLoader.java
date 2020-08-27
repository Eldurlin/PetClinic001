package org.ac.PetClinic001.bootstrap;

import org.ac.PetClinic001.model.Owner;
import org.ac.PetClinic001.model.PetType;
import org.ac.PetClinic001.model.Vet;
import org.ac.PetClinic001.services.OwnerService;
import org.ac.PetClinic001.services.PetTypeService;
import org.ac.PetClinic001.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner();
		owner1.setFirstName("Esseral");
		owner1.setLastName("Nissail");
		
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Eldurlin");
		owner2.setLastName("Greza");
		
		ownerService.save(owner2);
		
		System.out.println("Loading owners");

		Vet vet1 = new Vet();
		vet1.setFirstName("Triss");
		vet1.setLastName("Merigold");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Tissaia");
		vet2.setLastName("de Vries");
		
		vetService.save(vet2);
		
		System.out.println("Loading vets");

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
	}
	
}
