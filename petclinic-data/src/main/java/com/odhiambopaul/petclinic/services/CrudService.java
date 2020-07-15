package com.odhiambopaul.petclinic.services;

import java.util.Set;

//Takes in a type and Id
public interface CrudService<T, E> {
    Set<T> findAll();

    T findById(E id);

    T save(T object);

    void delete(T object);
}
