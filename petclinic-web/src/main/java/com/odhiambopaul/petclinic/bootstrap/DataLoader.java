package com.odhiambopaul.petclinic.bootstrap;

import com.odhiambopaul.petclinic.model.*;
import com.odhiambopaul.petclinic.services.OwnerService;
import com.odhiambopaul.petclinic.services.PetTypeService;
import com.odhiambopaul.petclinic.services.SpecialtyService;
import com.odhiambopaul.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        Pet mikespet = new Pet();
        mikespet.setPetType(dog);
        mikespet.setBirthDate(LocalDate.now());
        mikespet.setName("Rosco");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

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
        vet.getSpecialties().add(savedRadiology);

        Vet vet1 = new Vet();
        vet1.setFirstName("Kj");
        vet1.setLastName("L2");
        vetService.save(vet1);
        vet1.getSpecialties().add(savedSurgery);
        System.out.println("Loaded Vets..................");
    }
}
