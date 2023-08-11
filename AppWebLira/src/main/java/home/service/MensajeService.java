package home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.model.Mensajes;
import home.repository.MensajeRepo;

@Service("Mensaje")
public class MensajeService {

	@Autowired
	private MensajeRepo repoMensaje;
	
	public Mensajes buscarMensaje(Long id) {
		return repoMensaje.findById(id).orElse(null);
	}
	
	public List<Mensajes> findAll() {
		return repoMensaje.findAll();
	}
	
	
	
}
