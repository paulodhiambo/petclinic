package com.odhiambopaul.petclinic.services.map;

import com.odhiambopaul.petclinic.model.Vet;
import com.odhiambopaul.petclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object, object.getId());
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
