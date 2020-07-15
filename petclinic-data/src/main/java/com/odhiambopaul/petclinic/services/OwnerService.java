package com.odhiambopaul.petclinic.services;

import com.odhiambopaul.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
