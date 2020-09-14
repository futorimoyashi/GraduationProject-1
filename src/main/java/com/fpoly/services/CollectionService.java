package com.fpoly.services;

import java.util.List;
import java.util.Optional;

import com.fpoly.models.Collection;

public interface CollectionService {

	void deleteAll();

	void deleteAll(List<Collection> entities);

	void delete(Collection entity);

	void deleteById(Integer id);

	long count();

	List<Collection> findAllById(List<Integer> ids);

	Iterable<Collection> findAll();

	boolean existsById(Integer id);

	Optional<Collection> findById(Integer id);

	List<Collection> saveAll(List<Collection> entities);

	Collection save(Collection entity);

	List<Collection> findByNameLikeOrderByName(String Name);

}
