package mpww.helper.domain.gym.model.service;

import mpww.helper.domain.gym.model.dto.GymDto;

import java.util.List;

public interface GymService {

    List<GymDto> getAllgyms();

    GymDto selectOneGym(String gymName);
}
