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

    // Global CORS configuration. Used for development.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (System.getenv("RUN_ENV").equals(GlobalVariables.runEnvironmentDevelopment)) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173");
        }
    }

    // Adding interceptors.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(originValidationInterceptor);
    }
}
