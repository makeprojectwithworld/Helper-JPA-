package mpww.helper.domain.gym.model.service;

import lombok.AllArgsConstructor;
import mpww.helper.domain.gym.model.dao.GymDao;
import mpww.helper.domain.gym.model.dto.GymDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class GymServiceImpl implements GymService{

    private final GymDao gymDao;

    @Override
    public List<GymDto> getAllgyms() {
        return gymDao.getAllGymList();
    }

    @Override
    public GymDto selectOneGym(String name) {
        return gymDao.selectOneGym(name);
    }
}
