package home.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstandarExeption extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 738212286437830540L;

	public EstandarExeption() {
		super("Tremenda excepcion");
	}

}
