package org.steamclone.services.interfaces;

import org.steamclone.dtos.ImageDTO;

import java.util.List;

public interface ImageInterface {
    List<ImageDTO> listImageGame (int idGame);

}
