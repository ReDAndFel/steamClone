package org.steamclone.services.interfaces;

import org.steamclone.dtos.TagDTO;
import org.steamclone.models.entities.Tag;

import java.util.List;

public interface TagInterface {

    public List<TagDTO> listTagByIdGame(int idGame);
    public Tag getTag(int id);
}
