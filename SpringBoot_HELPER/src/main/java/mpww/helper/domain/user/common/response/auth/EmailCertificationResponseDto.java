package mpww.helper.domain.user.common.response.auth;

import lombok.Getter;
import mpww.helper.domain.user.common.response.ResponseCode;
import mpww.helper.domain.user.common.response.ResponseDto;
import mpww.helper.domain.user.common.response.ResponseMessage;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Getter
public class EmailCertificationResponseDto extends ResponseDto {

    private EmailCertificationResponseDto(){
        super();
    }
    public static ResponseEntity<EmailCertificationResponseDto> success(){
        EmailCertificationResponseDto responseBody = new EmailCertificationResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> duplicateId(){
        return IdCheckResponseDto.dupicateId();
    }


    public static ResponseEntity<ResponseDto> mailSendFail(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.MAIL_FAIL, ResponseMessage.MAIL_FAIL);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> duplicateEmail(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.MAIL_FAIL, ResponseMessage.MAIL_FAIL);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

}
