package org.steamclone.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter

public class ProfileCommentDTO {

    private int id;
    private int idUser;
    private String comment;
    private LocalDate date;
    private int idProfileUser;

    private  boolean state;

}
