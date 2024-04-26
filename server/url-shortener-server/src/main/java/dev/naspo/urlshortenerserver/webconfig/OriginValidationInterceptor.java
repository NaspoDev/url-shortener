package dev.naspo.urlshortenerserver.webconfig;

import dev.naspo.urlshortenerserver.utils.GlobalVariables;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class OriginValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // If in production, validate that the origin request header is the authorized client origin.
        if (System.getenv("RUN_ENV").equals(GlobalVariables.runEnvironmentDevelopment)) {
            if (request.getHeader("Origin") != null &&
                    request.getHeader("Origin").equals(GlobalVariables.clientOrigin)) {
                return true;
            } else {
                response.getWriter().write("Request is not authorized.");
                return false;
            }
        }
        // Otherwise we are in development, allow the request.
        return true;
    }
}
