package org.steamclone.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.User;

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

}
