package com.fpoly.services;

import com.fpoly.models.Like;
import com.fpoly.repositories.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService{

    private LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like save(Like s) {
        return likeRepository.save(s);
    }

    @Override
    public Iterable<Like> saveAll(Iterable<Like> iterable) {
        return likeRepository.saveAll(iterable);
    }

    @Override
    public Optional<Like> findById(Integer integer) {
        return likeRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return likeRepository.existsById(integer);
    }

    @Override
    public Iterable<Like> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public Iterable<Like> findAllById(Iterable<Integer> iterable) {
        return likeRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return likeRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        likeRepository.deleteById(integer);
    }

    @Override
    public void delete(Like like) {
        likeRepository.delete(like);
    }

    @Override
    public void deleteAll(Iterable<? extends Like> iterable) {
        likeRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        likeRepository.deleteAll();
    }
}
