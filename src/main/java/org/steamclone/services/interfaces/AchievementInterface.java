package org.steamclone.services.interfaces;

import org.steamclone.dtos.AchievementDTO;
import org.steamclone.dtos.UserDTO;

import java.util.List;

public interface AchievementInterface {

    public int createAchievement(AchievementDTO achievementDTO) throws Exception;

    public int updateAchievement(int idAchievement, AchievementDTO achievementDTO) throws Exception;

    public  boolean deleteAchievemenet(int idAchievement) throws Exception;

    public List<AchievementDTO> listAchievementGame(int idGame);

    public List<AchievementDTO> listAchievementObteined(int idUser);

    public void addAchievementUser(int idAchievement, int idUser) throws Exception;

    List<AchievementDTO> listAchievementByIdGame(int idGame);

    public UserDTO getUserDTO(int idUser);

}
