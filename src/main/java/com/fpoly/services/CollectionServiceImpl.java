package com.fpoly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.models.Collection;
import com.fpoly.repositories.CollectionRepository;

@Service
public class CollectionServiceImpl implements CollectionService{
	@Autowired
	private CollectionRepository collectionRepository;

	@Override
	public List<Collection> findByNameLikeOrderByName(String Name) {
		return collectionRepository.findByNameLikeOrderByName("%" + Name + "%");
	}

	@Override
	public Collection save(Collection entity) {
		return collectionRepository.save(entity);
	}

	@Override
	public List<Collection> saveAll(List<Collection> entities) {
		return (List<Collection>) collectionRepository.saveAll(entities);
	}

	@Override
	public Optional<Collection> findById(Integer id) {
		return collectionRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return collectionRepository.existsById(id);
	}

	@Override
	public Iterable<Collection> findAll() {
		return collectionRepository.findAll();
	}

	@Override
	public List<Collection> findAllById(List<Integer> ids) {
		return (List<Collection>) collectionRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return collectionRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		collectionRepository.deleteById(id);
	}

	@Override
	public void delete(Collection entity) {
		collectionRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Collection> entities) {
		collectionRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		collectionRepository.deleteAll();
	}
	
}
