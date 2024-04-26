package dev.naspo.urlshortenerserver.webconfig;

import dev.naspo.urlshortenerserver.utils.GlobalVariables;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Global CORS configuration. Used for development.
@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (System.getenv("RUN_ENV").equals(GlobalVariables.runEnvironmentDevelopment)) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173");
        }
    }
}
