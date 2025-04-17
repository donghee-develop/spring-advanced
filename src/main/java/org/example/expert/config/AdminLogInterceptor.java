package org.example.expert.config;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminLogInterceptor implements HandlerInterceptor {
    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String bearerJwt = request.getHeader("Authorization");
        String token = jwtUtil.substringToken(bearerJwt);
        String role = jwtUtil.extractUserRole(token);

        if (token ==  null){
            log.info("로그인 안됨");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        if (!"ADMIN".equals(role)) {
            log.info("관리자 아님: role={}", role);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }

        Date currentDate = new Date();
        currentDate.setTime(System.currentTimeMillis());
        String uri = request.getRequestURI();
        log.info("현재 시간 : " + currentDate);
        log.info("URI : " + uri);

        return true;
    }
}
