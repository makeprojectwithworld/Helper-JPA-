package mpww.helper.global.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mpww.helper.global.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class JwtInterceptor implements HandlerInterceptor {
    private final String HEADER_AUTH = "access-token";

    private final JwtUtil jwtUtil;

    public JwtInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getMethod().equals("OPTIONS")){
            return true;
        }

        String token = request.getHeader(HEADER_AUTH);
        if(token != null ){
            jwtUtil.validate(token);
            return true;
        }

        throw new Exception("유호하지 않은 접근");
    }
}
