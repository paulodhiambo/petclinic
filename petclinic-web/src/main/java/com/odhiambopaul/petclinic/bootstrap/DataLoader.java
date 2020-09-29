package com.odhiambopaul.petclinic.bootstrap;

import com.odhiambopaul.petclinic.model.Owner;
import com.odhiambopaul.petclinic.model.Vet;
import com.odhiambopaul.petclinic.services.OwnerService;
import com.odhiambopaul.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Paul");
        owner.setLastName("Odhiambo");
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Peter");
        owner1.setLastName("Odhiambo");
        ownerService.save(owner1);
        System.out.println("Loaded owners...............");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Ogindo");
        vet.setLastName("Linus");
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Kj");
        vet1.setLastName("L2");
        vetService.save(vet);
        System.out.println("Loaded Vets..................");
    }
}
