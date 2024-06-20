package mpww.helper.domain.gym.model.dao;

import mpww.helper.domain.gym.model.dto.GymDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GymRepository extends JpaRepository<GymDto, Long> {

    List<GymDto> getAllGymList();

    GymDto selectOneGym(String name);
}
