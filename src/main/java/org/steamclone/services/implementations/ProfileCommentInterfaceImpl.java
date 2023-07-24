package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.ProfileCommentDTO;
import org.steamclone.models.entities.ProfileComment;
import org.steamclone.services.interfaces.ProfileCommentInterface;

import java.util.List;
@Service
public class ProfileCommentInterfaceImpl implements ProfileCommentInterface {
    @Override
    public int createProfileComment(ProfileComment profileComment) {
        return 0;
    }

    @Override
    public int deleteProfileComment(int idProfileComment) {
        return 0;
    }

    @Override
    public List<ProfileCommentDTO> listProfileCommentIdUser(int idUser) {
        return null;
    }

    @Override
    public ProfileCommentDTO getProfileCOmmentDTO(int idProfileComment) {
        return null;
    }
}
