package mpww.helper.domain.user.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialUser {
    private String id;
    private String password;
    private String nickName;
    private String email;


}

