package com.example.subscription_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;

import java.util.Date;

@Component
public class JwtUtil {

    // Minimum 32+ characters required
    private static final String SECRET_KEY =
            "mySuperSecureJwtSecretKey123456789";

    private static final long EXPIRATION_TIME =
            1000 * 60 * 60 * 24;

    // Generate Secure Key
    private Key getSigningKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }

    // Generate Token
  public String generateToken(
        Long vendorId,
        String email) {

    return Jwts.builder()

            .claim("vendorId", vendorId)

            .claim("email", email)

            .setSubject(email)

            .setIssuedAt(new Date())

            .setExpiration(
                    new Date(
                            System.currentTimeMillis()
                                    + EXPIRATION_TIME
                    )
            )

            .signWith(
                    getSigningKey(),
                    SignatureAlgorithm.HS256
            )

            .compact();
}

    // Extract Email
    public String extractEmail(
            String token) {

        Claims claims = Jwts.parserBuilder()

                .setSigningKey(getSigningKey())

                .build()

                .parseClaimsJws(token)

                .getBody();

        return claims.getSubject();
    }

    // Validate Token
    public boolean validateToken(
            String token,
            String email) {

        return extractEmail(token)
                .equals(email);
    }
}