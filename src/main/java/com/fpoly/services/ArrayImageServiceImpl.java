package com.fpoly.services;

import com.fpoly.models.ArrayImage;
import com.fpoly.repositories.ArrayImageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArrayImageServiceImpl implements ArrayImageService{

    private ArrayImageRepository arrayImageRepository;

    public ArrayImageServiceImpl(ArrayImageRepository arrayImageRepository) {
        this.arrayImageRepository = arrayImageRepository;
    }

    @Override
    public ArrayImage save(ArrayImage s) {
        return arrayImageRepository.save(s);
    }

    @Override
    public Iterable<ArrayImage> saveAll(Iterable<ArrayImage> iterable) {
        return arrayImageRepository.saveAll(iterable);
    }

    @Override
    public Optional<ArrayImage> findById(Integer integer) {
        return arrayImageRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return arrayImageRepository.existsById(integer);
    }

    @Override
    public Iterable<ArrayImage> findAll() {
        return arrayImageRepository.findAll();
    }

    @Override
    public Iterable<ArrayImage> findAllById(Iterable<Integer> iterable) {
        return arrayImageRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return arrayImageRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        arrayImageRepository.deleteById(integer);
    }

    @Override
    public void delete(ArrayImage arrayImage) {
        arrayImageRepository.delete(arrayImage);
    }

    @Override
    public void deleteAll(Iterable<? extends ArrayImage> iterable) {
        arrayImageRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        arrayImageRepository.deleteAll();
    }
}
