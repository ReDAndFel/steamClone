package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.UserDTO;
import org.steamclone.models.entities.User;
import org.steamclone.services.interfaces.UserInterface;
@Service
public class UserInterfaceImpl implements UserInterface {
    @Override
    public String createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public String updateUser(String idUser, UserDTO userDTO) {
        return null;
    }

    @Override
    public String deleteUser(String idUser) {
        return null;
    }

    @Override
    public UserDTO findByNickName(String nickName) {
        return null;
    }

    @Override
    public UserDTO getUserDTO(int idUserDTO) {
        return null;
    }

    public UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName(),
                user.getNickname(),
                user.getCellphoneNumber(),
                user.getEmail(),
                user.getBirthday(),
                user.getPassword(),
                user.getLevel(),
                user.getCountry(),
                user.getRol()
        );

        return userDTO;
    }
}
