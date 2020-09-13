package com.fpoly.repositories;

import com.fpoly.models.Frame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameRepository extends CrudRepository<Frame, Integer> {
}
