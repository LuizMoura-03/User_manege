package br.com.zup.user_manager.user_manager.infra.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class JwtUtil {
    private final String SECRET_KEY = "palavra_oculta_xablau";

    private String creatToken(Map<String, Object> clains, String subject) {
        String token = Jwts.builder()
                .setClaims(clains)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 60 * 100))
                .signWith(SignatureAlgorithm.ES256, SECRET_KEY )
                .compact();
        return token;
    }

    public Claims extractAllClains(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJwt(token).getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClains((token));
        return claimsResolver.apply(claims);
    }

}
