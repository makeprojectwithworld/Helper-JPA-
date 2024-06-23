package mpww.helper.domain.gym.model.service;

import lombok.AllArgsConstructor;
import mpww.helper.domain.gym.model.dto.Gym;
import mpww.helper.domain.gym.model.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class GymServiceImpl implements GymService{

    private final GymRepository gymRepository;

    @Override
    public List<Gym> getAllgyms() {
        return gymRepository.getAllGymList();
    }

    @Override
    public Gym selectOneGym(String name) {
        return gymRepository.selectOneGym(name);
    }
}
