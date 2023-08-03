package org.steamclone.services.interfaces;

import org.steamclone.dtos.ProfileCommentDTO;

import java.util.List;

public interface ProfileCommentInterface {


    public int createProfileComment(ProfileCommentDTO profileCommentDTO) throws Exception;

    public boolean deleteProfileComment(int idProfileComment) throws Exception;

    public List<ProfileCommentDTO> listProfileCommentIdUser(int idUser);

    public ProfileCommentDTO getProfileCOmmentDTO(int idProfileComment) throws Exception;

}