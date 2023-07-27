package org.steamclone.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int id;
    private String name;
    private String nickname;
    private String cellphoneNumber;
    private String email;
    private LocalDate birthday;
    private String password;
    private int level;
    private String country;
    private Rol rol;
    private  boolean state;

}
