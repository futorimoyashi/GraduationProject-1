package com.fpoly.services;

import java.util.List;
import java.util.Optional;

import com.fpoly.models.UserApplication;

public interface UserService {

	void deleteAll();

	void deleteAll(List<UserApplication> entities);

	void delete(UserApplication entity);

	void deleteById(String id);

	long count();

	List<UserApplication> findAllById(List<String> ids);

	List<UserApplication> findAll();

	boolean existsById(String id);

	Optional<UserApplication> findById(String id);

	List<UserApplication> saveAll(List<UserApplication> entities);

	UserApplication save(UserApplication entity);

	List<UserApplication> findByUsernameLikeOrderByUsername(String username);

}
