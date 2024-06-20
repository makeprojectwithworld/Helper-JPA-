package mpww.helper.domain.user.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ValueGenerationType;

@Entity(name = "user")
@Getter
@NoArgsConstructor
@ToString
public class UserEntity {

    @Id
    private Long seq;
    @Column(name = "id",nullable = false)
    private String id;
    @Column(nullable = false)
    private String password;
    private String nickname;
    private String email;
    private String sex;
    private String gymName;

}
