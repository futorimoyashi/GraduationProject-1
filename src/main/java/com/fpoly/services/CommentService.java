package com.fpoly.services;

import com.fpoly.models.Comment;

import java.util.Optional;

public interface CommentService {
    Comment save(Comment s);

    Iterable<Comment> saveAll(Iterable<Comment> iterable);

    Optional<Comment> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<Comment> findAll();

    Iterable<Comment> findAllById(Iterable<Integer> iterable);

    long count();

    void deleteById(Integer integer);

    void delete(Comment comment);

    void deleteAll(Iterable<? extends Comment> iterable);

    void deleteAll();
}
