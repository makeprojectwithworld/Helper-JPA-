package mpww.helper.domain.gym.model.service;

import lombok.AllArgsConstructor;
import mpww.helper.domain.gym.model.dao.GymRepository;
import mpww.helper.domain.gym.model.dto.GymDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class GymServiceImpl implements GymService{

    private final GymRepository gymRepository;

    @Override
    public List<GymDto> getAllgyms() {
        return gymRepository.getAllGymList();
    }

    @Override
    public GymDto selectOneGym(String name) {
        return gymRepository.selectOneGym(name);
    }
}
