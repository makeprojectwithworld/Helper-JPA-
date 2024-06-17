package mpww.helper.domain.user.model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import mpww.helper.domain.user.model.dao.UserDao;
import mpww.helper.domain.user.model.dto.CustomOauth2User;
import mpww.helper.domain.user.model.dto.SocialUser;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImpl extends DefaultOAuth2UserService {

    private final UserDao userDao;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(request);

        String oauthClientName = request.getClientRegistration().getClientName();
        try{
            System.out.println(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
        }catch (Exception e){
            e.printStackTrace();
        }

        String userId = null;
        String email = "ssafy@ssafy.com";
        String password = "ssafy";
        String nickname =null;
        SocialUser user = null;

        if(oauthClientName.equals("kakao")){
            userId = "kakao_" + oAuth2User.getAttributes().get("id");
            Map<?, ?> responseMap = (Map<?, ?>) oAuth2User.getAttributes().get("properties");
            nickname = (String) responseMap.get("nickname");
            user = new SocialUser(userId,password,nickname,email);
        }
        if(oauthClientName.equals("naver")){
            userId = "naver_" + oAuth2User.getAttributes().get("resultcode");
            Map<?, ?> responseMap = (Map<?, ?>) oAuth2User.getAttributes().get("response");
            nickname = "naver_" + responseMap.get("name");
            email = (String) responseMap.get("email");
            user = new SocialUser(userId,password,nickname,email);
        }

        userDao.snsLogin(user);

        return new CustomOauth2User(userId);
    }

}
