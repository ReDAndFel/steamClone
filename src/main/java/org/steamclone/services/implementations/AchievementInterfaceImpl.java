package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.AchievementDTO;
import org.steamclone.dtos.UserDTO;
import org.steamclone.models.entities.Achievement;
import org.steamclone.services.interfaces.AchievementInterface;

import java.util.List;

@Service
public class AchievementInterfaceImpl implements AchievementInterface {
    @Override
    public int createAchievement(AchievementDTO achievementDTO) {
        return 0;
    }

    @Override
    public int updateAchievement(int achievement, AchievementDTO achievementDTO) {
        return 0;
    }

    @Override
    public int deleteAchievemenet(int achievement) {
        return 0;
    }

    @Override
    public List<AchievementDTO> listAchievementGame(int idGame) {
        return null;
    }

    @Override
    public List<AchievementDTO> listAchievementObteined(int idUser) {
        return null;
    }

    @Override
    public void addAchievementUser(int idGame, int idUser) {

    }

    @Override
    public UserDTO getUserDTO(int idUser) {
        return null;
    }

    public AchievementDTO convertAchievementDTO(Achievement achievement) {
        AchievementDTO achievementDTO = new AchievementDTO(
                achievement.getId(),
                achievement.getName(),
                achievement.getDescription(),
                achievement.getGame().getId()
        );

        return achievementDTO;
    }
}
