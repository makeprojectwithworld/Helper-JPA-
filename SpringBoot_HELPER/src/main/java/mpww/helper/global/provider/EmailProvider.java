package mpww.helper.global.provider;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@AllArgsConstructor
public class EmailProvider {

    private final JavaMailSender javaMailSender;
    private final String SUBJECT = "[HELPER] 가입 인증 메일입니다.";

    public boolean sendCertificationMail(String email, String certificationNumber){

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);

            String htmlContent = getCertificationMessage(certificationNumber);

            messageHelper.setTo(email);
            messageHelper.setSubject(SUBJECT);
            messageHelper.setText(htmlContent, true);

            javaMailSender.send(message);


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private String getCertificationMessage(String certificationNumber){
        String certificationMessage = "";
        certificationMessage += "<h1 style= 'text-align: center;'> [나만의 헬스메이트 찾기 HELPER] 인증 메일</h1>";
        certificationMessage += "<h3 style= 'text-align: center;'> 인증코드 : <strong style= 'font-size: 32px; letter-spacing: 8px;'>" + certificationNumber + "</stong></h3>";
        return certificationMessage;
    }
}
