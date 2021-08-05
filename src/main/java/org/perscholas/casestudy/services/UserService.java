package org.perscholas.casestudy.services;

import java.util.List;
import org.perscholas.casestudy.models.User;
public interface UserService {
	
	List<User> findAll();
	public User findUserById(int id);
	public User findUserByEmail(String email);
	public void save(User user);
}
