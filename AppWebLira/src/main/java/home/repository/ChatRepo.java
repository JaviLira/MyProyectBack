package home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.model.Chat;

public interface ChatRepo extends JpaRepository<Chat, Long>{

	
}
