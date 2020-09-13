package com.fpoly.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.models.UserApplication;

@Repository
public interface UserRepository extends CrudRepository<UserApplication, String>{
	List<UserApplication> findByUsernameLikeOrderByUsername (String username);
	UserApplication findByUsername(String username);
}
