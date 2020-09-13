package com.fpoly.services;

import com.fpoly.models.ArrayImage;

import java.util.Optional;

public interface ArrayImageService {
    ArrayImage save(ArrayImage s);

    Iterable<ArrayImage> saveAll(Iterable<ArrayImage> iterable);

    Optional<ArrayImage> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<ArrayImage> findAll();

    Iterable<ArrayImage> findAllById(Iterable<Integer> iterable);

    long count();

    void deleteById(Integer integer);

    void delete(ArrayImage arrayImage);

    void deleteAll(Iterable<? extends ArrayImage> iterable);

    void deleteAll();
}
