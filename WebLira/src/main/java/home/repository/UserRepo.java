package home.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import home.model.UserBase;

public interface UserRepo extends JpaRepository<UserBase, String>{

	public Optional<UserBase> findByEmail(String email);
	@Query(value="select email from usuario where email = ?1", nativeQuery = true) 
	public Object getEmail(String email);
	
	@Query(value="select * from usuario where name = ?1", nativeQuery = true) 
	public UserBase findByName(String name);
	
}
