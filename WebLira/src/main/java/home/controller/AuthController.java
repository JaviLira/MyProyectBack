package home.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import home.error.ApiError;
import home.error.EstandarExeption;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthController {
	
	  @GetMapping("/hola")
	    public ResponseEntity<String> validarToken() {
	    	try {
	    		
	    		return ResponseEntity.ok("holiwi");
	    	}catch (Exception e) {
				throw new EstandarExeption();
			}
	    }
	  
	  
	  @ExceptionHandler(EstandarExeption.class)
	    public ResponseEntity<ApiError> RolAdministradorExeption(EstandarExeption ex) throws Exception {
	    	ApiError e = new ApiError();
	    	e.setEstado(HttpStatus.BAD_REQUEST);
	    	e.setMensaje(ex.getMessage());
	    	e.setFecha(LocalDateTime.now());
	    	
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		} 

}
