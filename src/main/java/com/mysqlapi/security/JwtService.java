package com.mysqlapi.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Date;


import static java.time.ZoneOffset.UTC;

@Component
public class JwtService {

    private static final String ISSUER = "com.mysqlapi";

    @Autowired
    private SecretKeyProvider secretKeyProvider;

    public String generateToken(String username) throws IOException, URISyntaxException {
        byte[] secretKey = secretKeyProvider.getKey();
        Date expiration = Date.from(LocalDateTime.now(UTC).plusMonths(1).toInstant(UTC));
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .setIssuedAt(Date.from(LocalDateTime.now(UTC).toInstant(UTC)))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String verifyToken(String token) throws IOException, URISyntaxException {
        byte[] secretKey = secretKeyProvider.getKey();
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return claims.getBody().getSubject();
    }

}
