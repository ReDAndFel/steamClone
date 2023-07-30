package org.steamclone.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.UserDTO;
import org.steamclone.models.entities.Rol;
import org.steamclone.models.entities.User;
import org.steamclone.repositories.UserRepo;
import org.steamclone.services.interfaces.UserInterface;

import java.util.Optional;

@Service
public class UserInterfaceImpl implements UserInterface {

    @Autowired
    UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int createUser(UserDTO userDTO) throws Exception {

        User flagEmail = userRepo.findByEmail(userDTO.getEmail());

        if (flagEmail != null){
            throw new Exception("El email " + userDTO.getEmail() + " ya existe");
        }

        User user = new User();
        user.setBirthday(userDTO.getBirthday());
        user.setEmail(userDTO.getEmail());
        user.setCountry(userDTO.getCountry());
        user.setLevel(userDTO.getLevel());
        user.setCellphoneNumber(userDTO.getCellphoneNumber());
        user.setName(userDTO.getName());
        user.setNickname(userDTO.getNickname());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRol(Rol.valueOf("USER"));
        user.setState(true);

        userRepo.save(user);

        return user.getId();
    }

    @Override
    public int updateUser(int idUser, UserDTO userDTO) throws Exception {
        Optional<User> foundUser = userRepo.findById(idUser);

        if (foundUser.isEmpty()) {
            throw new Exception("El usuario con id " + idUser + " no existe");
        }

        User updateUser = foundUser.get();

        updateUser.setBirthday(userDTO.getBirthday());
        updateUser.setEmail(userDTO.getEmail());
        updateUser.setCountry(userDTO.getCountry());
        updateUser.setCellphoneNumber(userDTO.getCellphoneNumber());
        updateUser.setName(userDTO.getName());
        updateUser.setNickname(userDTO.getNickname());
        updateUser.setPassword(userDTO.getPassword());

        userRepo.save(updateUser);

        return updateUser.getId();
    }

    @Override
    public boolean deleteUser(int idUser) {
        return false;
    }

    @Override
    public UserDTO findByNickName(String nickName) {
        return null;
    }

    @Override
    public UserDTO getUserDTO(int idUserDTO) {


        return null;
    }

    @Override
    public User getUser(int idUserDTO) {
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
                user.getRol(),
                user.isState()
        );

        return userDTO;
    }
}
