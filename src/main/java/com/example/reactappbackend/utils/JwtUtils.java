package com.example.reactappbackend.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static String secretKey = "sample.secret.key";
    private static Long tokenExpiresInMillis = 30 * 60 * 1000L;

    public static String createToken(String email, String name) {
        // 암호화 설정
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        String encodingSecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());

        // 현재 시간, 만료 시간 설정
        Date expireTime = new Date();
        long nowTime = expireTime.getTime();
        expireTime.setTime(expireTime.getTime() + tokenExpiresInMillis);

        // header 설정
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        // claim 설정
        Claims claims = Jwts.claims();
        claims.put("email", email);
        claims.put("name", name);
        claims.put("issuedAt", nowTime);
        claims.put("expiration", expireTime.getTime());

        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .setExpiration(expireTime)
                .signWith(signatureAlgorithm, encodingSecretKey);

        return jwtBuilder.compact();
    }

    public static String refreshAccessToken(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(jwt).getBody();
        JsonObject obj = new Gson().fromJson(claims.toString(), JsonObject.class);

        String email = obj.get("email").getAsString();
        String name = obj.get("name").getAsString();

        return createToken(email, name);
    }

    public static TokenStatus statusToken(String jwt) {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                    .parseClaimsJws(jwt).getBody();
            return TokenStatus.VALID;
        } catch (ExpiredJwtException e) {
            return TokenStatus.EXPIRED;
        } catch (Exception e) {
            e.printStackTrace();
            return TokenStatus.NONE;
        }
    }

}
