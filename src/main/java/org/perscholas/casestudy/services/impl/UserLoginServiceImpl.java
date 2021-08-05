package org.perscholas.casestudy.services.impl;

import java.util.List;
import java.util.Optional;

import org.perscholas.casestudy.models.User;
import org.perscholas.casestudy.models.UserLogin;
import org.perscholas.casestudy.repositories.UserLoginRepository;
import org.perscholas.casestudy.services.UserLoginService;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	private UserLoginRepository ulr;
	
	public UserLoginServiceImpl(UserLoginRepository ulr) {
		this.ulr = ulr;
	}
	
	@Override
	public UserLogin findByUserPassword(String password) {
		
		return ulr.findByPassword(password);
	}

	@Override
	public Optional<UserLogin> findByUserNameId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(UserLogin userLogin) {
		ulr.save(userLogin);
	}

	@Override
	public List<UserLogin> findAllUserLogins() {
		// TODO Auto-generated method stub
		return null;
	}

}
