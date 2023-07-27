package org.steamclone.security;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.steamclone.security.config.JwtAuthenticationEntryPoint;
import org.steamclone.security.config.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtEntryPoint;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();

        http.authorizeHttpRequests().requestMatchers("/api/auth/**").permitAll();

        http.authorizeHttpRequests().requestMatchers("/api/moderador/**").hasAuthority("MODERADOR");

        http.authorizeHttpRequests().requestMatchers(
                "/api/productos/obtener/**",
                "/api/productos/obtener_productos",
                "/api/productos/obtener_productos_categoria/**",
                "/api/productos/obtener_productos_precio/**",
                "/api/productos/obtener_productos_titulo/**",
                "/api/categorias/obtener",
                "/api/categorias/obtener/**",
                "/api/personas/restaurar_contraseña/**",
                "/api/personas/recuperar_contraseña"
        ).permitAll().anyRequest().authenticated();

        //http.authorizeHttpRequests().anyRequest().permitAll();

        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}