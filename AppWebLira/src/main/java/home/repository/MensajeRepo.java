package home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import home.model.Mensajes;

public interface MensajeRepo extends JpaRepository<Mensajes, Long>{


	
}
