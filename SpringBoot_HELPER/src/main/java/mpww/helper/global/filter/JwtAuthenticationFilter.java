package mpww.helper.global.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import mpww.helper.domain.user.model.dao.UserDao;
import mpww.helper.global.util.JwtUtil;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter {

    private final UserDao userDao;
    private final JwtUtil jwtUtil;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            try {

                //토큰이 있는 지 검사
                String token = parseBearerToken(request);
                System.out.println(1);
                if(token == null){
                    filterChain.doFilter(request,response);
                    System.out.println(2);
                    return;
                }

                //유효성 검사
                String userId = String.valueOf(jwtUtil.validate(token));
                System.out.println(3);
                if(userId == null){
                    filterChain.doFilter(request,response);
                    System.out.println(4);
                    return;
                }

                /*
                GrantedAuthority 사용자의 권한을 나타내는 Spring Security

                SecurityContext 현재 인증된 사용자 정보를 저장하는 컨테이너
                userId를 사용자 이름, 패스워드는 null, authorities 리스트를 통한 권한 설정


                접근 주체에 정보를 서블릿에 넘겨줘야하는데, 바로 넘길 수 없음
                context를 하나 만든다. 유저 정보에 대한 security 정보를 context에 만들고
                context에 넣어준다.
                 */
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_USER")); //ROLE_USER, ROLE_ADMIN
                System.out.println(5);

                //empty context 만들기
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                System.out.println(6);
                //토큰 만들고 접근주체에 대한 정보를 넘기고 비밀번호 null, 인증 권한 추가로 넘기기
                AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, null, authorities);
                System.out.println(7);

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.println(8);

                //SecurityContext에 생성한 토큰을 등록
                securityContext.setAuthentication(authenticationToken);
                System.out.println(9);
                //현재 사용자가 인증되었음을 확인 만든 context 등록
                SecurityContextHolder.setContext(securityContext);
                System.out.println(10);


            }catch (Exception e){
                e.printStackTrace();

                System.out.println("error");
            }
    }


    /*
    Http의 request의 헤더로부터 authorization을 가져오고 이를 "Bearer "뒤 토큰으로 가져오는 메서드

     */
    private String parseBearerToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        boolean hasAuthorization = StringUtils.hasText(authorization);
        if (!hasAuthorization)  return  null;

        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        String token = authorization.substring(7);

        System.out.println("parse");
        return token;
    }
}
