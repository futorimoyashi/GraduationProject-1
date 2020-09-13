package com.fpoly.repositories;

import com.fpoly.models.Collection;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, Integer> {
	List<Collection> findByNameLikeOrderByName(String Name);
}
