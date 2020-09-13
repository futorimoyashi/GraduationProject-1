package com.fpoly.services;

import com.fpoly.models.Collection;
import com.fpoly.repositories.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionServiceImpl implements CollectionService{

    private CollectionRepository collectionRepository;

    public CollectionServiceImpl(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Override
    public Collection save(Collection entity) {
        return collectionRepository.save(entity);
    }

    @Override
    public List<Collection> saveAll(List<Collection> iterable) {
        return (List<Collection>) collectionRepository.saveAll(iterable);
    }

    @Override
    public Optional<Collection> findById(Integer integer) {
        return collectionRepository.findById(integer);
    }
    
    @Override
	public List<Collection> findByNameLikeOrderByName(String Name) {
    	return (List<Collection>) collectionRepository.findByNameLikeOrderByName("%" + Name + "%");
    }

    @Override
    public boolean existsById(Integer integer) {
        return collectionRepository.existsById(integer);
    }

    @Override
    public List<Collection> findAll() {
        return (List<Collection>) collectionRepository.findAll();
    }

    @Override
    public List<Collection> findAllById(List<Integer> iterable) {
        return (List<Collection>) collectionRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return collectionRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        collectionRepository.deleteById(integer);
    }

    @Override
    public void delete(Collection collection) {
        collectionRepository.delete(collection);
    }

    @Override
    public void deleteAll(Iterable<? extends Collection> iterable) {
        collectionRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        collectionRepository.deleteAll();
    }
}
