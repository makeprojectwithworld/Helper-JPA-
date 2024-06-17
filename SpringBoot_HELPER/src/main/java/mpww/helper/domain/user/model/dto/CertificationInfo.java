package mpww.helper.domain.user.model.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CertificationInfo {
    @Id
    private String id;
    @Email
    private String email;
    private String certificationNumber;
}
