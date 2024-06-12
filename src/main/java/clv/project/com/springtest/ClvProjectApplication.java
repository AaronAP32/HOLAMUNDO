package clv.project.com.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClvProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClvProjectApplication.class, args);
    }

    @Configuration
    @EnableWebMvc // Habilitar Web MVC, si no se ha habilitado en la configuración principal
    public static class MyConfiguration implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*") // Permitir solicitudes desde este origen
                    .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
                    .allowedHeaders("*"); // Permitir todos los encabezados
        }
    }
}
