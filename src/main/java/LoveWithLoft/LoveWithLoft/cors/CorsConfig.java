package LoveWithLoft.LoveWithLoft.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Dla wszystkich ścieżek
						.allowedOrigins("http://localhost:3000") // Zgoda na żądania z tego źródła
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Dopuszczone metody HTTP
						.allowedHeaders("*") // Wszystkie nagłówki
						.allowCredentials(true); // Zezwolenie na cookies
			}
		};
	}
}
