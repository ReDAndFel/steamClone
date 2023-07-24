package org.steamclone.services.interfaces;

import org.springframework.stereotype.Repository;
import org.steamclone.dtos.ReviewDTO;
import org.steamclone.dtos.UserDTO;


public interface UserInterface {

    public String createUser(UserDTO userDTO);
    public String updateUser(String idUser, UserDTO userDTO);
    public String deleteUser(String idUser);
    public UserDTO findByNickName(String nickName);

    public UserDTO getUserDTO(int idUserDTO);

}
