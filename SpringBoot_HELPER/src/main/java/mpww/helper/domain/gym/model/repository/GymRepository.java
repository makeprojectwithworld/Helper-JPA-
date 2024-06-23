package mpww.helper.domain.gym.model.repository;

import mpww.helper.domain.gym.model.dto.Gym;
import mpww.helper.domain.gym.model.dto.GymDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {

    List<Gym> getAllGymList();

    Gym selectOneGym(String name);
}
