package org.steamclone.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.steamclone.security.services.JwtService;
import org.steamclone.security.services.UserDetailsServiceImpl;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain
            chain) throws ServletException, IOException {

        String token = getToken(req);
        try {
            if(token!=null) {
                String username = jwtService.extractUsername(token);
                if (username != null) {
                    UserDetails personDetails =
                            userDetailsServiceImpl.loadUserByUsername(username);

                    if (jwtService.isTokenValid(token, personDetails)) {
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(
                                        personDetails.getUsername(),
                                        null,
                                        personDetails.getAuthorities());

                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        chain.doFilter(req, res);
    }
    private String getToken(HttpServletRequest req) {
        String header = req.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer "))
            return header.replace("Bearer ", "");
        return null;
    }
}