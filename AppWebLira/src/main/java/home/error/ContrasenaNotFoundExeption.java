package home.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContrasenaNotFoundExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -139494722658487016L;

	public ContrasenaNotFoundExeption() {
		super("La contraseña no es valida");
	}

}
