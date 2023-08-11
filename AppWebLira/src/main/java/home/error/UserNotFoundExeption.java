package home.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExeption extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3632661713092902824L;

	public UserNotFoundExeption(String id) {
		super("No se puede encontrar el usuario con email:"+ id);
	}

}
