package com.odhiambopaul.petclinic.services.map;

import com.odhiambopaul.petclinic.model.Pet;
import com.odhiambopaul.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object, object.getId());
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
