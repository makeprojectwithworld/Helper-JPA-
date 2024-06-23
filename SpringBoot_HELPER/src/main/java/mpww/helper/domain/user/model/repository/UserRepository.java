package mpww.helper.domain.user.model.repository;

import mpww.helper.domain.user.model.dto.CertificationInfo;
import mpww.helper.domain.user.model.dto.User;
import mpww.helper.domain.user.model.dto.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    int signUp(User user);

    User login(User user);

    boolean existsByUserId(String userId);

    void saveCertificationInfo(CertificationInfo info);

    boolean existsByEmail(String email);

    boolean emailVerificationCodeIsTrue(CertificationInfo info);

    void snsLogin(SocialUser socialUser);
}
