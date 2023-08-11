package home.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExisteUsuarioNotFoundExeption extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2651595062157744755L;

	public ExisteUsuarioNotFoundExeption() {
		super("El usuario ya existe");
	}

}
