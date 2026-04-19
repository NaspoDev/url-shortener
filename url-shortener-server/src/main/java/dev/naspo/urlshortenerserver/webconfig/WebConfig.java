package dev.naspo.urlshortenerserver.webconfig;

import dev.naspo.urlshortenerserver.utils.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Web MVC Configuration
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private OriginValidationInterceptor originValidationInterceptor;

    // CORS Configuration.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String runEnvironment = System.getenv("RUN_ENV");

        // CORS config for development.
        if (runEnvironment != null && runEnvironment.equals(GlobalVariables.runEnvironmentDevelopment)) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173");
         return;
        }

        // CORS configuration for production.
        if (runEnvironment != null && runEnvironment.equals(GlobalVariables.runEnvironmentProduction)) {
            registry.addMapping("/**")
                    .allowedOrigins(GlobalVariables.clientOrigin)
                    .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
        }
    }

    // Adding interceptors.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(originValidationInterceptor);
    }
}
