package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.error.NotRefreshTokenException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.util.List;

public class JWTFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final HandlerExceptionResolver resolver;

    public JWTFilter(JWTService jwtService, HandlerExceptionResolver resolver) {
        this.jwtService = jwtService;
        this.resolver = resolver;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Leemos la cabecera authorization de la petición
        String header = request.getHeader("Authorization");
        //Verificamos que la cabecera exista y que tenga el formato correcto
        if (header != null && header.startsWith("Bearer ")) {
            //obtenemos el token
            String token = header.substring(7);
            //validamos el token
            if (jwtService.isValid(token) && !jwtService.isRefreshtoken(token)) {
                //Obtenemos el nombre de usuario del token
                String username = jwtService.extractUserName(token);
                //Avisamos a Spring que este usuario está autenticado creando un objeto
                //authentication y almacenándolo en el contexto de seguridad de spring
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, List.of());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                //Si la validación falla delegamos la respuesta al controller advice
                resolver.resolveException(request, response, null, new NotRefreshTokenException("Token no válido"));
                return;

            }
        }

        //Continuamos el flujo de filtros para que la petición llegué al controlador
        filterChain.doFilter(request, response);
    }
}
