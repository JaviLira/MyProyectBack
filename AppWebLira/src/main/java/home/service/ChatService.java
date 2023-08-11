package home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.model.Chat;
import home.repository.ChatRepo;

@Service("chat")
public class ChatService {

	@Autowired
	private ChatRepo repoChat;
	
	public Chat buscarChat(Long id) {
		return repoChat.findById(id).orElse(null);
	}
	
	public List<Chat> findAll() {
		return repoChat.findAll();
	}
	
	
}
