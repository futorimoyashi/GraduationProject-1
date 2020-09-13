package com.fpoly.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fpoly.models.UserApplication;
import com.fpoly.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApplication userApplication = userRepository.findByUsername(username);
		if(userApplication == null){
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(userApplication.getUsername(), userApplication.getPassword(), Collections.emptyList());
	}

	@Override
	public UserApplication save(UserApplication entity) {
		return userRepository.save(entity);
	}

	@Override
	public List<UserApplication> saveAll(List<UserApplication> entities) {
		return (List<UserApplication>) userRepository.saveAll(entities);
	}

	@Override
	public Optional<UserApplication> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public List<UserApplication> findByUsernameLikeOrderByUsername(String username) {
		return userRepository.findByUsernameLikeOrderByUsername("%"+username+"%");
	}

	@Override
	public boolean existsById(String id) {
		return userRepository.existsById(id);
	}

	@Override
	public List<UserApplication> findAll() {
		return (List<UserApplication>) userRepository.findAll();
	}

	@Override
	public List<UserApplication> findAllById(List<String> ids) {
		return (List<UserApplication>) userRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(UserApplication entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<UserApplication> entities) {
		userRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
}
