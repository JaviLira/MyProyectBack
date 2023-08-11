package home.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TokenNoValidoExeption extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2287022446596801185L;

	public TokenNoValidoExeption() {
		super("El token no es valido");
	}

}
