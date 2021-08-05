package org.perscholas.casestudy.repositories;

import java.util.List;
import java.util.Optional;

import org.perscholas.casestudy.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);
	Optional<User> findById(int id);
	List<User> findAll();
	
}
