package org.steamclone.services.interfaces;

import org.steamclone.dtos.ProfileCommentDTO;
import org.steamclone.models.entities.PaymentMethod;
import org.steamclone.models.entities.ProfileComment;

import java.util.List;

public interface ProfileCommentInterface {

    public int createProfileComment(ProfileComment profileComment);
    public int deleteProfileComment(int idProfileComment);

    public List<ProfileCommentDTO> listProfileCommentIdUser(int idUser);

    public ProfileCommentDTO getProfileCOmmentDTO(int idProfileComment);


}
