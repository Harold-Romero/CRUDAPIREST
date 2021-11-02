package com.haromerop.crudApi.ApiRestCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.haromerop.crudApi.ApiRestCrud.dto.UserLoginRequest;
import com.haromerop.crudApi.ApiRestCrud.model.UserLogin;
import com.haromerop.crudApi.ApiRestCrud.repository.GestorUser;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private GestorUser repository;
	
	@Override
	public UserLogin createUserLogin(UserLoginRequest userLoginRequest) throws Exception {
		
		UserLogin userLoginDb = this.repository.findByUser(userLoginRequest.getUser());
		
		if (userLoginDb != null) {
			throw new Exception();
		}
		
		UserLogin userLogin = new UserLogin();
		userLogin.setUser(userLoginRequest.getUser());
		userLogin.setPass(bCryptPasswordEncoder.encode(userLoginRequest.getPass()));
		userLogin.setRol(userLoginRequest.getRol());
		userLogin.setSession(true);	
		return repository.save(userLogin);
	}
}