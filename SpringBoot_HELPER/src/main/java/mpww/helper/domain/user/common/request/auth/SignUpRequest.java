package mpww.helper.domain.user.common.request.auth;


import lombok.Getter;
import lombok.Setter;
import mpww.helper.domain.user.model.dto.CertificationInfo;
import mpww.helper.domain.user.model.dto.User;

@Getter
@Setter
public class SignUpRequest {
    private User user;
    private CertificationInfo certificationInfo;

}
