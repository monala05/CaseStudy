package org.perscholas.casestudy.repositories;

import java.util.List;
import java.util.Optional;

import org.perscholas.casestudy.models.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer>{
	
	UserLogin findByPassword(String password);
	Optional<UserLogin> findByUserName(int id);
	List<UserLogin> findAll();
}
