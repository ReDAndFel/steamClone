package org.steamclone.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.ProfileCommentDTO;
import org.steamclone.models.entities.ProfileComment;
import org.steamclone.repositories.ProfileCommentRepo;
import org.steamclone.services.interfaces.ProfileCommentInterface;
import org.steamclone.services.interfaces.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileCommentInterfaceImpl implements ProfileCommentInterface {

    @Autowired
    ProfileCommentRepo profileCommentRepo;
    UserInterface userInterface;

    @Override
    public int createProfileComment(ProfileCommentDTO profileCommentDTO) throws Exception {

        ProfileComment profileComment = new ProfileComment();

        profileComment.setComment(profileCommentDTO.getComment());
        profileComment.setProfileUser(userInterface.getUser(profileCommentDTO.getIdProfileUser()));
        profileComment.setUser(userInterface.getUser(profileCommentDTO.getIdUser()));
        profileComment.setDate(LocalDate.now());
        profileCommentRepo.save(profileComment);

        return profileComment.getId();

    }

    @Override
    public boolean deleteProfileComment(int idProfileComment) throws Exception {

        Optional<ProfileComment> profileComment = profileCommentRepo.findById(idProfileComment);
        if(profileComment.isEmpty()){
            throw new Exception("No existe un comentario de perfil con el id " + idProfileComment);
        }

        ProfileComment profileCommentDelete = profileComment.get();

        profileCommentDelete.setState(false);

        return  profileCommentDelete.isState();
    }

    @Override
    public List<ProfileCommentDTO> listProfileCommentIdUser(int idUser) {
        List<ProfileComment> listProfileComment = profileCommentRepo.findAll();
        List<ProfileCommentDTO> listProfileCommentDTO = new ArrayList<>();

        for (ProfileComment profileComment: listProfileComment) {
            listProfileCommentDTO.add(converToDTO(profileComment));
        }

        return listProfileCommentDTO;
    }

    @Override
    public ProfileCommentDTO getProfileCOmmentDTO(int idProfileComment) throws Exception {
        Optional<ProfileComment> profileComment = profileCommentRepo.findById(idProfileComment);

        if(profileComment.isEmpty()){
            throw new Exception("El comentario de perfil con el id " + idProfileComment + " no existe");
        }

        return converToDTO(profileComment.get());
    }

    public ProfileCommentDTO converToDTO(ProfileComment profileComment) {
        ProfileCommentDTO profileCommentDTO = new ProfileCommentDTO(
                profileComment.getId(),
                profileComment.getUser().getId(),
                profileComment.getComment(),
                profileComment.getDate(),
                profileComment.getProfileUser().getId(),
                profileComment.isState()
        );

        return profileCommentDTO;
    }
}
