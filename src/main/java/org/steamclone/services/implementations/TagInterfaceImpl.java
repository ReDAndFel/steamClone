package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.TagDTO;
import org.steamclone.models.entities.Business;
import org.steamclone.models.entities.Tag;
import org.steamclone.repositories.TagRepo;
import org.steamclone.services.interfaces.GameInterface;
import org.steamclone.services.interfaces.TagInterface;

import java.util.ArrayList;
import java.util.List;
@Service
public class TagInterfaceImpl implements TagInterface {
    GameInterface gameInterface;
    TagRepo tagRepo;

    @Override
    public List<TagDTO> listTagByIdGame(int idGame) {

        List<Tag> listTags = tagRepo.listTagByIdGame(idGame);

        List<TagDTO> listTagDTO = new ArrayList<>();

        for (Tag tag: listTags ) {
            listTagDTO.add(convertToDTO(tag));
        }

        return listTagDTO;
    }

    @Override
    public Tag getTag(int id) {
        return tagRepo.getTag(id);
    }

    public TagDTO convertToDTO (Tag tag){
        TagDTO tagDTO = new TagDTO(
                tag.getId(),
                tag.getName()
        );

        return  tagDTO;
    }
}
