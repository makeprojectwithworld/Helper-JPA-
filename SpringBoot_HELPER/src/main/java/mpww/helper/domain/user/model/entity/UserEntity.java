package mpww.helper.domain.user.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "user")
@Getter
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    private Long seq;
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String sex;
    private String gymName;

}
