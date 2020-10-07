package com.odhiambopaul.petclinic.bootstrap;

import com.odhiambopaul.petclinic.model.Owner;
import com.odhiambopaul.petclinic.model.PetType;
import com.odhiambopaul.petclinic.model.Vet;
import com.odhiambopaul.petclinic.services.OwnerService;
import com.odhiambopaul.petclinic.services.PetTypeService;
import com.odhiambopaul.petclinic.services.VetService;
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
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner = new Owner();
        owner.setFirstName("Paul");
        owner.setLastName("Odhiambo");
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Peter");
        owner1.setLastName("Odhiambo");
        ownerService.save(owner1);
        System.out.println("Loaded owners...............");

        Vet vet = new Vet();
        vet.setFirstName("Ogindo");
        vet.setLastName("Linus");
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Kj");
        vet1.setLastName("L2");
        vetService.save(vet1);
        System.out.println("Loaded Vets..................");
    }
}
