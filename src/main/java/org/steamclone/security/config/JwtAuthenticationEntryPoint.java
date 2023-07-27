package org.steamclone.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.steamclone.dtos.MessageDTO;

import java.io.IOException;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
        MessageDTO<String> messageDTO = new MessageDTO<>(HttpStatus.UNAUTHORIZED, true, "Token no encontrado o inválido");
        response.setContentType("application/json");
        response.setStatus(messageDTO.getStatus().value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(messageDTO));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
