package com.fpoly.services;

import com.fpoly.models.Collection;

import java.util.Optional;

public interface CollectionService {
    Collection save(Collection entity);

    Iterable<Collection> saveAll(Iterable<Collection> iterable);

    Optional<Collection> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Collection> findAll();

    Iterable<Collection> findAllById(Iterable<Integer> iterable);

    long count();

    void deleteById(Integer integer);

    void delete(Collection collection);

    void deleteAll(Iterable<? extends Collection> iterable);

    void deleteAll();
}
