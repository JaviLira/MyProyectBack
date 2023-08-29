package home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.model.Roles;
import home.model.UserBase;
import home.repository.UserRepo;

@Service("UserB")
public class UserBService {

	@Autowired
	private UserRepo repoUser;
	
	public UserBase buscarUsuario(String id) {
		return repoUser.findById(id).orElse(null);
	}
	
	public UserBase buscarUsuarioByName(String name) {
		return repoUser.findByName(name);
	}
	
	public List<UserBase> findAll() {
		return repoUser.findAll();
	}
	
	public UserBase comprobarRolAdministrador(String email) {
		UserBase result = repoUser.findByEmail(email).orElse(null);
		if (Roles.ROLE_ADMIN.equals(result.getRol())) {
			return result;
		} else {
			return null;
		}
	}
	
}
