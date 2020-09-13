package com.fpoly.repositories;

import com.fpoly.models.ArrayImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrayImageRepository extends CrudRepository<ArrayImage, Integer> {
}
