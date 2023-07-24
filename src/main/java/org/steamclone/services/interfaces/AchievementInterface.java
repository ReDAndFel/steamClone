package org.steamclone.services.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.AchievementDTO;
import org.steamclone.dtos.UserDTO;

import java.util.List;

public interface AchievementInterface {

    public int createAchievement(AchievementDTO achievementDTO);

    public int updateAchievement(int achievement, AchievementDTO achievementDTO);

    public  int deleteAchievemenet(int achievement);

    public List<AchievementDTO> listAchievementGame(int idGame);

    public List<AchievementDTO> listAchievementObteined(int idUser);

    public void addAchievementUser(int idGame, int idUser);

    public UserDTO getUserDTO(int idUser);

}
