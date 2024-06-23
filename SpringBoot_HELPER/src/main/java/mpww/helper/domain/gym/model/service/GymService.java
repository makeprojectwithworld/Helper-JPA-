package mpww.helper.domain.gym.model.service;

import mpww.helper.domain.gym.model.dto.Gym;

import java.util.List;

public interface GymService {

    List<Gym> getAllgyms();

    Gym selectOneGym(String gymName);
}
