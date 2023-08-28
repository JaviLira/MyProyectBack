package home.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.error.ApiError;
import home.error.ContrasenaNotFoundExeption;
import home.error.ExisteUsuarioNotFoundExeption;
import home.error.TokenNoValidoExeption;
import home.error.UserNotFoundExeption;
import home.model.LoginCredentials;
import home.model.UserBase;
import home.repository.UserRepo;
import home.security.JWTUtil;
import home.service.UserBService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
	

    @Autowired private UserRepo userRepo;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;
	@Autowired private UserBService serviceUsuario;

	  @PostMapping("/user/login")
	  public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
	        try {
	            UsernamePasswordAuthenticationToken authInputToken =
	                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

	            authManager.authenticate(authInputToken);
	 
	            String token = jwtUtil.generateToken(body.getEmail(),body.getRol().toString());

	            return Collections.singletonMap("access_token", token);
	        }catch (AuthenticationException authExc){
	        		throw new ContrasenaNotFoundExeption();
	        }
	    }
	  
	  @PostMapping("/user/register")
	    public Map<String, Object> registerHandler(@RequestBody UserBase user) {
		  if (userRepo.findByEmail(user.getEmail()).orElse(null)==null) {
	            String encodedPass = passwordEncoder.encode(user.getPassword());
	            user.setPassword(encodedPass);
	            user = userRepo.save(user);
	            String token = jwtUtil.generateToken(user.getEmail(),user.getRol().toString());
	            return Collections.singletonMap("access_token", token);
			}else {
				throw new ExisteUsuarioNotFoundExeption();
			}
	    }
	  
	    @GetMapping("/user/email/{email}")
	    public ResponseEntity<UserBase> comprobarEmail(@PathVariable String email) {
	    	UserBase respuesta = serviceUsuario.buscarUsuario(email);
	    	
	    	if (respuesta!=null) {
				return ResponseEntity.ok(respuesta);
			}else {
				throw new UserNotFoundExeption(email);
			}
	    	
	    }
	    
	    @GetMapping("/user/email")
	    public UserBase comprobarEmail(
	    		@RequestParam(required = false) String email,
				@RequestParam(required = false) String username) {
	    			
			if (username == null) {
				return serviceUsuario.buscarUsuario(email);
			} else {
				return serviceUsuario.buscarUsuarioByName(username);
			}
	    	
	    }
	    
	    @GetMapping("/user/validarToken")
	    public ResponseEntity<UserBase> validarToken() {
	    	try {
	    		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	            
	    		return ResponseEntity.ok(serviceUsuario.buscarUsuario(email));
	    	}catch (Exception e) {
				throw new TokenNoValidoExeption();
			}
	    }
	    @GetMapping("/user")
	    public ResponseEntity <UserBase> getUsuario() {
	    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        
			return ResponseEntity.ok(serviceUsuario.buscarUsuario(email));
	    }
	    
	    @GetMapping("/validarRolAdministrador")
	    public ResponseEntity<UserBase> validarRolAdministrador() {
	    	try {
	    		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    		UserBase result=serviceUsuario.comprobarRolAdministrador(email);
	  		return ResponseEntity.ok(result);
	  		
	    	}catch (Exception e) {
	  			throw new TokenNoValidoExeption();
	  		}
	    }
	  
	  @ExceptionHandler(ExisteUsuarioNotFoundExeption.class)
	    public ResponseEntity<ApiError> registrarError(ExisteUsuarioNotFoundExeption ex) throws Exception {
	    	ApiError e = new ApiError();
	    	e.setEstado(HttpStatus.BAD_REQUEST);
	    	e.setMensaje(ex.getMessage());
	    	e.setFecha(LocalDateTime.now());
	    	
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		} 
	  
	    @ExceptionHandler(ContrasenaNotFoundExeption.class)
	    public ResponseEntity<ApiError> contrasenaError(ContrasenaNotFoundExeption ex) throws Exception {
	    	ApiError e = new ApiError();
	    	e.setEstado(HttpStatus.BAD_REQUEST);
	    	e.setMensaje(ex.getMessage());
	    	e.setFecha(LocalDateTime.now());
	    	
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		} 
	    
	    @ExceptionHandler(UserNotFoundExeption.class)
	    public ResponseEntity<ApiError> usuarioNoEncontrado(UserNotFoundExeption ex) throws Exception {
	    	ApiError e = new ApiError();
	    	e.setEstado(HttpStatus.NOT_FOUND);
	    	e.setMensaje(ex.getMessage());
	    	e.setFecha(LocalDateTime.now());
	    	
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		} 
	    
	    @ExceptionHandler(TokenNoValidoExeption.class)
	    public ResponseEntity<ApiError> tokenNoValido(TokenNoValidoExeption ex) throws Exception {
	    	ApiError e = new ApiError();
	    	e.setEstado(HttpStatus.BAD_REQUEST);
	    	e.setMensaje(ex.getMessage());
	    	e.setFecha(LocalDateTime.now());
	    	
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		} 
	
	
}
