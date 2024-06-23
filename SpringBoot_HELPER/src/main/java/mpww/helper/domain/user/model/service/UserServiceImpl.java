package mpww.helper.domain.user.model.service;

import lombok.AllArgsConstructor;
import mpww.helper.domain.user.common.CertificationNumber;
import mpww.helper.domain.user.common.request.auth.CheckCertificationRequestDto;
import mpww.helper.domain.user.common.request.auth.EmailCertificationRequestDto;
import mpww.helper.domain.user.common.request.auth.IdCheckRequestDto;
import mpww.helper.domain.user.common.request.auth.SignUpRequest;
import mpww.helper.domain.user.common.response.ResponseDto;
import mpww.helper.domain.user.common.response.auth.CheckCertificationResponseDto;
import mpww.helper.domain.user.common.response.auth.EmailCertificationResponseDto;
import mpww.helper.domain.user.common.response.auth.IdCheckResponseDto;
import mpww.helper.domain.user.model.repository.UserRepository;
import mpww.helper.domain.user.model.dto.CertificationInfo;
import mpww.helper.domain.user.model.dto.User;
import mpww.helper.global.provider.EmailProvider;
import mpww.helper.global.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final EmailProvider emailProvider;



    @Transactional
    @Override
    public int signUp(SignUpRequest signUpRequest) {
        CertificationInfo certificationInfo = signUpRequest.getCertificationInfo();


        boolean isVerified = userRepository.emailVerificationCodeIsTrue(certificationInfo);

        if(!isVerified) return 0;


        return userRepository.signUp(signUpRequest.getUser());
    }

    @Override
    public User login(User user) {
        User loginUser = userRepository.login(user);
        if(loginUser != null) {
            loginUser.setAccessToken(jwtUtil.createToken(loginUser.getId(),loginUser.getNickName(),loginUser.getGymName() ));

        }
        return loginUser;
    }

    @Override
    public ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto) {


        try{
            String userId = dto.getId();
            boolean isExisted = userRepository.existsByUserId(userId);

            if(isExisted) return IdCheckResponseDto.dupicateId();

        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return IdCheckResponseDto.success();
    }

    @Override
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto) {
        try{

            String userId = dto.getId();
            String email = dto.getEmail();


            boolean isExistId = userRepository.existsByUserId(userId);
            if(isExistId) return EmailCertificationResponseDto.duplicateId();

            boolean isExistEmail = userRepository.existsByEmail(email);
            if(isExistEmail) return EmailCertificationResponseDto.duplicateEmail();

            String certificationNumber = CertificationNumber.getCertificationNumber();

            boolean isSuccessed = emailProvider.sendCertificationMail(email, certificationNumber);
            if(!isSuccessed) return EmailCertificationResponseDto.mailSendFail();

            CertificationInfo info = new CertificationInfo(userId,email,certificationNumber);

            userRepository.saveCertificationInfo(info);

        } catch (Exception e){
            e.printStackTrace();

            return EmailCertificationResponseDto.mailSendFail();
        }

        return EmailCertificationResponseDto.success();
    }

    @Override
    public ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto) {
        try{

            String userId = dto.getId();
            String email = dto.getEmail();
            String certificationNumber = dto.getCertificationNumber();

            CertificationInfo userInfo = new CertificationInfo(userId,email,certificationNumber);

            userRepository.emailVerificationCodeIsTrue(userInfo);


        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return CheckCertificationResponseDto.success();
    }


}