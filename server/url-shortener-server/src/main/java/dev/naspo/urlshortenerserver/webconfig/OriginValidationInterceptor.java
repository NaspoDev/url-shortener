package dev.naspo.urlshortenerserver.webconfig;

import dev.naspo.urlshortenerserver.utils.GlobalVariables;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class OriginValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // If in production, validate that the origin request header is the authorized client origin.
        if (System.getenv("RUN_ENV").equals(GlobalVariables.runEnvironmentProduction)) {
            if (request.getHeader("Origin").equals(GlobalVariables.clientOrigin)) {
                return true;
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        } else {
            return true;
        }
    }
}
