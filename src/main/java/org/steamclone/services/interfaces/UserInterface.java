package org.steamclone.services.interfaces;

import org.springframework.stereotype.Repository;
import org.steamclone.dtos.ReviewDTO;
import org.steamclone.dtos.UserDTO;
import org.steamclone.models.entities.User;


public interface UserInterface {

    public int createUser(UserDTO userDTO) throws Exception;
    public int updateUser(int idUser, UserDTO userDTO) throws Exception;
    public boolean deleteUser(int idUser);
    public UserDTO findByNickName(String nickName);

    public UserDTO getUserDTO(int idUserDTO);
    public User getUser(int idUserDTO);

}
