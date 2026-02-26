package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.error.NotRefreshTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JWTService {
    //Esta es la clave que se va a usar para firmar el token
    private final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    //Fecha de expiración del token
    private final long EXPIRATION_TIME = 1000*60*60;
    //Fecha de expiración del refresh token
    private final long REFRESH_EXPIRATION = 1000 * 60 * 60 * 24 * 7;
    //Este método permite generar un token
    public String generateToken(String username){
        return Jwts.builder().setSubject(username).claim("type","access").setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(KEY).compact();
    }

    //Este método permite generar un refresh token
    public String generateRefreshToken(String username){
        return Jwts.builder().setSubject(username).claim("type","refresh").setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION)).signWith(KEY).compact();
    }
    //Este método permite extraer el nombre de usuario del token
    public String extractUserName(String token){
        return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody().getSubject();

    }


    public boolean isValid(String token){
        try {
            Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token);
            return true;
        }catch (JwtException e){
            return  false;
        }
    }

    public boolean isRefreshtoken(String token){
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody();
            return claims.get("type").equals("refresh");
        }catch (JwtException e){
            return  false;
        }

    }


}
