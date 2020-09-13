package com.fpoly.services;

import com.fpoly.models.Frame;
import com.fpoly.repositories.FrameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FrameServiceImpl implements FrameService{

    private FrameRepository frameRepository;

    public FrameServiceImpl(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    @Override
    public Frame save(Frame s) {
        return frameRepository.save(s);
    }

    @Override
    public Iterable<Frame> saveAll(Iterable<Frame> iterable) {
        return frameRepository.saveAll(iterable);
    }

    @Override
    public Optional<Frame> findById(Integer integer) {
        return frameRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return frameRepository.existsById(integer);
    }

    @Override
    public Iterable<Frame> findAll() {
        return frameRepository.findAll();
    }

    @Override
    public Iterable<Frame> findAllById(Iterable<Integer> iterable) {
        return frameRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return frameRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        frameRepository.deleteById(integer);
    }

    @Override
    public void delete(Frame frame) {
        frameRepository.delete(frame);
    }

    @Override
    public void deleteAll(Iterable<? extends Frame> iterable) {
        frameRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        frameRepository.deleteAll();
    }
}
