package com.fpoly.services;

import com.fpoly.models.Comment;
import com.fpoly.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment s) {
        return commentRepository.save(s);
    }

    @Override
    public Iterable<Comment> saveAll(Iterable<Comment> iterable) {
        return commentRepository.saveAll(iterable);
    }

    @Override
    public Optional<Comment> findById(Integer integer) {
        return commentRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return commentRepository.existsById(integer);
    }

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Iterable<Comment> findAllById(Iterable<Integer> iterable) {
        return commentRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return commentRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        commentRepository.deleteById(integer);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void deleteAll(Iterable<? extends Comment> iterable) {
        commentRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        commentRepository.deleteAll();
    }
}
