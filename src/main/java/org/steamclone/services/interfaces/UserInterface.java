package org.steamclone.services.interfaces;

import org.steamclone.dtos.UserDTO;
import org.steamclone.models.entities.User;


public interface UserInterface {

    public int createUser(UserDTO userDTO) throws Exception;
    public int updateUser(int idUser, UserDTO userDTO) throws Exception;
    public boolean deleteUser(int idUser) throws Exception;
    public UserDTO findByNickName(String nickName) throws Exception;

    public UserDTO getUserDTO(int idUserDTO) throws Exception;
    public User getUser(int idUser) throws Exception;

}
