package home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	@Bean
	public WebMvcConfigurer corsConfigurer() {return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String url="http://localhost:4200";
				//login
				registry.addMapping("/hola").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");

			}
		};
	}
}
