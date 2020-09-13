package com.fpoly.services;

import com.fpoly.models.Frame;

import java.util.Optional;

public interface FrameService {
    Frame save(Frame s);

    Iterable<Frame> saveAll(Iterable<Frame> iterable);

    Optional<Frame> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Frame> findAll();

    Iterable<Frame> findAllById(Iterable<Integer> iterable);

    long count();

    void deleteById(Integer integer);

    void delete(Frame frame);

    void deleteAll(Iterable<? extends Frame> iterable);

    void deleteAll();
}
