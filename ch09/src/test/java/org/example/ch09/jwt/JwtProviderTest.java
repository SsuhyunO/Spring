package org.example.ch09.jwt;

import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.entity.User;
import org.example.ch09.security.MyUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class JwtProviderTest {
    @Autowired
    private JwtProvider provider;

    @Test
    void createToken() {
        User user = User.builder()
                .userid("a101")
                .name("김유신")
                .birth("1999-02-11")
                .age(23)
                .role("ADMIN")
                .build();
        String access = provider.createToken(user, -1);
        // String refresh = provider.createToken(user, 5);
        log.info(access);
        // log.info(refresh);
        /*
            eyJhbGciOiJIUzI1NiJ9.
            eyJpc3MiOiJzdWh5dW45MTM2QGdtYWlsLmNvbSIsImlhdCI6MTc4MjM2OTY3OSwiZXhwIjoxNzgyNDU2MDc5LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.
            U_kv1YfaaR2lXVx-YI71J8FMCoMVLZ7Hdkl7LVecmPM
         */
    }

    @Test
    void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzdWh5dW45MTM2QGdtYWlsLmNvbSIsImlhdCI6MTc4MjM2OTY3OSwiZXhwIjoxNzgyNDU2MDc5LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.U_kv1YfaaR2lXVx-YI71J8FMCoMVLZ7Hdkl7LVecmPM";
        Claims claims = provider.getClaims(token);

        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        log.info("username : " + username);
        log.info("role : " + role);
    }

    @Test
    void getAuthentication() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzdWh5dW45MTM2QGdtYWlsLmNvbSIsImlhdCI6MTc4MjM2OTY3OSwiZXhwIjoxNzgyNDU2MDc5LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.U_kv1YfaaR2lXVx-YI71J8FMCoMVLZ7Hdkl7LVecmPM";

        Authentication authentication = provider.getAuthentication(token);

        User user = (User) authentication.getPrincipal();

        log.info(user);
    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzdWh5dW45MTM2QGdtYWlsLmNvbSIsImlhdCI6MTc4MjM2OTY3OSwiZXhwIjoxNzgyNDU2MDc5LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.U_kv1YfaaR2lXVx-YI71J8FMCoMVLZ7Hdkl7LVecmPM";

        provider.validateToken(token);
    }

    @Test
    void getIssuer() {
    }

    @Test
    void getSecret() {
    }
}