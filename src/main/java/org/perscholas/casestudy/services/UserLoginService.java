package org.perscholas.casestudy.services;

import java.util.List;
import java.util.Optional;

import org.perscholas.casestudy.models.UserLogin;

public interface UserLoginService {
	public UserLogin findByUserPassword(String password);
	public Optional<UserLogin> findByUserNameId(int id);
	public List<UserLogin> findAllUserLogins();
	public void save(UserLogin userLogin);
}
