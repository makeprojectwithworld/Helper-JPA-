package mpww.helper.domain.gym.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity (name = "gym")
@Getter
@Setter
@NoArgsConstructor
public class GymEntity {
    @Id
    @GeneratedValue
    private Long seq;
    private String name;
    private String address;
    private String phoneNumber;



}
