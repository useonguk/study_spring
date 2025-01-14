package com.example.insta.Filter;

import com.example.insta.util.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // /api/login 경로에서는 토큰 검증을 하지 않음
        if (request.getRequestURI().equals("/api/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // HTTP 헤더에서 Authorization 값 추출
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) { // Bearer 토큰 형식 확인
            token = token.substring(7); // "Bearer " 부분 제거
            try {
                // JWT 토큰 검증 및 사용자 이름 확인
                String username = jwtTokenProvider.validateToken(token);

                // SecurityContext에 사용자 정보를 저장 (필요시 추가 구현 가능)
                // SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (RuntimeException e) {
                // 토큰 검증 실패 시 401 응답
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // 다음 필터로 요청 전달
        filterChain.doFilter(request, response);
    }
}
