package mpww.helper.domain.gym.model.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity (name = "gym")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gym {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    String address;
}
