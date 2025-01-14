package com.example.insta.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String SECRET_KEY = "your-secret-key"; // JWT 서명에 사용될 비밀 키
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 토큰 유효 시간 (1시간)

    // JWT 토큰 생성
    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username) // 사용자 정보를 토큰의 주체(subject)에 포함
                .withIssuedAt(new Date()) // 토큰 생성 시간
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 만료 시간
                .sign(Algorithm.HMAC256(SECRET_KEY)); // HMAC256 알고리즘으로 서명
    }

    // JWT 토큰 검증
    public String validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(SECRET_KEY))
                    .build()
                    .verify(token) // 토큰 서명 및 만료 시간 검증
                    .getSubject(); // 검증 후 사용자 이름 반환
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Invalid JWT Token"); // 검증 실패 시 예외 발생
        }
    }
}
