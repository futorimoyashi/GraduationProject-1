package com.fpoly.services;

import com.fpoly.models.Collection;

import java.util.List;
import java.util.Optional;

public interface CollectionService {
    Collection save(Collection entity);

    Iterable<Collection> saveAll(List<Collection> iterable);

    Optional<Collection> findById(Integer integer);

    boolean existsById(Integer integer);

    List<Collection> findAll();

    List<Collection> findAllById(List<Integer> iterable);

    long count();

    void deleteById(Integer integer);

    void delete(Collection collection);

    void deleteAll(Iterable<? extends Collection> iterable);

    void deleteAll();

	List<Collection> findByNameLikeOrderByName(String Name);
}
