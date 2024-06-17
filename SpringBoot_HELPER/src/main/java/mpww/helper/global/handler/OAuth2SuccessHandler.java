package mpww.helper.global.handler;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import mpww.helper.domain.user.model.dto.CustomOauth2User;
import mpww.helper.global.util.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;

    //성공한 결과를 여기서 반환
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomOauth2User oAuth2User = (CustomOauth2User) authentication.getPrincipal();

        String userId = oAuth2User.getName();
        String token = jwtUtil.createToken(userId,userId,userId);
        //소셜로그인 gymname userNickname 추가하기
        response.sendRedirect("http://local:8080/auth/oauth-response/" + token + "/3600");

    }
}
