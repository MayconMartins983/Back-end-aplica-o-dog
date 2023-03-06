package com.example.adotedog.config.security.jwt;

import com.example.adotedog.config.security.UserDetailsImp;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    @Value("${app-datas.auth.jwtSecret}")
    private String jwtSecret;
    @Value("${app-datas.auth.jwtExpiration}")
    private int jwtExpirationMs;

    public String gerarJwt(Authentication authentication) {
        UserDetailsImp userPrincipal = (UserDetailsImp) authentication.getPrincipal();
        final String roles = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(userPrincipal.getUserId().toString())
                .claim("roles",roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
