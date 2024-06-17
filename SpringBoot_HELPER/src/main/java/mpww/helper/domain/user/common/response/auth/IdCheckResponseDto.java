package mpww.helper.domain.user.common.response.auth;


import jakarta.persistence.Id;
import lombok.Getter;
import mpww.helper.domain.user.common.response.ResponseCode;
import mpww.helper.domain.user.common.response.ResponseDto;
import mpww.helper.domain.user.common.response.ResponseMessage;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class IdCheckResponseDto extends ResponseDto {

    private IdCheckResponseDto(){
        super();
    }
    public static ResponseEntity<IdCheckResponseDto> success(){
        IdCheckResponseDto responseBody = new IdCheckResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> dupicateId(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
