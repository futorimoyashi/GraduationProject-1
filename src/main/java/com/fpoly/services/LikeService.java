package com.fpoly.services;

import com.fpoly.models.Like;

import java.util.Optional;

public interface LikeService {
    Like save(Like s);

    Iterable<Like> saveAll(Iterable<Like> iterable);

    Optional<Like> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Like> findAll();

    Iterable<Like> findAllById(Iterable<Integer> iterable);

    long count();

    void deleteById(Integer integer);

    void delete(Like like);

    void deleteAll(Iterable<? extends Like> iterable);

    void deleteAll();
}
