package home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.model.UserBase;
import home.repository.UserRepo;

@Service("UserB")
public class UserBService {

	@Autowired
	private UserRepo repoUser;
	
	public UserBase buscarUsuario(String id) {
		return repoUser.findById(id).orElse(null);
	}
	
	public List<UserBase> findAll() {
		return repoUser.findAll();
	}
	
}
