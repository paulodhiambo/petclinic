package com.odhiambopaul.petclinic.bootstrap;

import com.odhiambopaul.petclinic.model.Owner;
import com.odhiambopaul.petclinic.model.Pet;
import com.odhiambopaul.petclinic.model.PetType;
import com.odhiambopaul.petclinic.model.Vet;
import com.odhiambopaul.petclinic.services.OwnerService;
import com.odhiambopaul.petclinic.services.PetTypeService;
import com.odhiambopaul.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        Pet mikespet = new Pet();
        mikespet.setPetType(dog);
        mikespet.setBirthDate(LocalDate.now());
        mikespet.setName("Rosco");

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Pet ricopet = new Pet();
        ricopet.setPetType(cat);
        ricopet.setBirthDate(LocalDate.now());
        ricopet.setName("Roco");


        Owner owner = new Owner();
        owner.setFirstName("Paul");
        owner.setLastName("Odhiambo");
        owner.setAddress("Nairobi West");
        owner.setCity("Nairobi");
        owner.setTelephone("0700000000");
        owner.getPets().add(mikespet);
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Peter");
        owner1.setLastName("Odhiambo");
        owner1.setAddress("Kisumu,Mamboleo");
        owner1.setCity("Kisumu");
        owner1.setTelephone("0711111111");
        owner1.getPets().add(ricopet);
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
