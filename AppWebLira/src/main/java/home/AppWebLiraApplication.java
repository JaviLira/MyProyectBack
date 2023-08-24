package home;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import home.model.Roles;
import home.model.UserBase;
import home.repository.UserRepo;

@SpringBootApplication
public class AppWebLiraApplication extends SpringBootServletInitializer{
	
	@Autowired
	private PasswordEncoder codificador;

	public static void main(String[] args) {
		SpringApplication.run(AppWebLiraApplication.class, args);
	}
	
	@Bean
	CommandLineRunner iniUsuarios(UserRepo repoUsuario) {
		return (arg)-> {
			if (repoUsuario.findAll().size()==0) {
				repoUsuario.save(new UserBase("javi", "javi@gmail.com", "222444777", codificador.encode("javi")));
				UserBase usuario = repoUsuario.findByEmail("javi@gmail.com").orElse(null);
					usuario.setRol(Roles.ROLE_ADMIN);
					
					repoUsuario.saveAll(Arrays.asList(new UserBase("antonio", "antonio@gmail.com", "652553232", codificador.encode("antonio")),
							new UserBase("juan", "juan@gmail.com", "666444777", codificador.encode("juan")),
							new UserBase("pepe", "pepe@gmail.com", "222444777", codificador.encode("pepe")),
							new UserBase("antonio", "antonio@gmail.com", "222444777", codificador.encode("antonio")),
							new UserBase("angustin", "angustin@gmail.com", "222444777", codificador.encode("angustin")),
							new UserBase("alba", "alba@gmail.com", "222444777", codificador.encode("alba")),
							new UserBase("isa", "isa@gmail.com", "222444777", codificador.encode("isa")),
							new UserBase("marrueco", "marrueco@gmail.com", "222444777", codificador.encode("marrueco")),
							new UserBase("morito", "morito@gmail.com", "222444777", codificador.encode("morito")),
							new UserBase("negrito", "negrito@gmail.com", "222444777", codificador.encode("javi")),
							new UserBase("cosas", "cosas@gmail.com", "222444777", codificador.encode("cosas")),
							new UserBase("cositas", "cositas@gmail.com", "222444777", codificador.encode("cositas"))));
					repoUsuario.save(usuario);
			}

		};
	}
	

}