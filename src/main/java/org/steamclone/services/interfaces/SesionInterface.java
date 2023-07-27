package org.steamclone.services.interfaces;

import org.steamclone.dtos.SesionDTO;
import org.steamclone.dtos.TokenDTO;

public interface SesionInterface {

    public TokenDTO login(SesionDTO sesionDTO);
    public void logout(int idUser);

}
