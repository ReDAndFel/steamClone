package org.steamclone.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.AchievementDTO;
import org.steamclone.dtos.UserDTO;
import org.steamclone.models.entities.Achievement;
import org.steamclone.models.entities.User;
import org.steamclone.repositories.AchievementRepo;
import org.steamclone.repositories.UserRepo;
import org.steamclone.services.interfaces.AchievementInterface;
import org.steamclone.services.interfaces.GameInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AchievementInterfaceImpl implements AchievementInterface {

    @Autowired
    GameInterface gameInterface;
    @Autowired
    AchievementRepo achievementRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public int createAchievement(AchievementDTO achievementDTO) throws Exception {

        Achievement achievement = new Achievement();
        achievement.setDescription(achievementDTO.getDescription());
        achievement.setName(achievementDTO.getName());
        achievement.setGame(gameInterface.getGame(achievementDTO.getIdGame()));

        achievementRepo.save(achievement);
        return achievement.getId() ;
    }

    @Override
    public int updateAchievement(int idAchievement, AchievementDTO achievementDTO) throws Exception {

        Optional<Achievement> foundAchievement = achievementRepo.findById(idAchievement);

        if(foundAchievement.isEmpty()){
            throw new Exception("El logro con id  " + idAchievement + "no se encontró");
        }

        Achievement updateAchievement = foundAchievement.get();

        updateAchievement.setName(achievementDTO.getName());
        updateAchievement.setDescription(achievementDTO.getDescription());
        updateAchievement.setGame(gameInterface.getGame(achievementDTO.getIdGame()));


        achievementRepo.save(updateAchievement);

        return updateAchievement.getId();
    }

    @Override
    public boolean deleteAchievemenet(int idAchievement) throws Exception {

        Optional<Achievement> foundAchievement = achievementRepo.findById(idAchievement);

        if(foundAchievement.isEmpty()){
            throw new Exception("El logro con id  " + idAchievement + "no se encontró");
        }

        Achievement updateAchievement = foundAchievement.get();

        updateAchievement.setState(false);

        return updateAchievement.isState();
    }

    @Override
    public List<AchievementDTO> listAchievementGame(int idGame) {

        List<Achievement> listAchievement = achievementRepo.listAchievementByIdGame(idGame);

        List<AchievementDTO> listAchievementDTO = new ArrayList<>();

        for (Achievement achievement: listAchievement) {
            listAchievementDTO.add(convertAchievementDTO(achievement));
        }

        return listAchievementDTO;
    }

    @Override
    public List<AchievementDTO> listAchievementObteined(int idUser) {

        List<Achievement> listAchievement = achievementRepo.listAchievementByIdUser(idUser);

        List<AchievementDTO> listAchievementDTO = new ArrayList<>();

        for (Achievement achievement: listAchievement) {
            listAchievementDTO.add(convertAchievementDTO(achievement));
        }

        return listAchievementDTO;
    }

    @Override
    public void addAchievementUser(int idAchievement, int idUser) throws Exception {

        Optional<Achievement> foundAchievement = achievementRepo.findById(idAchievement);
        Optional<User> foundUser = userRepo.findById(idUser);

        if (foundAchievement.isEmpty()) {
            throw new Exception("El logro con id " + idAchievement + " no existe");
        }
        if (foundUser.isEmpty()) {
            throw new Exception("El usuario con id " + idUser + " no existe");
        }

        Achievement achievement = foundAchievement.get();
        User user = foundUser.get();

        List<Achievement> listAchievements = user.getAchievements();
        listAchievements.add(achievement);
        user.setAchievements(listAchievements);
        List<Achievement> newListAchievements = user.getAchievements();
        List<AchievementDTO> listAchievementDTO = new ArrayList<>();

        for (Achievement achievementUser : newListAchievements){
            listAchievementDTO.add(convertToGetDTO(achievementUser));
        }

    }

    private AchievementDTO convertToGetDTO(Achievement achievement) {

        AchievementDTO achievementDTO = new AchievementDTO(
                achievement.getId(),
                achievement.getName(),
                achievement.getDescription(),
                achievement.getGame().getId(),
                achievement.isState()
        );

        return achievementDTO;
    }

    @Override
    public List<AchievementDTO> listAchievementByIdGame(int idGame) {

        List<Achievement> listAchievements = achievementRepo.listAchievementByIdGame(idGame);
        List<AchievementDTO> listAchievementDTO = new ArrayList<>();

        for (Achievement achievement : listAchievements) {
            listAchievementDTO.add(convertToGetDTO(achievement));
        }

        return listAchievementDTO;

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
                achievement.getGame().getId(),
                achievement.isState()
        );

        return achievementDTO;
    }
}
