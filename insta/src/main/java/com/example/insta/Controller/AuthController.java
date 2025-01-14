package com.example.insta.Controller;

import com.example.insta.DTO.LoginRequestDto;
import com.example.insta.util.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        // 하드코딩된 username과 password로 인증 처리
        String hardcodedUsername = "영일영";
        String hardcodedPassword = "1234";

        // 입력된 username과 password가 하드코딩된 값과 일치하는지 확인
        if (loginRequestDto.getUsername().equals(hardcodedUsername) &&
                loginRequestDto.getPassword().equals(hardcodedPassword)) {
            // 일치하면 JWT 토큰 발급
            String jwtToken = jwtTokenProvider.generateToken(hardcodedUsername);
            return ResponseEntity.ok("Bearer " + jwtToken);
        } else {
            // 일치하지 않으면 401 Unauthorized 반환
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
