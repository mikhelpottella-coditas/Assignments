package com.assignment.week9assignment.security;

import com.assignment.week9assignment.entity.User;
import com.assignment.week9assignment.service.UserService;
import com.assignment.week9assignment.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if(header!=null && header.startsWith("Bearer ")){
            String token = header.substring(7);
            String username = jwtUtil.getUsername(token);

            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

                User user = userService.loadUserByUsername(username);
                if(jwtUtil.validateToken(user,token)){
                    UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(userToken);
                }
            }
        }

        filterChain.doFilter(request,response);
    }
}
