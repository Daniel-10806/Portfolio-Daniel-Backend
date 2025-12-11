package portfolio_daniel_backend.interfaces.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Portfolio API - Daniel Chávarri")
                        .description(
                                "API para manejar proyectos, experiencia, educación, habilidades y mensajes de contacto.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Daniel Chávarri")
                                .email("daniel.portfolio@example.com")));
    }
}