package com.assignment.week9assignment.utils;

import com.assignment.week9assignment.entity.User;
import com.assignment.week9assignment.enums.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "qwertyuiopasdfghjklasdfghjwertyu345678werty";
    private final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        Role role = user.getRole();
        return Jwts.builder()
                .claims()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .and()
                .claim("role", role.name())
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }


    //extract claims
    public Claims extractClaims(String token){
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



    public String getUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // validate the token
    public boolean validateToken(User user, String token) {

        boolean isValidUser = extractClaims(token).getSubject().equals(user.getUsername());
        boolean isExpired = extractClaims(token).getExpiration().before(new Date());

        return (isValidUser && !isExpired);
    }



}
